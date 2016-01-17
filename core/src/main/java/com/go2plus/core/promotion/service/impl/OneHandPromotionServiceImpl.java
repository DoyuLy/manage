package com.go2plus.core.promotion.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.go2plus.common.http.SearchEnginUtil;
import com.go2plus.common.json.Json;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.product.vo.Site;
import com.go2plus.core.promotion.dao.PromotionDao;
import com.go2plus.core.promotion.service.OneHandPromotionService;
import com.go2plus.core.promotion.service.ValidatorService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.OrderedFPs;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.vo.Supplier;

@Service
public class OneHandPromotionServiceImpl implements OneHandPromotionService {

  // 推荐广告位
  private static final String FP_STRING = "c1|c2|c3|c4|c5|c6|c7|c8|c9|c10|c11|c12|d1|d2|d3|d4|d5|d6|d7|d8|d9|d10|d11|d12|i1|i2|i3|i4|i5|i6|i7|i8|i9|i10|i11|i12|j1|j2|j3|j4|j5|j6|j7|j8|j9|j10|j11|j12|k1|k2|k3|k4|k5|k6|k8|k9|k10|k11|k12|o1|o2|o3|o4|o5|o6|o8|o9|o10|o11|o12|p1|p2|p3|p4|p5|p6|p7|p8|p9|p10|p11|p12|q1|q2|q3|q4|q5|q6|q7|q8|q9|q10|q11|q12|r1|r2|r3|r4|r5|r6|r7|r8|r9|r10|r11|r12|s1|s2|s3|s4|s5|s6|s7|s8|s9|s10|s11|s12";

  private String              esHost    = "http://125.64.14.22:9200/promotions/promotion";

  @Autowired
  private SupplierDao         supplierDao;

  @Autowired
  private PromotionDao        promotionDao;

  @Autowired
  private ValidatorService    validatorService;

  @Override
  public List<Promotion> getAvaiableFPs(Date lastDay, Date startTime, List<Promotion> occu) {
    if (startTime.after(lastDay)) {
      return null;
    }
    List<Promotion> list = new ArrayList<>();

    // 向前增加的周数
    int weekNum = validatorService.getWeekNum(lastDay, startTime);
    for (int i = 0; i < weekNum; i++) {
      Date date = validatorService.addWeek(startTime, i);
      boolean hasOccu = false;
      if (occu != null) {
        for (Promotion promotion : occu) {
          if (date == promotion.getStartTime()) {
            hasOccu = true;
            break;
          }
        }
      }
      if (!hasOccu) {
        Promotion promotion = new Promotion();
        promotion.setStartTime(date);
        promotion.setEndTime(validatorService.addWeek(date, 1));
        list.add(promotion);
      }
    }
    return list;
  }

  @Override
  public OrderedFPs getOrderedFPs() {
    List<Promotion> list = promotionDao.getOrderedFPs(FP_STRING);
    // 位置最早的结束时间
    TreeMap<String, Date> data = new TreeMap<>();
    // 位置被占用
    TreeMap<String, List<Promotion>> occu = new TreeMap<>();
    // 是否中断
    TreeMap<String, Integer> term = new TreeMap<>();

    if (list != null) {
      for (Promotion promotion : list) {
        if (!validatorService.isSet(data, promotion.getPosX())) {
          data.put(promotion.getPosX(), promotion.getEndTime());
        } else {
          // 覆盖结束时间
          if (promotion.getStartTime() == data.get(promotion.getPosX())) {
            if (validatorService.isSet(term, promotion.getPosX())) {
              List<Promotion> promotions = occu.get(promotion.getPosX());
              if (promotions == null) {
                promotions = new ArrayList<>();
              }
              promotions.add(promotion);
              occu.put(promotion.getPosX(), promotions);
            } else {
              data.put(promotion.getPosX(), promotion.getEndTime());
            }
          } else {
            term.put(promotion.getPosX(), 1);
            List<Promotion> promotions = occu.get(promotion.getPosX());
            if (promotions == null) {
              promotions = new ArrayList<>();
            }
            promotions.add(promotion);
            occu.put(promotion.getPosX(), promotions);
          }
        }
      }
      OrderedFPs fPs = new OrderedFPs();
      fPs.setData(data);
      fPs.setOccu(occu);
      fPs.setTerm(term);
      return fPs;
    }
    return null;
  }

  @Override
  public List<AdPosition> getOnsBy(String type) {
    return promotionDao.getAD(type);
  }

  @Override
  public List<String> getDeletedFPs(Integer seconds) throws Exception {
    if (seconds == null) {
      seconds = 600;
    }
    List<String> list = new ArrayList<>();
    List<Promotion> promotions = promotionDao.getDeletedFPs(seconds);
    if (list != null) {
      for (Promotion promotion : promotions) {
        list.add(promotion.getPosX() + "_" + validatorService.toDate(promotion.getStartTime()));
      }
    }
    return list;
  }

  @Override
  public Integer getFPsByUserId(Integer userId, Date startTime, Date endTime, Integer operatorId) {
    return promotionDao.getFPsNumByUserId(FP_STRING, userId, startTime, endTime, operatorId);
  }

  @Override
  public Boolean addFP(Promotion promotion) {
    if (promotion.getTotalFee() == null) {
      promotion.setTotalFee(1000);
    }
    if (promotion.getDiscount() == null) {
      promotion.setDiscount(1.0);
    }
    int result = promotionDao.addFP(promotion);
    if (result > 0) {
      return true;
    }
    return false;
  }

  @Override
  public Boolean checkFPRule(String posX, Date startTime, Integer userId) {
    List<Promotion> list = promotionDao.getFPs(posX, startTime, validatorService.addWeek(startTime, 1), userId);
    Promotion promotion = null;
    if (list != null && list.size() >= 2) {
      return false;
    } else if (list.size() == 1) {
      promotion = list.get(0);
    }
    // 连续广告时间不能超过10天
    if (promotion != null) {

      Date start = min(promotion.getStartTime(), startTime);
      Date end = max(promotion.getEndTime(), validatorService.addWeek(startTime, 1));
      long days = (end.getTime() - start.getTime()) / 86400 * 1000;
      if (days > 10) {
        return false;
      }
    }
    return true;
  }

  private Date min(Date date1, Date date2) {
    if (date1.before(date2)) {
      return date1;
    }
    return date2;
  }

  private Date max(Date date1, Date date2) {
    if (date1.after(date2)) {
      return date1;
    }
    return date2;
  }

  @Override
  public Boolean checkFPRuleFromRedis(String posX, String startTime, Integer userId) throws Exception {
    JSONObject query = new JSONObject();
    query.put("from", 0);
    query.put("size", 5);

    JSONArray must = new JSONArray();

    must.add(0, newJsonObject("term", newJsonObject("state", 1)));
    must.add(1, newJsonObject("term", newJsonObject("user_id", userId)));
    must.add(2, newJsonObject("regexp", newJsonObject("pos_x", FP_STRING)));

    JSONObject bool = new JSONObject();
    bool.put("must", must);
    query.put("query", newJsonObject("bool", must));

    JSONObject range = new JSONObject();
    range
        .put("start_time", newJsonObject("gte", validatorService.toDate(validatorService.addWeek(validatorService.toDate(startTime), -1))));
    range.put("end_time", newJsonObject("lte", validatorService.toDate(validatorService.addWeek(validatorService.toDate(startTime), 2))));
    query.put("filter", newJsonObject("range", range));

    JSONObject data = JSON.parseObject(SearchEnginUtil.post(esHost + "/_search", Json.toJson(query)));
    if (data != null) {
      JSONObject hits = data.getJSONObject("hits");
      Promotion promotion = null;
      int total = hits.getIntValue("total");
      if (total >= 2) {
        return false;
      } else if (total == 1) {
        promotion = (Promotion) hits.getJSONArray("hits").get(0);
      }
      // 连续广告时间不能超过10天
      if (promotion != null) {

        Date start = min(promotion.getStartTime(), validatorService.toDate(startTime));
        Date end = max(promotion.getEndTime(), validatorService.addWeek(validatorService.toDate(startTime), 1));
        long days = (end.getTime() - start.getTime()) / 86400 * 1000;
        if (days > 10) {
          return false;
        }
      }
    }
    return true;
  }

  private JSONObject newJsonObject(String key, Object value) {
    JSONObject object = new JSONObject();
    object.put(key, value);
    return object;
  }

  @Override
  public Boolean addFpFromRedis(Promotion promotion) {
    SearchEnginUtil.post(esHost + "/" + promotion.getId(), Json.toJson(promotion));
    return true;
  }

  @Override
  public List<String> getDeletedFPsFromRedis(Integer seconds) throws Exception {
    List<String> list = new ArrayList<>();
    if (seconds != null) {
      seconds = 600;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    JSONObject query = new JSONObject();
    query.put("from", 0);
    query.put("size", 1000);
    query.put("query", newJsonObject("term", newJsonObject("state", 1)));

    JSONObject range = new JSONObject();
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.SECOND, Integer.valueOf("-" + seconds));
    range.put("start_time", newJsonObject("gte", dateFormat.format(calendar.getTime())));
    range.put("end_time", newJsonObject("lte", dateFormat.format(new Date())));
    query.put("filter", newJsonObject("range", range));

    JSONObject data = JSON.parseObject(SearchEnginUtil.post(esHost + "/_search", Json.toJson(query)));
    if (data != null) {
      JSONObject hits = data.getJSONObject("hits");
      for (Object obj : hits.getJSONArray("hits").toArray()) {
        Promotion promotion = (Promotion) ((JSONObject) obj).get("_source");
        list.add(promotion.getPosX() + "_" + validatorService.toDate(promotion.getStartTime()));
      }
    }
    return list;
  }

  @Override
  public Supplier getByUserIdFromRedis(Integer userId) {
    Jedis redis = RedisUtil.getPool().getResource();
    Supplier supplier = (Supplier) Json.fromJson(redis.hget("suppliers", "supplier" + userId), Supplier.class);
    if (supplier != null) {
      Site site = (Site) Json.fromJson(redis.hget("sites", "site" + userId), Site.class);
      if (site != null) {
        supplier.setSite(site);
      }
    }
    return supplier;
  }

  @Override
  public Promotion isAvaiableFPFromRedis(String posX, String startTime) {
    Jedis redis = RedisUtil.getPool().getResource();
    String avaiable = redis.hget("avaiableFPs", posX + "_" + startTime);
    return (Promotion) Json.fromJson(avaiable, Promotion.class);
  }

  @Override
  public Supplier getByUserId(Integer userId) {
    return supplierDao.getByUserId(userId);
  }

  @Override
  public Integer getFPsByUserIdFromRedis(Integer userId, Date startTime, Date endTime, Integer operatorId) throws Exception {
    JSONObject query = new JSONObject();
    query.put("from", 0);
    query.put("size", 5);

    JSONArray must = new JSONArray();

    must.add(0, newJsonObject("term", newJsonObject("state", 1)));
    must.add(1, newJsonObject("term", newJsonObject("user_id", userId)));
    must.add(2, newJsonObject("regexp", newJsonObject("pos_x", FP_STRING)));

    JSONObject bool = new JSONObject();
    bool.put("must", must);
    query.put("query", newJsonObject("bool", must));

    JSONObject range = new JSONObject();
    range.put("start_time", newJsonObject("gte", validatorService.toDate(startTime)));
    range.put("end_time", newJsonObject("lte", validatorService.toDate(endTime)));
    query.put("filter", newJsonObject("range", range));

    JSONObject data = JSON.parseObject(SearchEnginUtil.post(esHost + "/_search", Json.toJson(query)));
    if (data != null) {
      JSONObject hits = data.getJSONObject("hits");
      return hits.getIntValue("total");
    }
    return 0;
  }

  @Override
  /**
   * 抢到广告删除ad_postion数据
   */
  public boolean delAD(String posX, String startTime, String type) {
    if (promotionDao.delAD(posX, startTime, type) == 1)
      return true;
    return false;
  }
}
