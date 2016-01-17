package com.go2plus.core.promotion.service.impl;

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
import com.go2plus.core.promotion.service.MarketPromotionService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.vo.Supplier;

@Service
public class MarketPromotionServiceImpl implements MarketPromotionService {

  @Autowired
  private SupplierDao  supplierDao;

  @Autowired
  private PromotionDao promotionDao;

  @Override
  public int checkSPRule(Date startTime, Integer userId) {
    return promotionDao.getNumByStartTimeAndUserId(startTime, userId);
  }

  @Override
  public TreeMap<String, Promotion> getOrderedMRsBy(Date startTime) {
    TreeMap<String, Promotion> map = new TreeMap<>();
    List<Promotion> list = promotionDao.getOrderedMRsBy(startTime);
    if (list != null) {
      for (Promotion promotion : list) {
        map.put(promotion.getPosX(), promotion);
      }
    }
    return map;
  }

  @Override
  public List<AdPosition> getMRsBy(String type) {
    return promotionDao.getAD(type);
  }

  @Override
  public boolean addFP(Promotion promotion) {
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
    int result = promotionDao.getFP(startTime, userId, posX);
    if (result > 0) {
      return true;
    }
    return false;
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
  public Supplier getByUserId(Integer userId) {
    return supplierDao.getByUserId(userId);
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
