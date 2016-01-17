package com.go2plus.core.portal.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.vo.Promotion;

public interface PortalService {
  
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
   * 获取推荐货源广告
   * 
   * @param null
   * @return
   * @author duyu
   */
  public List<Promotion> getPromotions();
  
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
}
