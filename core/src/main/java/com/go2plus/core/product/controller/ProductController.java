package com.go2plus.core.product.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.go2plus.common.X;
import com.go2plus.common.encrypt.MD5;
import com.go2plus.common.json.Json;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.common.service.MessageService;
import com.go2plus.core.common.vo.Message;
import com.go2plus.core.product.service.ProductService;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.TaobaoItemImage;
import com.go2plus.core.promotion.service.PromotionService;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.publish.service.PublishService;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.publish.vo.TaobaoItem;
import com.go2plus.core.shop.service.ShopService;
import com.go2plus.core.sign.controller.SignInController;
import com.go2plus.core.userCenter.dao.SellerDao;
import com.go2plus.core.userCenter.vo.Complain;
import com.go2plus.core.userCenter.vo.ComplainCategory;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * 
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 产品Controller
 * 
 * @author azq
 * @since 上午11:02:24
 */
@Controller
public class ProductController extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(SignInController.class);
  @Autowired
  private ProductService      productService;
  @Autowired
  private MessageService      messageService;

  @Autowired
  private PromotionService    promotionService;
  @Resource
  private ShopService         shopService;

  @Resource
  private SellerDao           sellerDao;

  @Resource
  private PublishService      publishTaobaoService;

  /**
   * 商品详情
   * 
   * @param id
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = { "/product/{id}", "/getPreview/{id}" })
  public ModelAndView getProduct(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
    log.debug("ProductController.getProduct()");
    Box box = loadNewBox(request);

    // int productId = Integer.valueOf(BASE64.decrypt(id));
    int productId = Integer.parseInt(id);

    // 根据产品id查询供应商信息
    int supplierId = productService.getSupplierByProduct(productId);

    // 用于页面左侧的新商品列表
    List<Product> newProducts = productService.getNewProductsBySupplier(supplierId, productId);
    List<Product> hotProducts = productService.getHotProductsBySupplier(supplierId, productId);
    // 用于页面右侧的网站广告
    List<Promotion> promotions = promotionService.getPDSponsors();
    // 用于页面右侧的商家公告`
    List<Message> messages = messageService.queryBySupplier(supplierId);

    // 供应商
    Supplier supplier = shopService.findSupplierByUserId(supplierId);
    box.setAttribute("supplier", supplier);
    box.setAttribute("newProducts", newProducts);
    box.setAttribute("hotProducts", hotProducts);
    box.setAttribute("promotions", promotions);
    box.setAttribute("messages", messages);

    // 四张次图
    List<TaobaoItemImage> taobaoImgImages = productService.getTaobaoImg(productId);
    box.setAttribute("taobaoImgImages", taobaoImgImages);
    // 产品详情
    Product productDetail = productService.getProductDetail(productId);
    box.setAttribute("productDetail", productDetail);

    // 产品详情预览页面
    // -----------------product preview start-----------------------------
    // redis key
    String userId = box.$cv(X.USER);
    String userKey = "productPreview" + userId + productId;
    try {
      userKey = MD5.md5Encode(userKey);
    } catch (Exception e) {
      e.printStackTrace();
    }
    HashMap<String, String> previewMap;
    String isHideStats = null;
    String articleNumber = null;
    String characters = null;
    String size = null;
    String price = null;
    String fullHtml = null;
    // ajax第一次post数据
    if (request.getMethod().equals("POST")) {

      if (!X.isLogined(box)) {
        try {
          response.sendRedirect("login");
        } catch (IOException e) {
          e.printStackTrace();
        }
        return null;
      } else {

        isHideStats = box.$p("is_hide_stats");
        articleNumber = box.$p("checkArticleNumber");
        characters = box.$p("characters");
        size = box.$p("size");
        // String indexImage = box.$p("indexImage");
        price = box.$p("price");
        fullHtml = box.$p("fullHtml");
        previewMap = new HashMap<>();

        previewMap.put("isHideStats", isHideStats);
        previewMap.put("articleNumber", articleNumber);
        previewMap.put("characters", characters);
        previewMap.put("size", size);
        previewMap.put("price", price);
        previewMap.put("fullHtml", fullHtml);

        // 将产品编辑数据存入redis
        String previewJson = Json.hashMap2Json(previewMap);
        productService.putPreviewInRedis(userKey, previewJson);
      }
    }
    // ajax第二次发请求
    if (request.getMethod().equals(RequestMethod.GET.name()) && request.getRequestURI().startsWith("/getPreview")) {

      // 从redis中取出ajax第一次保存的post数据
      String previewJson = productService.getPreviewFromRedis(userKey);
      previewMap = Json.json2HashMap(previewJson);
      isHideStats = previewMap.get("isHideStats");
      characters = previewMap.get("characters");
      size = previewMap.get("size");
      price = previewMap.get("price");
      fullHtml = previewMap.get("fullHtml");
      productDetail.setIsHideStats(Integer.parseInt(isHideStats));
      if (articleNumber != null || articleNumber != "") {
        productDetail.setArticleNumber(articleNumber);
      }
      if (characters != null || characters != "") {
        productDetail.setCharacters(characters);
      }
      if (size != null || size != "") {
        productDetail.setSize(size);
      }
      if (price != null || price != "") {
        productDetail.setPrice(Double.parseDouble(price));
      }
      if (fullHtml != null || fullHtml != "") {
        productDetail.getProductMeta().setDescriptionBin(fullHtml);
      }
    }

    // -----------------product preview end-----------------------------

    // 用户发布、下载等行为
    // 卖家
    // String sellerId=box.$cv(X.USER);
    String sellerId = "6937";
    List<String> userOpers = productService.getUserOperation(Integer.parseInt(sellerId), productId);
    box.setAttribute("userOpers", userOpers);

    // 商家产品分类
    List<Product> productCategories = productService.queryProductCategory(supplierId);
    box.setAttribute("productCategories", productCategories);

    // 尾货数
    int tailGoodsCount = productService.queryTailGoodsNum(supplierId);
    box.setAttribute("tailGoodsCount", tailGoodsCount);

    // 投诉全部分类
    List<ComplainCategory> complainCategories = sellerDao.queryAddBlackListReason();
    box.setAttribute("complainCategories", complainCategories);

    // 发布到淘宝列表
    List<TaobaoItem> taobaoLists = publishTaobaoService.getTaobaoList(productId);
    box.setAttribute("taobaoLists", taobaoLists);

    // 下载列表
    List<LogDownload> downloadLists = publishTaobaoService.getDownloadList(productId);
    box.setAttribute("downloadLists", downloadLists);

    // 再加载该商家的4个产品链接信息
    List<Product> productLinks = productService.getProductLink(supplierId);
    box.setAttribute("productLinks", productLinks);

    return createModelAndView("/core/product/product.jsp", box);

  }

  /**
   * 产品投诉
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/product/complain")
  @ResponseBody
  public String productComplain(HttpServletRequest request, HttpServletResponse response) {
    log.debug("ProductController.productComplain()");
    Box box = loadNewBox(request);

    // 解析参数
    String productId = box.$p("productId");
    // String sellerId = box.$p(X.USER);
    String sellerId = "6937";
    String complainCategoryId = box.$p("complainCategoryId");
    String review = box.$p("review");
    String images = box.$p("images");
    String ip = box.getPageView().getIp();
    int isFixed = 0;
    int weight = 1;
    int state = 1;

    int supplierId = productService.getSupplierByProduct(Integer.parseInt(productId));

    // 组装对象
    Complain complain = new Complain();
    complain.setSupplierUserId(supplierId);
    complain.setProductId(Integer.parseInt(productId));
    complain.setUserId(Integer.parseInt(sellerId));
    complain.setComplainCategoryId(Integer.parseInt(complainCategoryId));
    complain.setReview(review);
    complain.setImages(images);
    complain.setIp(ip);
    complain.setIsFixed(isFixed);
    complain.setWeight(weight);
    complain.setState(state);

    // 保存用户投诉信息
    int rows = productService.saveProductComplain(complain);
    return Integer.toString(rows);
  }

}