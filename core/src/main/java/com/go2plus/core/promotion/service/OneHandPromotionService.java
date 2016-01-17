package com.go2plus.core.promotion.service;

import java.util.Date;
import java.util.List;

import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.OrderedFPs;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.vo.Supplier;

public interface OneHandPromotionService {

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
   * 获取可用的产品推荐位广告
   * 
   * @param lastDay
   * @param startTime
   * @param occu
   * @return
   */
  public List<Promotion> getAvaiableFPs(Date lastDay, Date startTime, List<Promotion> occu);

  /**
   * 按月份获取推荐位广告
   * 
   * @return
   */
  public OrderedFPs getOrderedFPs();

  /**
   * 新表获取已订购的用户中心广告
   * 
   * @param startTime
   * @return
   */
  public List<AdPosition> getOnsBy(String type);

  /**
   * 获取最近删除的广告
   * 
   * @param seconds
   * @return
   */
  public List<String> getDeletedFPs(Integer seconds) throws Exception;

  /**
   * 使用Redis获取最近删除的广告
   * 
   * @param seconds
   * @return
   * @throws Exception
   */
  public List<String> getDeletedFPsFromRedis(Integer seconds) throws Exception;

  /**
   * 获取用户一段时间内订购的推荐位广告数量
   * 
   * @param userId
   * @param startTime
   * @param endTime
   * @param operatorId
   * @return
   */
  public Integer getFPsByUserId(Integer userId, Date startTime, Date endTime, Integer operatorId);

  /**
   * 使用Redis获取用户一段时间内订购的推荐位广告数量
   * 
   * @param userId
   * @param startTime
   * @param endTime
   * @param operatorId
   * @return
   */
  public Integer getFPsByUserIdFromRedis(Integer userId, Date startTime, Date endTime, Integer operatorId) throws Exception;

  /**
   * 添加用户中心的广告位
   * 
   * @param promotion
   * @return
   */
  public Boolean addFP(Promotion promotion);

  /**
   * 使用Redis添加用户中心的广告位
   * 
   * @param promotion
   * @return
   */
  public Boolean addFpFromRedis(Promotion promotion);

  /**
   * 判断用户是否已订购 广告或连续广告时间超过 10 天
   * 
   * @param posX
   * @param startTime
   * @param userId
   * @return
   */
  public Boolean checkFPRule(String posX, Date startTime, Integer userId);

  /**
   * 使用Redis判断用户是否已订购 广告或连续广告时间超过 10 天
   * 
   * @param posX
   * @param startTime
   * @param userId
   * @return
   * @throws Exception
   */
  public Boolean checkFPRuleFromRedis(String posX, String startTime, Integer userId) throws Exception;

  /**
   * 判断广告位是否可用
   * 
   * @param posX
   * @param startTime
   * @return
   */
  public Promotion isAvaiableFPFromRedis(String posX, String startTime);

  /**
   * 抢到广告删除ad_postion数据
   */
  public boolean delAD(String posX, String startTime, String type);

}
