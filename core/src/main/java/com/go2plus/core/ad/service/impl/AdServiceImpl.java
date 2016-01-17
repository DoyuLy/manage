package com.go2plus.core.ad.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.go2plus.core.ad.service.AdService;
import com.go2plus.core.promotion.dao.PromotionDao;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.vo.SupplierRank;

@Service
public class AdServiceImpl implements AdService {
  
  @Resource
  private SupplierDao supplierDao;
  
  @Resource
  private PromotionDao promotionDao;
  
  @Override
  public Boolean isTop100Supplier(Integer userId) {
    SupplierRank supplierRank = supplierDao.getSupplierRankByUserId(userId);
    
    if (supplierRank != null) {
      if (supplierRank.getRank() <= 100) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
    
  }

  @Override
  public Integer checkSPRule(Date startTime, Integer userId) {
    Promotion promotion = promotionDao.getPromotionByStartTimeAndUserId(startTime, userId);
    
    if(promotion != null) {
      return promotion.getNum();
    }
    else {
      return 0;
    }
  }

  @Override
  public List<Promotion> getOrderedSPsBy(Date startDate) {
    List<Promotion> promotionList = promotionDao.getOrderedSPsBy(startDate);
    
    return promotionList;
  }

  @Override
  public List<SupplierRank> getTop500() {
    // TODO billboard()
    return supplierDao.getTop500();
  }

  @Override
  public List<Promotion> getFPsByUser(Integer userId, Boolean valid) {
    List<Promotion> promitionList = promotionDao.getFPsByUser(userId, valid);
    
    // TODO getFPsByUser()
    return null;
  }

  @Override
  public List<Promotion> getStFPsByUser(Integer userId, Boolean valid) {
    List<Promotion> promitionList = promotionDao.getStFPsByUser(userId, valid);
    
    // TODO getStFPsByUser()
    return null;
  }

  @Override
  public List<Promotion> getSuList(String pos) {
    List<Promotion> promotionList = promotionDao.getSuList(pos);
    
    //TODO 具体逻辑 sulist()
    return null;
  }

  @Override
  public List<Promotion> getOrderedFPs() {
    String FP_STRING = "c1|c2|c3|c4|c5|c6|c7|c8|c9|c10|c11|c12|d1|d2|d3|d4|d5|d6|d7|d8|d9|d10|d11|d12|i1|i2|i3|i4|i5|i6|i7|i8|i9|i10|i11|i12|j1|j2|j3|j4|j5|j6|j7|j8|j9|j10|j11|j12|k1|k2|k3|k4|k5|k6|k8|k9|k10|k11|k12|o1|o2|o3|o4|o5|o6|o8|o9|o10|o11|o12|p1|p2|p3|p4|p5|p6|p7|p8|p9|p10|p11|p12|q1|q2|q3|q4|q5|q6|q7|q8|q9|q10|q11|q12|r1|r2|r3|r4|r5|r6|r7|r8|r9|r10|r11|r12|s1|s2|s3|s4|s5|s6|s7|s8|s9|s10|s11|s12";
    List<Promotion> promotionList = promotionDao.getOrderedFPs(FP_STRING);
    return null;
  }

  @Override
  public void getAvaiableFPs(Date lastDay, Date startTime, List<Promotion> promotionList) {
    
  } 

}
