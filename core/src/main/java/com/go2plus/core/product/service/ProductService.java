package com.go2plus.core.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.json.Result;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.product.vo.Category;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.TaobaoItemImage;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.vo.Complain;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * ProductService Service
 * 
 * @author duyu
 * @since 2015-11-03
 */

@Service
public interface ProductService {
  /**
   * @author duyu
   * @category 根据用户id查找厂家认发布的产品列表
   */
  public PageInfo<Product> getProductsListById(int userId, String searchType, String key, Pagination pagination);

  /**
   * @author duyu
   * @category 根据用户id查找用户投诉信息
   */
  public PageInfo<Complain> getComplainListById(int userId, Pagination pagination);

  /**
   * @author duyu
   * @category 查询所有商品类别
   */
  public List<Category> getAllCategory(int offset, int pageSize);

  /**
   * @author duyu
   * @category 检测货号的唯一性
   */
  public Boolean checkArticlekNum(int userId, String articleNum);

  /**
   * @author duyu
   * @category 获取用户中心广告
   */
  public List<Promotion> getUCPromotions();

  /**
   * @author duyu
   * @category 获取推荐(最新上架)商品
   */
  public List<Product> getRecommendList();

  /**
   * 获得商品信息
   * 
   * @param supplierId
   * @param categoryId
   * @param sortedId
   * @param isTailGoods
   * @return
   */
  public PageInfo<Product> queryProductById(int supplierId, String categoryId, String sortedId, String isTailGoods, Pagination pagination);

  /**
   * 查询供应商各品类数
   * 
   * @param supplierId
   * @return 各品类数量
   * @author gzh
   */
  public List<Product> queryProductCategory(int supplierId);

  /**
   * 查询厂家产品尾货
   * 
   * @param supplierId
   * @return 厂家尾货
   */
  public int queryTailGoodsNum(int supplierId);

  /**
   * 修改商品权重
   * 
   * @param userId
   * @param goodsId
   * @param page
   * @param goosNum
   */
  public void updateWeight(int userId, String goodsId, int page, int goosNum, int pageSize);

  /**
   * 商品置顶
   * 
   * @param productId
   * @param user_id
   */
  public boolean setTop(int productId, int user_id);

  /**
   * 上架下架和删除
   * 
   * @param productId
   * @param userId
   * @param flag
   * @return
   */
  public Result<Boolean> updateAdded(int productId, int userId, int flag);

  /**
   * 关联与取消关联
   * 
   * @param productId
   * @param userId
   * @param flag
   * @return
   */
  public Result<Boolean> updateHighLight(int productId, int userId, int flag);

  /**
   * 修改商品最低零售价
   * 
   * @param productId
   * @param minSalePrice
   * @return
   */
  public boolean updateMinPirice(int productId, double minSalePrice);

  /**
   * 更新标签
   * 
   * @param productId
   * @param label
   * @return
   */
  public boolean updateLabel(int productId, int label, int userId);

  /**
   * 获取5条新款推荐商品信息
   * 
   * @param userId
   * @param productId
   * @return
   */
  public List<Product> getNewProductsBySupplier(int userId, int productId);

  /**
   * 获取5条爆款热卖商品信息
   * 
   * @param userId
   * @param productId
   * @return
   */
  public List<Product> getHotProductsBySupplier(int userId, int productId);

  /**
   * 查询产品对应的供应商
   * 
   * @param productId
   * @return
   */
  public int getSupplierByProduct(int productId);

  /**
   * 产品详情页
   * 
   * @param productId
   * @return
   */
  public Product getProductDetail(int productId);

  /**
   * 发到淘宝的四张次图
   * 
   * @param productId
   * @return
   */
  public List<TaobaoItemImage> getTaobaoImg(int productId);

  /**
   * 判断用户是否下载、发布、外链过产品
   * 
   * @return
   */
  public List<String> getUserOperation(int userId, int productId);

  /**
   * 保存产品投诉
   * 
   * @param complain
   * @return
   */
  public int saveProductComplain(Complain complain);

  /**
   * 获取产品详情上方的4个产品链接信息
   * 
   * @param productId
   * @return
   */
  public List<Product> getProductLink(int productId);

  /**
   * 将产品编辑数据存入redis
   * 
   * @param userKey
   * 
   * @param previewMap
   */
  public void putPreviewInRedis(String userKey, String previewJson);

  /**
   * 取出产品预览数据
   * 
   * @param userKey
   * 
   * @return
   */
  public String getPreviewFromRedis(String userKey);

  /**
   * 获得所有产品及其相关信息
   * 
   * 本方法作为数据库抽取数据到redis使用，其他地方效率低，慎用！！！
   * 
   * @return
   */
  List<Product> getAllProduct();
}
