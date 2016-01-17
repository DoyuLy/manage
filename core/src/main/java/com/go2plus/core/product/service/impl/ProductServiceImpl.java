package com.go2plus.core.product.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.Constant;
import com.go2plus.common.img.ImgAddressConvert;
import com.go2plus.common.json.Result;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.common.dao.MessageDao;
import com.go2plus.core.common.vo.Message;
import com.go2plus.core.product.dao.ProductDao;
import com.go2plus.core.product.service.ProductService;
import com.go2plus.core.product.vo.Category;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.ProductMeta;
import com.go2plus.core.product.vo.TaobaoItemImage;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.dao.SupplierDao;
import com.go2plus.core.userCenter.dao.SupplierStatsDao;
import com.go2plus.core.userCenter.vo.Complain;
import com.go2plus.core.userCenter.vo.Supplier;

@Service
public class ProductServiceImpl implements ProductService, Constant {
  @Resource
  private ProductDao       productDao;
  @Resource
  private MessageDao       messageDao;
  @Resource
  private SupplierStatsDao supplierStatsDao;
  @Resource
  private SupplierDao      supplierDao;

  @Override
  public PageInfo<Product> getProductsListById(int userId, String searchType, String key, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<Product> products = productDao.getProductsListById(userId, searchType, key);
    PageInfo<Product> pi = new PageInfo<Product>(products, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public PageInfo<Complain> getComplainListById(int userId, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<Complain> complains = productDao.getComplainListById(userId);
    PageInfo<Complain> pi = new PageInfo<Complain>(complains, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public List<Category> getAllCategory(int offset, int pageSize) {
    List<Category> categorys = productDao.getAllCategory(offset, pageSize);
    if (categorys.size() >= 1)
      return categorys;
    else
      return null;
  }

  @Override
  public Boolean checkArticlekNum(int userId, String articleNum) {
    Boolean code = productDao.checkArticlekNum(userId, articleNum);
    return code;
  }

  @Override
  public List<Promotion> getUCPromotions() {
    List<Promotion> promotions = productDao.getUCPromotions();
    if (promotions != null && promotions.size() >= 1)
      return promotions;
    else
      return null;
  }

  @Override
  public List<Product> getRecommendList() {
    List<Product> products = productDao.getRecommendList();
    if (products != null && products.size() >= 1)
      return products;
    else
      return null;
  }

  /**
   * 查询商品信息
   */
  @Override
  public PageInfo<Product> queryProductById(int supplierId, String categoryId, String sortedId, String isTailGoods, Pagination pagination) {
    PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
    List<Product> productList = productDao.queryProductById(supplierId, categoryId, sortedId, isTailGoods);
    PageInfo<Product> pi = new PageInfo<>(productList, pagination.getNavigationSize());
    return pi;
  }

  @Override
  public List<Product> queryProductCategory(int supplierId) {
    return productDao.queryProductCategory(supplierId);
  }

  @Override
  public int queryTailGoodsNum(int supplierId) {
    int tailGoodsCount = 0;
    String categoryId = "0";
    String sortedId = "0";
    String isTailGoods = "1";
    List<Product> tailGoodsList = productDao.queryProductById(supplierId, categoryId, sortedId, isTailGoods);
    for (Product product : tailGoodsList) {
      if (product.getLabelId().equals(2)) {
        tailGoodsCount++;
      }
    }
    return tailGoodsCount;
  }

  @Override
  public List<Product> getNewProductsBySupplier(int userId, int productId) {
    return productDao.queryNewProductsBySupplier(userId, productId, 5);
  }

  @Override
  public List<Product> getHotProductsBySupplier(int userId, int productId) {
    return productDao.queryHotProductsBySupplier(userId, productId, 5);
  }

  /**
   * 修改商品权重
   * 
   * @param userId
   * @param goodsId
   * @param page
   * @param goosNum
   * @author liyang
   */
  @Override
  public void updateWeight(int userId, String goodsId, int page, int goodsNum, int pageSize) {
    goodsNum = goodsNum - pageSize * (page - 1);
    // 先拆分 goodsId成一个数组
    String[] productIdArray = goodsId.split(",");
    int weight = 0;
    for (int i = 0; i < productIdArray.length; i++) {
      int productId = Integer.parseInt(productIdArray[i]);
      weight = goodsNum;
      productDao.updateWeight(userId, productId, weight);
      goodsNum--;
    }

  }

  /**
   * 商品置顶
   * 
   * @param productId
   * @param user_id
   * @author liyang
   */
  @Override
  public boolean setTop(int productId, int userId) {
    // 获取该用户下的最大权重值
    Integer maxWeight = productDao.maxWeight(userId);
    // 如果没有数据返回false
    if (maxWeight == -1) {
      return false;
    }
    // 更新权重值在最大值基础上加一
    maxWeight += 1;
    int result = productDao.updateMaxWeight(userId, productId, maxWeight);
    if (result > 0) {
      return true;
    }
    return false;
  }

  /**
   * 上架下架和删除 商品操作1:上架0:下架-1:删除
   * 
   * @param productId
   * @param userId
   * @param flag
   * @author liyang
   * @return
   */
  @Override
  public Result<Boolean> updateAdded(int productId, int userId, int flag) {
    // 创建一个json模型
    Result<Boolean> result = new Result<>();
    // 创建一个message对象
    Message message = new Message();
    // 先查询该商品是否存在，如果不存在则返回提示消息
    Product product = productDao.getProduct(userId, productId);
    if (product == null) {
      result.setData(false);
      result.setMessage("商品不存在");
    }
    // 获取供货商title
    Supplier supplier = supplierDao.findSupplierByUserId(userId);
    // 商品存在就执行状态更新操作
    message.setUserId(userId);
    message.setProductId(productId);
    message.setType("corplog");
    message.setWeight(0);
    message.setState(1);
    message.setCreateTime(new Date());
    int rt = productDao.updateState(flag, productId, userId);
    // 如果操作成功,分别对三种操作进行影响操作
    if (rt > 0) {
      if (flag == 1) {
        // 当上架时，也就是状态从不是1改为1，就执行商品上架提示
        message.setContent(supplier.getTitle() + "的商品货号为" + product.getArticleNumber() + "的商品上架了；请及时更新信息。");
        // 存储消息
        messageDao.insertUserMessage(message);
        result.setData(true);
        result.setMessage("上架成功");
        result.success();
      } else if (flag == 0) {
        // 当下架时，由非0变为0时，取消独款，取消推荐，取消关联，并提示商品下架信息
        // 取消独款
        productDao.updateIsNotUnique(productId);
        // 取消关联,取消推荐
        productDao.updateHighShow(productId);
        // 存储消息
        message.setContent(supplier.getTitle() + "的商品货号为" + product.getArticleNumber() + "的商品下架了；请及时更新信息。");
        messageDao.insertUserMessage(message);
        result.setData(true);
        result.setMessage("下架成功");
        result.success();
      } else if (flag == -1) {
        // 当商品被删除时，状态由非-1变为-1时，提示商品被删除，请及时更新消息
        // 存储消息
        message.setContent(supplier.getTitle() + "的商品货号为" + product.getArticleNumber() + "的商品删除了；请及时更新信息。");
        messageDao.insertUserMessage(message);
        result.setData(true);
        result.setMessage("删除成功");
        result.success();
      }
    }
    // 返回msg
    return result;
  }

  /**
   * @param productId
   * @param userId
   * @param flag
   * @author liyang
   */
  @Override
  public Result<Boolean> updateHighLight(int productId, int userId, int flag) {
    // 创建一个json模型
    Result<Boolean> result = new Result<>();
    int rt = -1;
    // 关联时，先查询该厂家的关联限制数量，默认为5，当关联数大于5时，将超过5的关联取消
    // 当前限制数
    int lightLimitCount = supplierStatsDao.getHighlightLimitByUserId(userId);
    if (flag == 1) {
      // 该厂家当前关联的产品id列表
      List<Integer> IdList = productDao.getHighlighted(userId);
      // 判断当前关联数和限制数
      if (IdList.size() >= lightLimitCount) {
        // 空位占满，先删除最早的空位
        for (int i = lightLimitCount - 1; i < IdList.size(); i++) {
          productDao.updateHighlight(0, IdList.get(i), userId);
        }
        // 再关联
        rt = productDao.updateHighlight(flag, productId, userId);
        if (rt > 0) {
          result.setData(true);
          result.setMessage("关联成功");
          result.success();
        }
      } else {
        // 如果还有空位，直接关联
        rt = productDao.updateHighlight(flag, productId, userId);
        if (rt > 0) {
          result.setData(true);
          result.setMessage("关联成功");
          result.success();
        }
      }
    } else if (flag == 0) {
      // 取消关联
      rt = productDao.updateHighlight(flag, productId, userId);
      if (rt > 0) {
        result.setData(true);
        result.setMessage("取消关联成功");
        result.success();
      }
    }
    return result;
  }

  /**
   * 修改商品最低零售价
   * 
   * @param productId
   * @param minSalePrice
   * @author liyang
   * @return
   */
  @Override
  public boolean updateMinPirice(int productId, double minSalePrice) {
    return productDao.updateMinPrice(productId, minSalePrice) > 0 ? true : false;
  }

  /**
   * 更新标签
   * 
   * @param productId
   * @param label
   * @return
   */
  @Override
  public boolean updateLabel(int productId, int label, int userId) {
    // 创建一个message对象
    Message message = new Message();
    // 查询该商品是否存在
    Product product = productDao.getSupplierTitle(productId);
    if (product == null) {
      return false;
    }
    // 更新标签
    int result = productDao.updateLabel(productId, label);
    // 更新消息
    message.setUserId(userId);
    message.setProductId(productId);
    message.setType("corplog");
    message.setWeight(0);
    message.setState(1);
    message.setCreateTime(new Date());
    if (result > 0) {
      if (label == 2) {
        message.setContent(product.getSupplierTitle() + "的商品货号为" + product.getArticleNumber() + "的商品添加为《尾货》；请及时更新信息。");
      } else if (label == 0) {
        message.setContent(product.getSupplierTitle() + "的商品货号为" + product.getArticleNumber() + "的商品取消了《尾货》标签；请及时更新信息。");
      }
      messageDao.insertUserMessage(message);
    } else {
      return false;
    }

    return true;
  }

  @Override
  public int getSupplierByProduct(int productId) {
    return productDao.getSupplierByProduct(productId);
  }

  @Override
  public Product getProductDetail(int productId) {
    Product product = productDao.getProductDetail(productId);
    String productDesc = product.getProductMeta().getDescriptionBin();
    // 地址转换
    // 转go2地址
    String go2Url = ImgAddressConvert.relativeURLToGo2(productDesc);
    // 转换图片尺寸
    String productDescSize = ImgAddressConvert.convertImgSize(go2Url);
    ProductMeta productMeta = new ProductMeta();
    productMeta.setDescriptionBin(productDescSize);
    product.setProductMeta(productMeta);
    return product;
  }

  @Override
  public List<TaobaoItemImage> getTaobaoImg(int productId) {
    return productDao.getTaobaoImg(productId);
  }

  @Override
  public List<String> getUserOperation(int userId, int productId) {
    return productDao.getUserOperation(userId, productId);
  }

  @Override
  public int saveProductComplain(Complain complain) {
    return productDao.saveProductComplain(complain);
  }

  @Override
  public List<Product> getProductLink(int supplierId) {
    return productDao.getProductLink(supplierId);
  }

  @Override
  public void putPreviewInRedis(String userkey, String previewJson) {
    if (RedisUtil.isConnectRedis()) {
      if (RedisUtil.exists(userkey)) {
        RedisUtil.del(userkey);
        RedisUtil.set(userkey, previewJson);
      } else {
        RedisUtil.set(userkey, previewJson);
      }
    }
  }

  @Override
  public String getPreviewFromRedis(String userKey) {
    String previewJson = null;
    if (RedisUtil.isConnectRedis()) {
      if (RedisUtil.exists(userKey)) {
        previewJson = RedisUtil.get(userKey);
      }
    }
    return previewJson;
  }

  @Override
  public List<Product> getAllProduct() {
    return productDao.getAllProduct();
  }
}
