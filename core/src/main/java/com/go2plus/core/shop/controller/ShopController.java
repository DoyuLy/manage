package com.go2plus.core.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.go2plus.common.X;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.common.service.MessageService;
import com.go2plus.core.common.vo.Message;
import com.go2plus.core.page.service.PageService;
import com.go2plus.core.page.vo.Page;
import com.go2plus.core.product.service.ProductService;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.shop.service.ShopService;
import com.go2plus.core.userCenter.service.SupplierService;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 前台厂家店铺页面
 * 
 * @author gzh
 * @see 2015-11-11
 */
@Controller
public class ShopController extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(ShopController.class);

  @Resource
  private ShopService         shopService;

  @Resource
  private UserService         userService;
  @Resource
  private SupplierService     supplierService;

  @Resource
  private ProductService      productService;
  @Resource
  private MessageService      messageService;

  @Resource
  private PageService         pageService;

  /**
   * 店铺首页
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/shop/{shopUrl}")
  public void shopIndex(@PathVariable String shopUrl, HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("ShopController.shopIndex()");
    StringBuffer url = new StringBuffer("/shop/").append(shopUrl).append("/0").append("/0").append("/0");
    response.sendRedirect(url.toString());
  }

  /**
   * 商家店铺列表
   * 
   * @param shopUrl
   * @param categoryId
   * @param sortedId
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/shop/{shopUrl}/{categoryId}/{sortedId}/{isTailGoods}")
  public ModelAndView supplierShop(@PathVariable String shopUrl, @PathVariable String categoryId, @PathVariable String sortedId,
      @PathVariable String isTailGoods, HttpServletRequest request, HttpServletResponse response) {
    log.debug("ShopController.supplierShop()");

    Box box = loadNewBox(request);

    // 根据URL地址查找厂家id
    int supplierId = userService.queryUserIdByUrl(shopUrl);
  
    // 根据厂家id查找厂家信息
    Supplier supplier = shopService.findSupplierByUserId(supplierId);

    /**
     * 供应商信息
     */
    // 是否是生产厂家
    String membershipType = null;
    if (supplier.getMembershipType().equals(1)) {
      membershipType = "生产厂家";
    }

    // 商家认证等级判断
    String certifiedType = supplierService.getCertifiedType(supplierId);

//    商家分数等级
    int score=supplier.getSupplierRank().getScore();
    int supplierScoreLevel=supplierService.converteScoreToLevel(score);
    
    box.setAttribute("supplierScoreLevel",supplierScoreLevel);
    box.setAttribute("supplier", supplier);
    box.setAttribute("shopUrl", shopUrl);
    box.setAttribute("certifiedType", certifiedType);
    box.setAttribute("membershipType", membershipType);
    box.setAttribute("categoryId", categoryId);

    /**
     * 产品分类
     */
    List<Product> productCategoryList = productService.queryProductCategory(supplierId);
    box.setAttribute("productCategoryList", productCategoryList);
    /**
     * 商品列表
     */
    PageInfo pi=productService.queryProductById(supplierId, categoryId, sortedId, isTailGoods,box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);

    // 尾货数
    int tailGoodsCount =productService.queryTailGoodsNum(supplierId);
  
    box.setAttribute("tailGoodsCount", tailGoodsCount);

    return createModelAndView("/shop/supplier/shopIndex.jsp", box);
  }

  /**
   * 商家公告
   * 
   * @param id
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/shop/notice/{shopUrl}")
  public ModelAndView supplierNotice(@PathVariable String shopUrl, HttpServletRequest request, HttpServletResponse response) {
    log.debug("ShopController.supplierNotice()");
    Box box = loadNewBox(request);
    int supplieId = userService.queryUserIdByUrl(shopUrl);
    List<Message> messageList = messageService.showLastMessage(supplieId);
    box.setAttribute("messageList", messageList);
    return createModelAndView("/shop/supplier/supplierNotice.jsp", box);
  }

  /**
   * 公司简介
   * 
   * @param shopUrl
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/shop/brief/{shopUrl}")
  public ModelAndView supplierBrief(@PathVariable String shopUrl, HttpServletRequest request, HttpServletResponse response) {

    log.debug("ShopController.supplierBrief()");
    Box box = loadNewBox(request);
    int supplierId = userService.queryUserIdByUrl(shopUrl);
    Page page = pageService.findPageByUserIdAndFwcn(supplierId);
    box.setAttribute("page", page);
    return createModelAndView("/shop/supplier/supplierBrief.jsp", box);

  }

  /**
   * 厂家名片，暂时不实现，以后用二维码做
   * 
   * @param shopUrl
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/shop/{shopUrl}/card/businessCard")
  public ModelAndView supplierCard(@PathVariable String shopUrl, HttpServletRequest request, HttpServletResponse response) {
    return null;
  }
}
