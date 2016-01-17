package com.go2plus.core.promotion.service;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.vo.Supplier;

public interface SearchResultPagePromotionService {

  /**
   * 获取商家信息
   * 
   * @param userId
   * @return
   */
  public Supplier getByUserId(Integer userId);

  /**
   * 使用Redis获取商户信息
   * 
   * @param userId
   * @return
   */
  public Supplier getByUserIdFromRedis(Integer userId);

  /**
   * 判断是否拥有订购用户中心广告的权限
   * 
   * @param startTime
   * @param userId
   * @return
   */
  public int checkSPRule(Date startTime, Integer userId);

  /**
   * 获取已订购的用户中心广告
   * 
   * @param startTime
   * @return
   */
  public TreeMap<String, Promotion> getOrderedSRsBy(Date startTime);

  /**
   * 新表获取已订购的用户中心广告
   * 
   * @param startTime
   * @return
   */
  public List<AdPosition> getSRsBy(String type);

  /**
   * 添加用户中心的广告位
   * 
   * @param promotion
   * @return
   */
  public boolean addFP(Promotion promotion);

  /**
   * 获取用户中心的广告位
   * 
   * @param startTime
   * @param userId
   * @param posX
   * @return
   */
  public boolean getFP(Date startTime, Integer userId, String posX);

  /**
   * 抢到广告删除ad_postion数据
   */
  public boolean delAD(String posX, String startTime, String type);
}
