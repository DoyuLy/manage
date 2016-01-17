package com.go2plus.core.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.product.vo.Category;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.TaobaoItemImage;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.vo.Complain;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * code file is protected by copyright law and international treaties. Unauthorized distribution of source code files, programs, or portion
 * of the package, may result in severe civil and criminal penalties, and will be prosecuted to the maximum extent under the law. ProductDao
 * interface
 * 
 * @author duyu
 * @since 2015-11-03
 */
public interface ProductDao extends DAO {

  /**
   * @author duyu
   * @category 根据用户id查找厂家认发布的产品列表
   */
  List<Product> getProductsListById(@Param("userId") int userId, @Param("searchType") String searchType, @Param("key") String key);

  /**
   * @author duyu
   * @category 根据用户id查找用户投诉信息
   */
  List<Complain> getComplainListById(@Param("userId") int userId);

  /**
   * @author duyu
   * @category 查询所有商品类别
   */
  List<Category> getAllCategory(@Param("offset") int offset, @Param("pageSize") int pageSize);

  /**
   * @author duyu
   * @category 检测货号的唯一性
   */
  Boolean checkArticlekNum(@Param("userId") int userId, @Param("articleNum") String articleNum);

  /**
   * @author duyu
   * @category 获取用户中心广告
   */
  List<Promotion> getUCPromotions();

  List<Product> queryProductById(@Param("supplierId") int supplierId, @Param("categoryId") String categoryId,
      @Param("sortedId") String sortedId, @Param("isTailGoods") String isTailGoods);

  /**
   * 查询供应商各品类数
   * 
   * @param supplierId
   * @return 各品类数量
   * @author gzh
   */
  List<Product> queryProductCategory(int supplierId);

  /**
   * @author duyu
   * @category 获取推荐(最新上架)商品
   */
  List<Product> getRecommendList();

  /**
   * 根据supplierId选出5个商品
   * 
   * @param supplierId
   * @return
   */
  public List<Product> getProductsBySupplierId(Integer supplierId);

  /**
   * 查询最近7天发布最多的前360款产品
   * 
   * @return
   */
  List<Integer> find7DaysHotProduct();

  /**
   * 获取商品信息
   * 
   * @param id
   * @return
   */
  public Product query(@Param("id") int id);

  /**
   * 获取最新的推荐商品信息
   * 
   * @param userId
   * @param productId
   * @param size
   * @return
   */
  public List<Product> queryNewProductsBySupplier(@Param("userId") int userId, @Param("productId") int productId, @Param("size") int size);

  /**
   * 获取热卖的爆款商品信息
   * 
   * @param userId
   * @param productId
   * @param size
   * @return
   */
  public List<Product> queryHotProductsBySupplier(@Param("userId") int userId, @Param("productId") int productId, @Param("size") int size);

  /**
   * 独家商品
   * 
   * @param categoryId
   * @param sortId
   * @return
   * @author gzh
   */
  List<Product> getUniqueProduct(@Param("categoryId") String categoryId, @Param("sortId") int sortId);

  /**
   * 根据userid和productid查询最大权重
   * 
   * @param userId
   * @param productId
   * @return
   */
  int maxWeight(@Param("userId") int userId);

  /**
   * 更新指定用户的指定商品的最大权重值
   * 
   * @param userId
   * @param productId
   * @return
   */
  int updateMaxWeight(@Param("userId") int userId, @Param("productId") int productId, @Param("maxWeight") int maxWeight);

  /**
   * 更新指定用户的商品权重值
   * 
   * @param userId
   * @param productId
   * @return
   */
  int updateWeight(@Param("userId") int userId, @Param("productId") int productId, @Param("weight") int weight);

  /**
   * 供货商商品上架下架或者删除(1:上架 0：下架 -1删除)
   * 
   * @param state
   * @param productId
   * @param user_id
   * @return
   */
  int updateState(@Param("state") int state, @Param("productId") int productId, @Param("userId") int userId);

  /**
   * 当商品下架、仿款时、取消独款
   * 
   * @param productId
   * @return
   */
  int updateIsNotUnique(@Param("productId") int productId);

  /**
   * 下架商品时，同时取消商品的关联和推荐属性
   * 
   * @param productId
   * @return
   */
  int updateHighShow(@Param("productId") int productId);

  /**
   * 关联与取消关联
   * 
   * @param flag
   * @param productId
   * @param userId
   * @return >0,成功
   */
  int updateHighlight(@Param("flag") int flag, @Param("productId") int productId, @Param("userId") int userId);

  /**
   * 获取该用户已关联的商品id列表
   * 
   * @param userId
   * @return
   */
  List<Integer> getHighlighted(@Param("userId") int userId);

  /**
   * 更新最低零售价
   * 
   * @param productId
   * @param minSalePrice
   * @return
   */
  int updateMinPrice(@Param("productId") int productId, @Param("minSalePrice") double minSalePrice);

  /**
   * 更改标签
   * 
   * @param productId
   * @param label
   * @return
   */
  int updateLabel(@Param("productId") int productId, @Param("label") int label);

  /**
   * 获取商品SupplierTitle
   * 
   * @param productId
   * @return
   */
  Product getSupplierTitle(@Param("productId") int productId);

  /**
   * 根据用户id和商品id获取有个商品对象
   * 
   * @param userId
   * @param productId
   * @return
   */
  Product getProduct(int userId, int productId);

  /**
   * 产品详情页
   * 
   * @param productId
   * @return
   */
  Product getProductDetail(int productId);

  /**
   * 发到淘宝的四张次图
   * 
   * @param productId
   * @return
   */
  List<TaobaoItemImage> getTaobaoImg(int productId);

  /**
   * 查找产品的供应商
   * 
   * @param productId
   * @return
   */
  int getSupplierByProduct(int productId);

  /**
   * 判断用户是否下载、发布、外链过产品
   * 
   * @return
   */
  List<String> getUserOperation(@Param("userId") int userId, @Param("productId") int productId);

  /**
   * 保存产品投诉
   * 
   * @param complain
   * @return
   */
  int saveProductComplain(Complain complain);

  /**
   * 获取产品详情上方的4个产品链接信息
   * 
   * @param productId
   * @return
   */
  List<Product> getProductLink(int supplierId);

  /**
   * 获得所有产品及其相关信息
   * 
   * 本方法作为数据库抽取数据到redis使用，其他地方效率低，慎用！！！
   * 
   * @return
   */
  List<Product> getAllProduct();
}
