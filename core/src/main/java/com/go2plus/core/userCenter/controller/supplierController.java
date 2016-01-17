package com.go2plus.core.userCenter.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.X;
import com.go2plus.common.json.Result;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.ad.service.AdService;
import com.go2plus.core.common.vo.FinalResultVo;
import com.go2plus.core.common.vo.ResultVo;
import com.go2plus.core.page.service.PageService;
import com.go2plus.core.page.vo.Page;
import com.go2plus.core.product.service.ProductService;
import com.go2plus.core.product.vo.Category;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.service.SupplierService;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.Complain;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierRank;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 供应商Controller, 处理供应商相关的请求
 * 
 * @author gzh
 * @since 2015-10-20
 */
@Controller
public class supplierController extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(supplierController.class);

  @Resource
  private SupplierService     supplierService;

  @Resource
  private PageService         pageService;

  @Resource
  private UserService         userService;

  @Resource
  private ProductService      productService;

  @Resource
  private AdService           adService;

  // 厂家-我的卖家-会员下载统计
  @RequestMapping("/userCenter/supplier/vipLoad")
  public ModelAndView vipLoad(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.vipLoad()");
    Box box = loadNewBox(request);
    int userId = 0;
    String user = box.$cv("user");
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    Supplier supplier = supplierService.findSupplierByUserId(userId);
    // 测试例子
    PageInfo pi = supplierService.vipDownload(supplier.getId(), box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("subNav", "seller");
    box.setAttribute("page", "vipLoad");
    return createModelAndView("/userCenter/supplier/vipLoad.jsp", box);
  }

  // 厂家-我的卖家-产品下载记录
  @RequestMapping("/userCenter/supplier/productLoad")
  public ModelAndView productLoad(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.productLoad()");
    Box box = loadNewBox(request);
    int userId = 0;
    String user = box.$cv("user");
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    Supplier supplier = supplierService.findSupplierByUserId(userId);
    int suppilerId = supplier.getId();
    PageInfo pi=supplierService.productDownload(suppilerId,box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);

    box.setAttribute("subNav", "seller");
    box.setAttribute("page", "productLoad");
    return createModelAndView("/userCenter/supplier/productLoad.jsp", box);
  }

  // 厂家-我的卖家-淘宝产品列表
  @RequestMapping("/userCenter/supplier/taobaoProduct")
  public ModelAndView taobaoProduct(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.taobaoProduct()");
    Box box = loadNewBox(request);

    int userId = 0;
    String user = box.$cv("user");
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    Supplier supplier = supplierService.findSupplierByUserId(userId);
    int suppilerId = supplier.getId();
    PageInfo pi=supplierService.taobaoProductPublish(suppilerId,box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);

    box.setAttribute("subNav", "seller");
    box.setAttribute("page", "taobaoProduct");
    return createModelAndView("/userCenter/supplier/taobaoProduct.jsp", box);
  }

  /**
   * 厂家-我的资料-修改资料
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping("/userCenter/supplier/myInfo")
  public ModelAndView myInfoForm(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.myInfo()");
    Box box = loadNewBox(request);
    int userId = 0;
    String user = box.$cv("user");
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    Supplier supplier = supplierService.findSupplierByUserId(userId);
    if (supplier == null) {
      supplier = new Supplier();
    }
    box.setAttribute("supplierForm", supplier);
    box.setAttribute("subNav", "info");
    box.setAttribute("page", "myInfo");
    return createModelAndView("/userCenter/supplier/myInfo.jsp", box);
  }

  /**
   * 厂家-我的资料-修改资料
   * 
   * @param request
   * @param response
   * @param user
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = "/userCenter/supplier/myInfo", method = RequestMethod.POST)
  public ModelAndView myInfoSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("supplier") Supplier supplier) {
    log.debug("UserController.myInfo()");
    Box box = loadNewBox(request);
    supplierService.updateSupplierProfile(supplier);
    box.setAttribute("subNav", "info");
    box.setAttribute("page", "myInfo");
    box.setAttribute("supplierForm", supplier);
    return createModelAndView("/userCenter/supplier/myInfo.jsp", box);
  }

  /**
   * 厂家-我的资料-服务承诺
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping("/userCenter/supplier/promise")
  public ModelAndView promiseForm(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.promiseForm()");
    Box box = loadNewBox(request);
    int userId = 0;
    String user = box.$cv("user");
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    box.setAttribute("subNav", "info");
    box.setAttribute("page", "promise");
    Page page = pageService.findPageByUserIdAndFwcn(userId);
    if (page == null) {
      page = new Page();
      page.setUserId(userId);
      page.setContent("");
    }
    box.setAttribute("pageForm", page);
    return createModelAndView("/userCenter/supplier/promise.jsp", box);
  }

  /**
   * 厂家-我的资料-服务承诺
   * 
   * @param request
   * @param response
   * @param user
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = "/userCenter/supplier/promise", method = RequestMethod.POST)
  public ModelAndView promiseSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("page") Page page) {
    log.debug("UserController.promisSubmit()");
    Box box = loadNewBox(request);
    box.setAttribute("subNav", "info");
    box.setAttribute("page", "promise");
    int userId = 0;
    String user = box.$cv("user");
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    Page oldPage = pageService.findPageByUserIdAndFwcn(userId);

    if (oldPage == null) {
      Page newPage = new Page();
      newPage.setUserId(userId);
      newPage.setTitle("服务承诺");
      newPage.setContent(page.getContent());
      newPage.setState(1);

      // SimpleDateFormat sdf = new
      // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      // Date date = new Date();
      // Date currentTime = sdf.format(new Date());

      newPage.setCreateTime(new Date());
      newPage.setUpdateTime(new Date());

      pageService.insertPage(newPage);
      page = newPage;
    } else {
      pageService.updatePageByUserIdAndFwcn(page);
    }

    box.setAttribute("pageForm", page);
    return createModelAndView("/userCenter/supplier/promise.jsp", box);
  }
  
  /**
   * 供货商商品列表初始化
   * @param response
   */
  @RequestMapping("/userCenter/supplier/productList")
  public void productListIndex(HttpServletResponse response){
    try {
      response.sendRedirect("/userCenter/supplier/productList/all");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 厂家-我的产品-产品列表
   * 
   * @param request
   * @param response
   * @param
   * @return
   * 
   * @author duyu
   */
  @RequestMapping("/userCenter/supplier/productList/{searchType}")
  public ModelAndView productList(@PathVariable String searchType,HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.productList()");
    Box box = loadNewBox(request);
    box.setAttribute("subNav", "product");
    box.setAttribute("page", "productList");
    int userId = 0;
    String user = box.$cv("user");
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    // 获取请求参数
    String key = box.$p("key");
    //String searchType = box.$p("searchType");
    if(StringUtils.isEmpty(searchType)){
      searchType = "all";
    }
    
    PageInfo<Product> pi = productService.getProductsListById(userId, searchType, key, box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("searchType",searchType);
    box.setAttribute("key",key);
    return createModelAndView("/userCenter/supplier/productList.jsp", box);
  }
  
  /**
   * 排序
   * @author liyang
   * @return 结果
   */
  @RequestMapping(value="userCenter/supplier/productSort",produces = "application/json;charset=utf-8")
  @ResponseBody
  public String sortProduct(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.sortProduct()");
    Box box = loadNewBox(request); 
    String user = box.$cv("user");
    int userId = 0;
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    String goodsId = box.$p("goodsId");
    int page = Integer.parseInt(box.$p("page"));
    int goosNum = Integer.parseInt(box.$p("goosNum"));
    productService.updateWeight(userId, goodsId, page, goosNum,20);
    Result<Boolean> result = new Result<>();
    result.setData(true);
    result.setMessage("success");
    result.success();
    return JSON.toJSONString(result);
  }
  
  /**
   * 商品置顶
   * @param request
   * @param response
   * @author liyang
   * @return
   */
  @RequestMapping(value="userCenter/supplier/productSetTop",produces = "application/json;charset=utf-8")
  @ResponseBody
  public String setTop(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.setTop()");
    Box box = loadNewBox(request); 
    int productId = Integer.parseInt(box.$p("productId"));
    String user = box.$cv("user");
    int userId = 0;
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    boolean rt = productService.setTop(productId, userId);
    Result<Boolean> result = new Result<>();
    if(rt){
      result.setData(true);
      result.success();
      result.setMessage("");
    }else{
      result.setData(false);
      result.setMessage("操作失败");
    }
    return JSON.toJSONString(result);
    
  }
  
  /**
   * 上架下架删除
   * @author liyang
   * @return
   */
  @RequestMapping(value="userCenter/supplier/added",produces = "application/json;charset=utf-8")
  @ResponseBody
  public String added(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.added()");
    Box box = loadNewBox(request);
    //获取参数
    
    //商品id
    int productId = Integer.parseInt(box.$p("productId"));
    String user = box.$cv("user");
    int userId = 0;
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    //商品操作1:上架0:下架-1:删除
    int flag = Integer.parseInt(box.$p("flag")==null?"0":box.$p("flag"));
    Result<Boolean> result = productService.updateAdded(productId, userId, flag);
    return JSON.toJSONString(result);
  }
  
  /**
   * 关联与取消关联
   * @author liyang
   * @return
   */
  @RequestMapping(value="userCenter/supplier/highLight",produces = "application/json;charset=utf-8")
  @ResponseBody
  public String highLight(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.highLight()");
    Box box = loadNewBox(request);
    //获取参数
    
    //商品id
    int productId = Integer.parseInt(box.$p("productId"));
    String user = box.$cv("user");
    int userId = 0;
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    //flag=1关联 flag=0 取消关联
    int flag = Integer.parseInt(box.$p("flag")==null?"0":box.$p("flag"));
    Result<Boolean> result = productService.updateHighLight(productId, userId, flag);
    return JSON.toJSONString(result);
  }
  
  /**
   * 修改最低零售价
   * @author liyang
   * @return
   */
  @RequestMapping(value="userCenter/supplier/updateMinPrice",produces = "application/json;charset=utf-8")
  @ResponseBody
  public String minSalePriceHadder(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.minSalePriceHadder()");
    //创建json模型
    Result<Boolean> result = new Result<>();
    Box box = loadNewBox(request);
    int productId = 0;
    double price = 0;
    double minPrice = 0;
    try{
      //参数
      productId = Integer.parseInt(box.$p("productId"));
      price = Double.parseDouble(box.$p("price"));
      minPrice = Double.parseDouble(box.$p("minPrice"));
    }catch (Exception e) {
      result.setData(false);
      result.setMessage("参数错误");
      return JSON.toJSONString(result);
    }
    //最低零售及不得低于拿货价
    if(minPrice<price && minPrice!=0){
      result.setData(false);
      result.setMessage("最低零售价不得低于拿货价!");
    }
    if(minPrice>3000){
      result.setData(false);
      result.setMessage("最低零售价不得高于3000!");
    }
    boolean rt = productService.updateMinPirice(productId, minPrice);
    if(rt){
      if(minPrice==0){
        result.setData(true);
        result.setMessage("最低零售价取消成功!");
        result.success();
      }else{
        result.setData(true);
        result.success();
        result.setMessage("保存成功!");
      }
    }
    return JSON.toJSONString(result);
  }

  
  /**
   * 标签变化
   * @author liyang
   * @return
   */
  @RequestMapping(value="userCenter/supplier/changeLabel",produces = "application/json;charset=utf-8")
  @ResponseBody
  public String changeLabel(HttpServletRequest request, HttpServletResponse response) {
    //创建json模型
    Result<Boolean> result = new Result<>();
    log.debug("UserController.changeLabel()");
    Box box = loadNewBox(request);
    String user = box.$cv("user");
    int userId = 0;
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    int productId = 0;
    int label = 0;
    try{
      //参数
      productId = Integer.parseInt(box.$p("productId"));
      label = Integer.parseInt(box.$p("label")==null?"0":box.$p("label"));
    }catch (Exception e) {
      result.setData(false);
      result.setMessage("参数错误!");
      return JSON.toJSONString(result);
    }
    //修改标签
    boolean rt = productService.updateLabel(productId, label,userId);
    if(rt){
      result.setData(true);
      result.setMessage("");
      result.success();
    }else{
      result.setData(false);
      result.setMessage("保存失败!");
    }
    return JSON.toJSONString(result);
  }
  
  /**
   * 厂家-我的产品-快速发布产品
   * 
   * @param request
   * @param response
   * @param
   * @return
   * 
   * @author duyu
   */
  @RequestMapping("/userCenter/supplier/fastPublish")
  public ModelAndView fastPublish(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.fastPublish()");
    Box box = loadNewBox(request);
    box.setAttribute("subNav", "product");
    box.setAttribute("page", "fastPublish");
    return createModelAndView("/userCenter/supplier/fastPublish.jsp", box);
  }

  /**
   * 厂家-我的产品-自助发布产品
   * 
   * @param request
   * @param response
   * @param
   * @return
   * 
   * @author duyu
   */
  @RequestMapping("/userCenter/supplier/selfPublish")
  public ModelAndView selfPublish(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.selfPublish()");
    Box box = loadNewBox(request);
    box.setAttribute("subNav", "product");
    box.setAttribute("page", "selfPublish");

    int pageSize = 20;
    int pageIndex = 1;
    int offset = (pageIndex - 1) * pageSize;
    List<Category> categorys = productService.getAllCategory(offset, pageSize);
    int totalcount = categorys.size();

    // String json = JSON.toJSONString(categorys);

    ResultVo result = new ResultVo(totalcount, pageSize, pageIndex, "", "", categorys);
    FinalResultVo resultVo = new FinalResultVo(true, result, "");
    box.setAttribute("data", resultVo);

    return createModelAndView("/userCenter/supplier/selfPublish.jsp", box);
  }

  /**
   * 厂家-我的产品-检测商品编号是否可用
   * 
   * @param request
   * @param response
   * @param
   * @return
   * 
   * @author duyu
   */
  @RequestMapping("/userCenter/supplier/checkArticlekNum")
  @ResponseBody()
  public String checArticlekNum(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.selfPublish()");
    Box box = loadNewBox(request);
    String articleNum = box.$p("articleNumber");
    box.setAttribute("subNav", "product");
    int userId = 51;
    boolean code = productService.checkArticlekNum(userId, articleNum);

    box.setAttribute("data", code);
    return code ? "1" : "0";
  }

  /**
   * 厂家-我的产品-收到投诉
   * 
   * @param request
   * @param response
   * @param
   * @return
   * 
   * @author duyu
   */
  @RequestMapping("/userCenter/supplier/complaint")
  public ModelAndView complaint(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.complaint()");
    Box box = loadNewBox(request);
    box.setAttribute("subNav", "product");
    box.setAttribute("page", "complaint");

    // 模拟请求参数
    int userId = 12460;
    PageInfo<Complain> pi = productService.getComplainListById(userId, box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);

    return createModelAndView("/userCenter/supplier/complaint.jsp", box);
  }

  /**
   * 厂家广告--一手货源广告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/supplier/promotion/index")
  public ModelAndView promotionIndex(HttpServletRequest request, HttpServletResponse response) {
    return null;
  }

  /**
   * 厂家广告--用户中心广告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/supplier/promotion/uclist")
  public ModelAndView promotionUclist(HttpServletRequest request, HttpServletResponse response) {
    return null;
  }

  /**
   * 厂家广告--搜索结果广告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/supplier/promotion/splist")
  public ModelAndView promotionSplist(HttpServletRequest request, HttpServletResponse response) {
    // TODO record log

    Box box = loadNewBox(request);
    // String userId = box.$cv(X.USER);
    Integer userId = 38;
    Supplier supplier = supplierService.findSupplierByUserId(userId);

    Date startTime = null;
    Date doneTime = null;

    if (true || true) {
      startTime = null;
    } else {
      startTime = null;
      doneTime = null;
    }

    if (supplier.getMarketId() == 5 && supplier.getCertifiedType() > 0) {

    } else {
      // TODO 无法使用该功能
    }

    if (adService.isTop100Supplier(userId)) {

    }

    Integer checkOrderedOrNot = adService.checkSPRule(startTime, userId);

    if (checkOrderedOrNot > 0) {

    } else {
      Integer price = 300;
      Integer discount = 1;

      List<Promotion> orderedPromotion = adService.getOrderedSPsBy(startTime);

      if (doneTime != null) {
        List<Promotion> lastOrderedPromotion = adService.getOrderedSPsBy(doneTime);
      }

      // TODO 处理orderedPromotion lastOrderedPromotion 时间的处理
    }

    return null;
  }

  /**
   * 厂家广告--市场商家广告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/supplier/promotion/sulist")
  public ModelAndView promotionSulist(HttpServletRequest request, HttpServletResponse response) {
    return null;
  }

  /**
   * 厂家广告--我订购的广告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/supplier/promotion/myfps")
  public ModelAndView promotionMyfps(HttpServletRequest request, HttpServletResponse response) {
    return null;
  }

  /**
   * 厂家广告--厂家排名榜
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/supplier/promotion/billboard")
  public ModelAndView promotionBillboard(HttpServletRequest request, HttpServletResponse response) {

    Box box = loadNewBox(request);
    // Integer userId = Integer.parseInt(box.$cv(X.USER));
    Integer userId = 38;
    Supplier supplier = supplierService.findSupplierByUserId(userId);

    if (supplier.getMarketId() == 5 && supplier.getCertifiedType() > 0) {

    } else {
      // TODO 无法使用该功能
    }

    SupplierRank supplierRank = supplierService.getRankByUserId(userId);
    List<SupplierRank> supplierRankList = adService.getTop500();

    box.setAttribute("userId", userId);
    box.setAttribute("supplierRank", supplierRank);
    box.setAttribute("supplierRankList", supplierRankList);

    return createModelAndView("/userCenter/supplier/promotion/billboard.jsp", box);
  }
}
