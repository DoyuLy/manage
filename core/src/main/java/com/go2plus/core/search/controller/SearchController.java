package com.go2plus.core.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.go2plus.common.mvc.BaseController;
import com.go2plus.core.props.controller.PropsController;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 根据参数跳转到现有的搜索平台。
 * 
 * @author denglin
 * @since 2015-11-13
 */


@Controller
public class SearchController  extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(PropsController.class);
  
  /**
   * 跳转到现在的搜索页面
   * @param request
   * @param response
   * @return
   */
 @RequestMapping("/search")
 public void welcome(HttpServletRequest request, HttpServletResponse response) {
   log.debug("PortalController.welcome()");
  
   try {
     String channel = request.getParameter("channel");  // 频道 （如：一手货源）
     String cid = request.getParameter("cid");  // 市场，分类等
     String keyword = request.getParameter("keyword");  // 输入的关键字
     String props = request.getParameter("props");  // 淘宝中属性（如 122216587:6474787）
     String page = request.getParameter("page");  // 分页数量
     String sort = request.getParameter("sort");  // 排序方式
     String pid = request.getParameter("pid");  // 对应原系统中url中的“w”
     
     channel = !"".equals(channel) && channel != null ? channel : "firsthand";
     cid     = !"".equals(cid) && cid != null ? cid : "all";
     keyword = !"".equals(keyword) && keyword != null ? keyword : "123" ;
     props   = !"".equals(props) && props != null ? props : "" ;
     page    = !"".equals(page) && page != null  ? page : "1" ;
     sort    = !"".equals(sort) && sort != null ? sort : "0";
     pid     = !"".equals(pid) && pid != null ? pid : "1";

     response.sendRedirect("http://search.go2.cn/search/" + channel + "-" + cid + "-" + keyword + "-" + props.replace("x", "+") + "-" + page + "-" + sort + "?w=" + pid);
  } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  //return createModelAndView("core/portal/welcome.jsp");
 }
  
}
