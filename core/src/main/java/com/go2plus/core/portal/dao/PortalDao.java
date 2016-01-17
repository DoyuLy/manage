package com.go2plus.core.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.vo.Promotion;

@Repository
public interface PortalDao extends DAO {
  
  /**
   * 获取广告橱窗
   * @param null
   * @return
   * @author duyu
   */
  List<Promotion> getBanners();
  /**
   * 获取当天广告商品
   * 
   * @param null
   * @return
   * @author duyu
   */
  List<Promotion> getCurPromotions();
  
  /**
   * 获取推荐货源广告
   * 
   * @param null
   * @return
   * @author duyu
   */
  List<Promotion> getPromotions();
  
  /**
   * 获取精选商品
   * 
   * @param null
   * @return
   * @author duyu
   */
  List<Promotion> getSelections();

  /**
   * 获取近3日所有商品中的广告
   * 
   * @param null
   * @return
   * @author duyu
   */
  List<Product> getCthPromotions();
}
