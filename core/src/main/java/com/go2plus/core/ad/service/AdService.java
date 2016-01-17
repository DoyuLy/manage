package com.go2plus.core.ad.service;

import java.util.Date;
import java.util.List;

import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.vo.SupplierRank;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * AdService Service
 * 
 * @author yuyanlin
 * @since 2015-11-18
 */

public interface AdService {
  
  /**
   * 判断是否为TOP100厂家
   * 
   * @param userId
   * @return
   */
  public Boolean isTop100Supplier(Integer userId);
  
  /**
   * 检查search result广告的权限
   * 
   * @param date
   * @param userId
   * @return
   */
  public Integer checkSPRule(Date date, Integer userId);
  
  /**
   * 获取已经订购的搜索结果广告
   * 
   * @param startDate
   * @return
   */
  public List<Promotion> getOrderedSPsBy(Date startDate);
  
  /**
   * 获取前500厂家积分
   * 
   * @return
   */
  public List<SupplierRank> getTop500();
  
  /**
   * 获取用户已经订购的推荐位广告 
   * 
   * @param userId
   * @param valid
   * @return
   */
  public List<Promotion> getFPsByUser(Integer userId, Boolean valid);
  
  /**
   * 获取厂家精品板块广告位
   * 
   * @param userId
   * @param valid
   * @return
   */
  public List<Promotion> getStFPsByUser(Integer userId, Boolean valid);
  
  /**
   * 获取市场商家广告
   * 
   * @param pos
   * @return
   */
  public List<Promotion> getSuList(String pos);
  
  /**
   * 按月份获取推荐位广告
   * 
   * @return
   */
  public List<Promotion> getOrderedFPs();
  
  /**
   * 获取可用的产品推荐位广告
   * 
   * @param lastDay
   * @param startTime
   * @param promotionList
   */
  public void getAvaiableFPs(Date lastDay, Date startTime, List<Promotion> promotionList);
}
