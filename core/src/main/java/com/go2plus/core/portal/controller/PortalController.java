
package com.go2plus.core.portal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.X;
import com.go2plus.common.json.Json;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.common.mvc.Pagination;
import com.go2plus.core.backgroundManage.service.NavigationBarService;
import com.go2plus.core.backgroundManage.vo.NavigationBar;
import com.go2plus.core.guang.service.GuangService;
import com.go2plus.core.guang.vo.Guang;
import com.go2plus.core.portal.service.PortalService;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.service.PromotionService;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.service.SupplierService;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 主页Controller
 * 
 * @author gaofeng
 * @since 2015-10-20
 */
@Controller
public class PortalController extends BaseController {
  private final static Logger  log = LoggerFactory.getLogger(PortalController.class);

  @Resource
  private PortalService        portalService;

  @Resource
  private SupplierService      supplierService;

  @Resource
  private NavigationBarService navigationBarService;
  @Resource
  private PromotionService    promotionService;
  
  @Resource
  private GuangService        guangService;

  /**
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/portal/index")
  public ModelAndView index1(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.index()");
    Box box = loadNewBox(request);
    return createModelAndView("core/portal/index.jsp", box);
  }

  // 卖家（2b）用户中心测试页面
  @RequestMapping("/portal/userIndex")
  public ModelAndView userIndex(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.userIndex()");
    String keys = request.getParameter("keys");
    String kinds = request.getParameter("kinds");
    String nselect = "";
    String pselect = "";
    if (keys == null) {
      keys = "";
    }
    if (kinds == null) {
      nselect = "selected";
    } else if (kinds.equals("p")) {
      pselect = "selected";
    } else {
      nselect = "selected";
    }
    Box box = loadNewBox(request);
    box.setAttribute("keys", keys);
    box.setAttribute("pselect", pselect);
    box.setAttribute("nselect", nselect);
    return createModelAndView("userCenter/seller/userIndex.jsp", box);
  }

  // 首页
  /*
  @RequestMapping("/")
  public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.index()");
    Box box = loadNewBox(request);
    
    //
    Cookie c = new Cookie(X.USER, "51");
  c.setPath("/");
  c.setMaxAge(-1);
  box.getCookie().put(X.USER, c);
  Cookie userType = new Cookie(X.USER_TYPE, "1");
  userType.setPath(X.WEB_ROOT);
  userType.setMaxAge(-1);
  box.getCookie().put(X.USER_TYPE, userType);
  writeCookies(box, response);
  
  response.sendRedirect("/welcome");
  return null;
    //return createModelAndView("/signIn/index.jsp", box);
  }*/

  /**
   * 独家
   * 
   * @param request
   * @param response
   * @return
   * @throws IOException
   */
  @RequestMapping("/unique")
  public void uniqueIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.uniqueIndex()");
    response.sendRedirect("/unique/0-0");
  }

  @RequestMapping("/unique/{categoryId}-{sortId}")
  public ModelAndView unique(@PathVariable String categoryId, @PathVariable int sortId, HttpServletRequest request,
      HttpServletResponse response) {
    log.debug("PortalController.unique()");
    Box box = loadNewBox(request);
//    设置页面默认图片数
    Pagination pagination=new Pagination();
    pagination.setPageSize(50);
    pagination.setNavigationSize(9);
    pagination.setPageNum(1);
    PageInfo pi = portalService.getUniqueProduct(categoryId, sortId, pagination);
    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("categoryId", categoryId);
    box.setAttribute("sortId", sortId);
    box.setAttribute("nav", "unique");
    return createModelAndView("core/unique/unique.jsp", box);
  }

  /**
   *  逛逛初始化以及条件查询
   * @param request
   * @param response
   * @param guang
   * @return ModelAndView(条件，列表，总数)
   */
  @RequestMapping("/guang")
  public ModelAndView guang(HttpServletRequest request, HttpServletResponse response,Guang guang) {
    log.debug("PortalController.guang()");
    Box box = loadNewBox(request);
    String userId = box.$cv("user");
    if(guang.getPage()==null){
      guang.setPage(0);
    }else{
      guang.setPage((guang.getPage()-1)*20);
    }
    //返回参数
    box.setAttribute("guang",guang);
    //流行元素转换
    guang.setProps(guangService.propsCase(guang.getProps()));
    //加载逛逛列表,并存入缓存
    List<Guang> guangs = guangService.getGuangProductList(guang,userId);
    //按条件查询逛逛的总数
    Integer total = guangService.getGuangProductTotal(guang);
    //查出当季热卖各种类的数量
    HashMap<String,String> caregorysMap = guangService.getCountCategorys();
    box.setAttribute("caregorysMap", caregorysMap);
    box.setAttribute("guangs", guangs);
    box.setAttribute("total", total);
    box.setAttribute("nav", "guang");
    return createModelAndView("core/guang/guang.jsp", box);
  }
  
  /**
   * 瀑布流加载逛逛
   * @param request
   * @param response
   * @param guang
   * @return 逛逛列表
   */
  @RequestMapping(value="/guang/load",produces = "application/json;charset=utf-8")
  @ResponseBody
  public String guangLazyLoad(HttpServletRequest request, HttpServletResponse response,Guang guang) {
    log.debug("PortalController.guangLazyLoad()");
    Box box = loadNewBox(request);
    String userId = box.$cv("user");
    if(guang.getPage()==null){
      guang.setPage(0);
    }else{
      guang.setPage((guang.getPage()-1)*20);
    }
    //流行元素转换
    guang.setProps(guangService.propsCase(guang.getProps()));
    List<Guang> guangs = guangService.getGuangProductList(guang,userId);
    return Json.toJson(guangs);
  }
  
  /**
   * 逛逛添加一个喜欢
   * @param request
   * @param response
   * @param guang
   * @return
   */
  @RequestMapping(value="/guang/like")
  @ResponseBody
  public String guangLike(HttpServletRequest request, HttpServletResponse response,Guang guang) {
    log.debug("PortalController.guangLike()");
    Box box = loadNewBox(request);
    String userId = box.$cv("user");
    if(StringUtils.isEmpty(userId)){
      return "fail";
    }
    int likeNum = guangService.saveGuangLike(userId, guang.getProductId());
    return likeNum+"";
    
  }
  

  @RequestMapping("/supplier")
  public void supplierIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.supplierIndex()");

    response.sendRedirect("/supplier/0-0-1-all");
  }

  /**
   * 认证商家
   * 
   * @param marketId
   * @param capital
   * @param sort
   * @param keyword
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/supplier/{marketId}-{capital}-{sort}-{keyword}")
  public ModelAndView supplier(@PathVariable String marketId, @PathVariable String capital, @PathVariable String sort,
      @PathVariable String keyword, HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.supplier()");
    Box box = loadNewBox(request);

    Integer intMarketId = Integer.parseInt(marketId);
    Integer intSort = Integer.parseInt(sort);

    PageInfo<Product> pi = supplierService.getSupplierByCondition(99, "M", 2, "", box.getPagination());

    Integer[] emptyPromotionId = {};
    List<Promotion> promotionList = promotionService.getSponsers("f", emptyPromotionId);
    Integer[] notEmptyPromotionId = { 8329, 8330 };
    List<Promotion> promotionList1 = promotionService.getSponsers("x", notEmptyPromotionId);
    promotionList.addAll(promotionList1);

    List<Supplier> capitalList = supplierService.getCapitalByCondition(intMarketId, keyword);

    box.setAttribute("marketId", marketId);
    box.setAttribute("capital", capital);
    box.setAttribute("keyword", keyword);
    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("promotionList", promotionList);
    box.setAttribute("capitalList", capitalList);

    log.debug("TEST");
    return createModelAndView("core/supplier/supplier.jsp", box);
  }

  // 一件代发
  @RequestMapping("/dropshipper")
  public ModelAndView dropshipper(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.dropshipper()");
    Box box = loadNewBox(request);
    return createModelAndView("core/dropshipper/dropshipper.jsp", box);
  }

  // 摄影市场
  @RequestMapping("/cameraman")
  public ModelAndView cameraman(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.cameraman()");
    Box box = loadNewBox(request);
    return createModelAndView("core/cameraman/cameraman.jsp", box);
  }

  // 摄影市场
  @RequestMapping("/logistics")
  public ModelAndView logistics(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.logistics()");
    Box box = loadNewBox(request);
    return createModelAndView("core/logistics/logistics.jsp", box);
  }

  // 天马到店
  @RequestMapping("/store")
  public ModelAndView store(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.store()");
    Box box = loadNewBox(request);
    return createModelAndView("core/store/store.jsp", box);
  }

  // 产品详情页
  @RequestMapping("/product")
  public ModelAndView product(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.product()");
    Box box = loadNewBox(request);
    return createModelAndView("core/product/product.jsp", box);
  }


  /**
   * 首页
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/")
  public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.welcome()");
    Box box = loadNewBox(request);
    String category = box.$p("category");
    if (category == null || category.isEmpty()) {
      category = "all";
      box.setAttribute("category", category);
    }
    
    //广告画廊
    List<Promotion> banners = portalService.getBanners();
    //当天一手货源广告
    List<Promotion> curPromotions = portalService.getCurPromotions();
    //推荐精选广告
    List<Promotion> selections = portalService.getSelections();
    //拆分广告画廊为三个区域
    List<Promotion> banner1 = new ArrayList<>();
    List<Promotion> banner2 = new ArrayList<>();
    List<Promotion> banner3 = new ArrayList<>();

    for (Promotion p : banners) {
      // if(p.getPosX().(s))
      if (Pattern.compile("a1|a2|a3|a4|a5|a6").matcher(p.getPosX()).matches()) {
        banner1.add(p);
      }
      if (Pattern.compile("a7|a8|a9|a10").matcher(p.getPosX()).matches()) {
        banner2.add(p);
      }
      if (Pattern.compile("a11|a12|a13|a14").matcher(p.getPosX()).matches()) {
        banner3.add(p);
      }
    }

    box.setAttribute("banner1", banner1);
    box.setAttribute("banner2", banner2);
    box.setAttribute("banner3", banner3);
    
    box.setAttribute("promotions", curPromotions);
    box.setAttribute("selections", selections);

    String area = "一手货源";
    List<NavigationBar> navigationBars = navigationBarService.queryNavigationBarName(area);
    box.setAttribute("navigationBars", navigationBars);
    box.setAttribute("nav", "index");
    String b1 = Json.toJson(banners);
    String p1 = Json.toJson(curPromotions);
    String s1 = Json.toJson(selections);
    return createModelAndView("/core/welcome/welcome.jsp", box);
  }
  
  /**
   * 一手货源首页
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = { "/firsthand", "/firsthand/{category}/{page}/{sort}/{w}"})
  public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PortalController.firsthand()");
    Box box = loadNewBox(request);
    String category = box.$p("category");
    String page = box.$p("p");
    String sort = box.$p("sort");
    String w = box.$p("w");
    if (category == null || category.isEmpty()) {
      category = "all";
      box.setAttribute("category", category);
    }
    if(page == null || page.isEmpty()){
      page = "1";
      box.setAttribute("page", page);
    }
    if(sort == null || sort.isEmpty()){
      sort = "0";
      box.setAttribute("sort", sort);
    }
    if(w == null || w.isEmpty()){
      w = "";
      box.setAttribute("w", w);
    }

    // TODO SEO

    // 一级广告
    List<Promotion> banners = portalService.getBanners();

    // 当天广告
    List<Promotion> curPromotions = portalService.getCurPromotions();
    

    //String products = JSON.toJSONString(cthPromotions);

    /**
     * TODO from ES 
     * api     : /{category}/{page}/{sort}/{w}   /n3/1/0/w=4
     * category: {dc:'默认', n3:'三日新品', hs:'七日人气', ds:'厂家直销', cx:'清仓尾货', rq:'精品货源', zp:'真皮区', c0:'网货街' }
     * page    : 页码
     * sort    : {0 :'全部', 1:'新品', 2:'发布', 3:'下载', 4:'人气', 5:'价格升序', 6:'价格降序'}
     * w       : {1:'凉鞋', 2:'拖鞋', 3:'低帮鞋', 4:'鞋子', 5:'高帮鞋', 6:'雨鞋'}
     * 
     * ps:  "七日人气" 只会从 w = 1~7查询 (1~7为鞋类)
     */
    
    List<Product> cthPromotions = new ArrayList<Product>() ;
    //TODO ES 完结后再进行处理
    if(category.equals("all")){
      // 三日所有广告产品
        cthPromotions = portalService.getCthPromotions();
    }
    if(category.equals("n3")){
      // 三日所有广告产品
        cthPromotions = portalService.getCthPromotions();
    }
    if(category.equals("hs")){
      // 三日所有广告产品
        cthPromotions = portalService.getCthPromotions();
    }
    if(category.equals("ds")){
      // 三日所有广告产品
        cthPromotions = portalService.getCthPromotions();
    }
  if(category.equals("cx")){
    // 三日所有广告产品
      cthPromotions = portalService.getCthPromotions();
    }
  if(category.equals("rq")){
    // 三日所有广告产品
      cthPromotions = portalService.getCthPromotions();
  }
  if(category.equals("zp")){
    // 三日所有广告产品
      cthPromotions = portalService.getCthPromotions();
  }
  if(category.equals("c0")){
    // 三日所有广告产品
      cthPromotions = portalService.getCthPromotions();
  }

  
    String area = "一手货源";
    List<NavigationBar> navigationBars = navigationBarService.queryNavigationBarName(area);
    box.setAttribute("navigationBars", navigationBars);
    box.setAttribute("nav", "firsthand");
    
    box.setAttribute("banners", banners);
    box.setAttribute("cthPromotions", cthPromotions);

    return createModelAndView("/core/firsthand/firsthand.jsp", box);
  }

  /**
   * 三日新款
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/threeDaysNewProduct")
  public void newProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.welcome()");
    String url = null;
    response.sendRedirect(url);
  }

  /**
   * 七日人气
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/sevenDaysHotProduct")
  public void hotProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.hotProduct()");
    String url = null;
    response.sendRedirect(url);
  }

  /**
   * 厂家直供
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/supplyProduct")
  public void supplyProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.supplyProduct()");
    String url = null;
    response.sendRedirect(url);
  }

  /**
   * 清仓尾货
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/potterProduct")
  public void potterProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.potterProduct()");
    String url = null;
    response.sendRedirect(url);
  }

  /**
   * 精品货源
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/giftsProduct")
  public void giftsProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.giftsProduct()");
    String url = null;
    response.sendRedirect(url);
  }

  /**
   * 真皮区
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/genuineLeatherProduct")
  public void genuineLeatherProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.genuineLeatherProduct()");
    String url = null;
    response.sendRedirect(url);
  }

  /**
   * 网货街
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/cargoNetProduct")
  public ModelAndView cargoNetProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.cargoNetProduct()");
    Box box = loadNewBox(request);
    return createModelAndView("core/firsthand/cargoNetProduct.jsp", box);
  }

  /**
   * 主题选货
   * 
   * @param request
   * @param response
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/themeProduct")
  public void themeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.themeProduct()");
    response.sendRedirect("/specialTopic/themeProduct");
  }

  /**
   * 1212盛典
   * 
   * @param request
   * @param response
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/firsthand/grandCeremony")
  public void grandCeremony(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("PortalController.grandCeremony()");
    response.sendRedirect("/specialTopic/grandCeremony");
  }
}
