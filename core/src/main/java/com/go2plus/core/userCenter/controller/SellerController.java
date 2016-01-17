package com.go2plus.core.userCenter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.go2plus.common.X;
import com.go2plus.common.json.Json;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.common.service.MessageService;
import com.go2plus.core.publish.service.LogDownloadService;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.userCenter.service.SellerService;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.ComplainCategory;
import com.go2plus.core.userCenter.vo.InSeller2Product;
import com.go2plus.core.userCenter.vo.SellerBlackList;
import com.go2plus.core.userCenter.vo.UserMeta;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 2B端卖家中心controller
 * 
 * @author gzh
 * @see 20151106
 */
@Controller
public class SellerController extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(SellerController.class);
  @Resource
  private SellerService       sellerService;

  @Resource
  private MessageService      messageService;

  @Resource
  private LogDownloadService  logDownloadService;

  @Resource
  private UserService         userService;

  // 卖家-销售产品列表-数据包图片(首页)
  @RequestMapping("/userCenter/seller/picPackage")
  public ModelAndView sellerIndex(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.sellerIndex()");
    Box box = loadNewBox(request);

    String year = box.$p("year");
    String[] yearArray = { "theYearBeforeLastYear", "lastYear", "thisYear" };
    String table = "";

    if (Arrays.asList(yearArray).contains(year)) {
      switch (year) {
      case "theYearBeforeLastYear":
        table = "log_download_" + X.getPreviousYear(-2).toString();
      case "lastYear":
        table = "log_download_" + X.getPreviousYear(-1).toString();
      case "thisYear":
        table = "log_download";
      default:
        table = "log_download";
      }
    } else {
      table = "log_download";
    }

    int userId = 49786;

    PageInfo pi = logDownloadService.getLogDownloads(userId, table, box.getPagination());
    int picNum = (int) pi.getTotal();

    box.setAttribute("picNum", picNum);
    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("subNav", "index");
    box.setAttribute("page", "index");
    return createModelAndView("/userCenter/seller/picPackage.jsp", box);
  }

  /**
   * 删除下载的商品
   * 
   * @param id
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = "/userCenter/seller/delLogDownload/")
  @ResponseBody
  public String sellerDelLogDownload(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.delLogDownload()");

    String[] ids = request.getParameterValues("ids[]");
    int rows = logDownloadService.delLogDownload(ids);
    return Integer.toString(rows);
  }

  /**
   * 2B端 收藏的商品
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping("/userCenter/seller/favorite")
  public ModelAndView sellerFavorite(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.sellerFavorite()");
    Box box = loadNewBox(request);

    Integer userId = 361;
    PageInfo pi = sellerService.getSellerFavorite(userId, box.getPagination());

    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("subNav", "index");
    box.setAttribute("page", "favorite");
    return createModelAndView("/userCenter/seller/favorite.jsp", box);
  }

  /**
   * 2B端 在淘宝的商品
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = "/userCenter/seller/taobaoItem")
  public ModelAndView sellerGetTaobaoItem(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.sellerGetTaobaoItem()");
    Box box = loadNewBox(request);

    Calendar calendar = Calendar.getInstance();
    String year = Integer.toString(calendar.get(Calendar.YEAR));
    String[] yearArray = { "theYearBeforeLastYear", "lastYear", "thisYear", "ThreeYearsAgo" };
    String table = "";

    if (Arrays.asList(yearArray).contains(year)) {
      switch (year) {
      case "ThreeYearsAgo":
        table = "taobao_item" + X.getPreviousYear(-3).toString();
      case "theYearBeforeLastYear":
        table = "taobao_item" + X.getPreviousYear(-2).toString();
      case "lastYear":
        table = "taobao_item_" + X.getPreviousYear(-1).toString();
      case "thisYear":
        table = "taobao_item";
      default:
        table = "taobao_item";
      }
    } else {
      table = "taobao_item";
    }

    int userId = 49786;
    String taobaoNick = "";

    PageInfo pi = sellerService.getTaobaoItem(userId, taobaoNick, box.getPagination());

    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("subNav", "index");
    box.setAttribute("page", "taobaoItem");
    return createModelAndView("/userCenter/seller/taobaoItem.jsp", box);
  }

  /**
   * 2B端 在阿里的商品
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuuyanlin
   */
  @RequestMapping("/userCenter/seller/aliItem")
  public ModelAndView sellerGetAliItem(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.sellerGetTaobaoItem()");
    Box box = loadNewBox(request);

    int userId = 88662;
    String aliNick = "";
    PageInfo pi = sellerService.getAliItem(userId, aliNick, box.getPagination());

    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("subNav", "index");
    box.setAttribute("page", "aliItem");
    return createModelAndView("/userCenter/seller/aliItem.jsp", box);
  }

  /**
   * 2B端 删除在淘宝商品
   * 
   * @param id
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping("/userCenter/seller/delTaobaoItem/")
  @ResponseBody
  public String delTaobaoItem(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.delTaobaoItem()");
    Box box = loadNewBox(request);

    String[] ids = request.getParameterValues("ids[]");
    String id = ids[0];

    Calendar calendar = Calendar.getInstance();
    String year = Integer.toString(calendar.get(Calendar.YEAR));

    String[] yearArray = { "theYearBeforeLastYear", "lastYear", "thisYear", "ThreeYearsAgo" };
    String table = "";

    if (Arrays.asList(yearArray).contains(year)) {
      switch (year) {
      case "ThreeYearsAgo":
        table = "taobao_item" + X.getPreviousYear(-3).toString();
      case "theYearBeforeLastYear":
        table = "taobao_item" + X.getPreviousYear(-2).toString();
      case "lastYear":
        table = "taobao_item_" + X.getPreviousYear(-1).toString();
      case "thisYear":
        table = "taobao_item";
      default:
        table = "taobao_item";
      }
    } else {
      table = "taobao_item";
    }

    int rows = sellerService.delTaobaoItem(Integer.parseInt(id), table);

    return Integer.toString(rows);
  }

  /**
   * 2B端 删除在阿里商品
   * 
   * @param id
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping("/userCenter/seller/delAliItem")
  @ResponseBody
  public String delAliItem(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.delAliItem()");
    Box box = loadNewBox(request);
    String[] ids = request.getParameterValues("ids[]");
    String id = ids[0];

    Integer userId = 49786;
    int rows = sellerService.delAliItem(id);

    return Integer.toString(rows);
  }

  /**
   * 2B端 下载过的厂家
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping("/userCenter/seller/supplier")
  public ModelAndView getDownSupplier(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.getDownSupplier()");
    Box box = loadNewBox(request);

    Integer userId = 35964;
    PageInfo pi = sellerService.getDownloadSupplier(userId, box.getPagination());
    int dowloadNum = (int) pi.getTotal();

    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("dowloadNum", dowloadNum);
    box.setAttribute("subNav", "supplier");
    box.setAttribute("page", "supplier");
    return createModelAndView("/userCenter/seller/downloadSupplier.jsp", box);
  }

  /**
   * 2B端 修改资料
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping("/userCenter/seller/myInfo")
  public ModelAndView sellerMyInfoForm(HttpServletRequest request, HttpServletResponse response) {
    log.debug("sellerMyInfo");
    Box box = loadNewBox(request);
    Integer userId = 35964;

    UserMeta user = userService.findUseMeta(userId);

    box.setAttribute("userForm", user);
    box.setAttribute("subNav", "myInfo");
    box.setAttribute("page", "myInfo");
    return createModelAndView("/userCenter/seller/myInfo.jsp", box);
  }

  /**
   * 2B端 修改资料
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = "/userCenter/seller/myInfo", method = RequestMethod.POST)
  public ModelAndView sellerMyInfoSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") UserMeta user) {
    log.debug("sellerMyInfo");
    Box box = loadNewBox(request);

    userService.updateUserMeta(user);

    box.setAttribute("userForm", user);
    box.setAttribute("subNav", "user");
    return createModelAndView("/userCenter/seller/myInfo.jsp", box);
  }

  /**
   * 显示黑名单
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/userCenter/seller/sellerBlackList")
  public ModelAndView sellerBlackList(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.sellerBlackList()");
    Box box = loadNewBox(request);

    // String sellerId = box.$cv(X.USER);
    String sellerId = "35964";

    PageInfo pi = sellerService.selectSellerBlackList(sellerId, box.getPagination());
    int blackTotalNum = (int) pi.getTotal();

    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("blackTotalNum", blackTotalNum);
    box.setAttribute("subNav", "sellerBlackList");
    box.setAttribute("page", "sellerBlackList");
    return createModelAndView("/userCenter/seller/sellerBlackList.jsp", box);
  }

  /**
   * 选择添加黑名单原因
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/userCenter/seller/blackListOption")
  public ModelAndView blackListOption(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.blackListOption()");
    Box box = loadNewBox(request);

    // String sellerId = box.$cv(X.USER);
    String sellerId = "35964";

    // 黑名单供应商
    List<InSeller2Product> blackListSupplier = sellerService.querySellerBlackListOptionSupplier(sellerId);
    // 黑名单原因
    List<ComplainCategory> blackListReason = sellerService.queryAddBlackListOptionReason();

    box.setAttribute("blackListSupplier", blackListSupplier);
    box.setAttribute("blackListReason", blackListReason);

    box.setAttribute("subNav", "sellerBlackList");
    box.setAttribute("page", "sellerBlackList");
    return createModelAndView("/userCenter/seller/blackListOption.jsp", box);
  }

  /**
   * 添加黑名单
   * 
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/userCenter/seller/addBlackList")
  @ResponseBody
  public String addBlackList(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("UserController.blackListOption()");
    Box box = loadNewBox(request);

    // 获取表单提交的数据
    // String sellerId = box.$cv(X.USER);
    String sellerId = "35964";

    String supplierId = box.$p("supplierId");
    String comment = box.$p("comment");

    // 组装对象
    SellerBlackList sellerBlackList = new SellerBlackList();
    sellerBlackList.setSellerUserId(Integer.parseInt(sellerId));
    sellerBlackList.setSupplierUserId(Integer.parseInt(supplierId));
    sellerBlackList.setComment(comment);
    sellerBlackList.setState(1);

    int rows = sellerService.saveSellerBlackList(sellerBlackList);

    // 重定向到黑名单首页
    return Integer.toString(rows);
  }

  /**
   * 删除黑名单
   * 
   * @param id
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping(value = "/userCenter/seller/deleteBlackList/{id}")
  @ResponseBody()
  public String deleteBlackList(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("UserController.deleteBlackList()");
    Box box = loadNewBox(request);
    int rows = sellerService.deleteSellerBlackList(id);

    box.setAttribute("subNav", "supplier");
    // 重定向到黑名单首页
    return Integer.toString(rows);
  }

  /**
   * 
   * 消息管理
   */
  /**
   * 产品公告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/seller/productNotice")
  public ModelAndView productNotice(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.productNotice()");
    Box box = loadNewBox(request);

    // String sellerId = box.$cv(X.USER);
    String sellerId = "252";

    PageInfo pi = messageService.querySellerProductNotice(sellerId, box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);

    box.setAttribute("subNav", "productNotice");
    box.setAttribute("page", "productNotice");
    return createModelAndView("/userCenter/seller/productNotice.jsp", box);
  }

  /**
   * 厂家公告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/seller/supplierNotice")
  public ModelAndView suppliertNotice(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.supplierNotice()");
    Box box = loadNewBox(request);

    // String sellerId = box.$cv(X.USER);
    String sellerId = "252";
    PageInfo pi = messageService.querySellerSupplierNotice(sellerId, box.getPagination());
    box.setAttribute(X.PAGINATION_DATA, pi);
    box.setAttribute("subNav", "productNotice");
    box.setAttribute("page", "supplierNotice");
    return createModelAndView("/userCenter/seller/supplierNotice.jsp", box);
  }

  @RequestMapping("/userCenter/seller/toolManagement")
  public ModelAndView sellerToolManagement(HttpServletRequest request, HttpServletResponse response) {
    log.debug("sellerController.sellerToolManagement()");

    Box box = loadNewBox(request);

    return createModelAndView("/userCenter/seller/toolManagement.jsp", box);
  }

  /**
   * 工具管理
   */
  @RequestMapping(value = "/userCenter/seller/tools")
  public void manageTools(HttpServletRequest request, HttpServletResponse response) {

  }

  /**
   * 无线详情
   */

  @RequestMapping(value = "/userCenter/seller/taobao/wireless/")
  public void taobaoWireless(HttpServletRequest request, HttpServletResponse response) {

  }

}
