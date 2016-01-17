package com.go2plus.core.promotion.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.MyPromotion;
import com.go2plus.core.promotion.vo.Promotion;

public interface PromotionDao extends DAO {

  /**
   * 获取赞助商
   * @param excludes 
   * @param pos 
   * 
   * @param pos
   * @param excludes
   * @return
   */
  List<Promotion> getSponsers(String pos, Integer[] excludes);

  /**
   * 根据开始时间和用户ID搜索广告
   * 
   * @param startTime
   * @param userId
   * @return
   */
  Promotion getPromotionByStartTimeAndUserId(Date startTime, Integer userId);

  /**
   * 获取已经订购的搜索结果广告
   * 
   * @param startDate
   * @return
   */
  public List<Promotion> getOrderedSPsBy(Date startDate);
  public List<Promotion> getOrderedMRsBy();
  /**
   * 获取用户已订购的推荐位广告
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
  List<Promotion> getStFPsByUser(Integer userId, Boolean valid);

  /**
   * 获取市场商家广告
   * 
   * @param pos
   * @return
   */
  List<Promotion> getSuList(String pos);

  /**
   * 按月份获取推荐位广告
   * 
   * @return
   */
  List<Promotion> getOrderedFPs(@Param("posX") String posX);

  /**
   * 抢广告刷新列表
   */
  List<Promotion> getGrabFPs();

  /**
   * 抢广告 绑定USERID
   */
  int getPromotion(@Param("userId") String userId, @Param("id") String id);

  /**
   * 设置广告
   */
  int setPromotion( @Param("productId") String productId,@Param("promotionId") String promotionId);

  /**
   * 我抢到的广告位列表
   */
  List<MyPromotion> getMyPromotion(@Param("userId") String userId);

  /**
   * 设置广告 列出产品信息
   */
  List<Product> getMyProduct(@Param("userId") String userId);

  /**
   * 获取网站广告
   * @param is 
   * 
   * @return
   */
  public List<Promotion> queryPromotions(int[] ids);

  /**
   * 根据开始时间和用户ID查询广告条数
   * 
   * @param startTime
   * @param userId
   * @return
   */
  public int getNumByStartTimeAndUserId(@Param("startTime") Date startTime, @Param("userId") Integer userId);

  /**
   * 获取已订购的用户中心广告
   * 
   * @param startTime
   * @return
   */
  public List<Promotion> getOrderedUCsBy(@Param("startTime") Date startTime);

  /**
   * 获取已订购的搜索结果广告
   * 
   * @param startTime
   * @return
   */
  public List<Promotion> getOrderedSRsBy(@Param("startTime") Date startTime);

  /**
   * 获取已订购的市场商家广告
   * 
   * @param startTime
   * @return
   */
  public List<Promotion> getOrderedMRsBy(@Param("startTime") Date startTime);

  /**
   * 获取可用的广告数量
   * 
   * @param startTime
   * @param userId
   * @return
   */
  public int getAvailableNum(@Param("posX") String posX, @Param("startTime") Date startTime);

  /**
   * 添加用户用户中心广告
   * 
   * @param userId
   * @param posX
   * @param startTime
   * @param totalFee
   * @param discount
   * @return
   */
  public int addFP(Promotion promotion);

  /**
   * 查询用户中心的指定的广告位个数
   * 
   * @param startTime
   * @param userId
   * @param posX
   * @return
   */
  public int getFP(@Param("startTime") Date startTime, @Param("userId") Integer userId, @Param("posX") String posX);

  /**
   * 获取最近被删除的广告
   * 
   * @param seconds
   * @return
   */
  public List<Promotion> getDeletedFPs(@Param("seconds") int seconds);

  /**
   * 获取用户一段时间内订购的推荐位广告数量
   * 
   * @param userId
   * @param startTime
   * @param endTime
   * @param operatorId
   * @return
   */
  public int getFPsNumByUserId(@Param("posX") String posX, @Param("userId") Integer userId, @Param("startTime") Date startTime,
      @Param("endTime") Date endTime, @Param("operatorId") Integer operatorId);

  /**
   * 
   * @param posX
   * @param startTime
   * @param userId
   * @return
   */
  public List<Promotion> getFPs(@Param("posX") String posX, @Param("startTime") Date startTime, @Param("endTime") Date endTime,
      @Param("userId") Integer userId);

  /**
   * 新增表(ad_position)查询剩余未的抢广告位
   * 
   * @param type
   */
  public int getADNum(@Param("type") String type);

  /**
   * 新增表(ad_position)查询剩余未的抢广告位
   * 
   * @param type
   */
  public List<AdPosition> getAD(@Param("type") String type);

  /**
   * 抢到广告位后，删除表数据
   * 
   * @param posX
   * @param type
   */
  public int delAD(@Param("posX") String posX, @Param("startTime") String startTime, @Param("type") String type);

  /**
   * 导入广告位
   * 
   * @param posX
   * @param type
   */
  public int addAD(AdPosition adPosition);
  public int addBatchAD(List<AdPosition> adPosition);
  /**
   * 得到取消广告数据
   */
  public Promotion getCancelPromotion(@Param("id") int id);

  /**
   * 取消广告
   */
  public int updatePromotion(@Param("id") int id);
}
