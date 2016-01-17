package com.go2plus.core.promotion.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.MyPromotion;
import com.go2plus.core.promotion.vo.Promotion;

public interface PromotionService {

  /**
   * 获取赞助商
   * @param emptyPromotionId 
   * @param string 
   * 
   * @param pos
   * @param excludes
   * @return
   */
  public List<Promotion> getSponsers(String string, Integer[] emptyPromotionId);

  /**
   * 
   抢广告刷新列表
   * 
   * @param value
   *          原始字符串
   * @return 加密后的字符串
   */
  public List<Promotion> getGrabFPs();

  /**
   * 
   抢广告绑定用户ID
   * 
   * @param value
   *          原始字符串
   * @return 加密后的字符串
   */
  public int getPromotion(String userId, String id);

  /**
   * 
   设置广告
   * 
   * @param value
   *          原始字符串
   * @return 加密后的字符串
   */
  public int setPromotion(String productId,String promotionId );

  /**
   * 
   我抢到的广告位列表
   * 
   * @param userId
   *          endTime
   * @return 加密后的字符串
   */
  public List<MyPromotion> getMyPromotion(String userId);

  /**
   * 
   设置广告 列出产品信息
   * 
   * @param userId
   * @return 加密后的字符串
   */
  public List<Product> getMyProduct(String userId);

  /**
   * 获取网站广告
   * 
   * @return
   */
  public List<Promotion> getPDSponsors();

  /**
   * 获取广告橱窗
   * 
   * @param null
   * @return
   * @author duyu
   */
  public List<Promotion> getBanners();

  /**
   * 获取当天广告商品
   * 
   * @param null
   * @return
   * @author duyu
   */
  public List<Promotion> getCurPromotions();

  /**
   * 获取精选商品
   * 
   * @param null
   * @return
   * @author duyu
   */
  public List<Promotion> getSelections();

  /**
   * 获取近3日所有商品中的广告
   * 
   * @param null
   * @return
   * @author duyu
   */
  public List<Product> getCthPromotions();

  /**
   * 独家商品
   * 
   * @param categoryId
   * @param sortId
   * @return
   * @author gzh
   */

  public PageInfo getUniqueProduct(String categoryId, int sortId, Pagination pagination);

  /**
   * 得到取消广告数据
   */
  public Promotion getCancelPromotion(@Param("id") int id);

  /**
   * 取消广告
   */
  public int updatePromotion(@Param("id") int id);

  /**
   * 导入广告位
   * 
   * @param posX
   * @param type
   */
  public int addAD(AdPosition adPosition);
}
