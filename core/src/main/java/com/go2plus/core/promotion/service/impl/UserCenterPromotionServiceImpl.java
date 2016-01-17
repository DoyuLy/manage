package com.go2plus.core.promotion.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.go2plus.common.json.Json;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.product.vo.Site;
import com.go2plus.core.promotion.dao.PromotionDao;
import com.go2plus.core.promotion.service.UserCenterPromotionService;
import com.go2plus.core.promotion.service.ValidatorService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.OrderedFPs;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.vo.Supplier;

@Service
public class UserCenterPromotionServiceImpl implements UserCenterPromotionService {

  @Autowired
  private SupplierDao         supplierDao;

  @Autowired
  private PromotionDao        promotionDao;
  @Autowired
  private ValidatorService    validatorService;
  private static final String FP_STRING = " ";

  @Override
  public int checkSPRule(Date startTime, Integer userId) {
    // TODO Auto-generated method stub
    return promotionDao.getNumByStartTimeAndUserId(startTime, userId);
  }

  @Override
  public TreeMap<String, Promotion> getOrderedUCsBy(Date startTime) {
    // TODO Auto-generated method stub
    TreeMap<String, Promotion> map = new TreeMap<>();
    List<Promotion> list = promotionDao.getOrderedUCsBy(startTime);
    if (list != null) {
      for (Promotion promotion : list) {
        map.put(promotion.getPosX(), promotion);
      }
    }
    return map;
  }

  @Override
  public List<AdPosition> getUCsBy(String type) {
    return promotionDao.getAD(type);
  }

  @Override
  public boolean addFP(Promotion promotion) {
    // TODO Auto-generated method stub
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
  public boolean getFP(Date startTime, Integer userId, String posX) {
    // TODO Auto-generated method stub
    int result = promotionDao.getFP(startTime, userId, posX);
    if (result > 0) {
      return true;
    }
    return false;
  }

  @Override
  public Supplier getByUserIdFromRedis(Integer userId) {
    // TODO Auto-generated method stub
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
  public Supplier getByUserId(Integer userId) {
    // TODO Auto-generated method stub
    return supplierDao.getByUserId(userId);
  }

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
  /**
   * 抢到广告删除ad_postion数据
   */
  public boolean delAD(String posX, String startTime, String type) {
    if (promotionDao.delAD(posX, startTime, type) == 1)
      return true;
    return false;
  }
}
