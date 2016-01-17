package com.go2plus.core.sign.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.go2plus.common.X;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 登录Controller, 处理用户登录相关的请求
 * 
 * @author duyu
 * @since 2015-10-20
 */
@Controller
public class SignOutController extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(SignOutController.class);
  
  /**
   * 登出
   * @param request
   * @param response
   * @return
   * @throws IOException 
   */
  @RequestMapping("/logout")
  public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Box box = loadNewBox(request);
    Cookie cu = new Cookie(X.USER, null);
    Cookie ct = new Cookie(X.USER_TYPE, null);
    cu.setMaxAge(0);
    ct.setMaxAge(0);
    box.getCookie().put(X.USER, cu);
    box.getCookie().put(X.USER_TYPE, ct);
    writeCookies(box, response);
    request.getSession().setAttribute(X.USER, null);  
	request.getSession().setAttribute(X.USER_TYPE, null);
	request.getSession().setAttribute(X.USER_NAME, null);
	response.sendRedirect("/login");
	return createModelAndView("/core/account/login.jsp", box);
  }
}
