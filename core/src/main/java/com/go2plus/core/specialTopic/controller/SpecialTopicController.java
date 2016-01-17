package com.go2plus.core.specialTopic.controller;

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

import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.portal.controller.PortalController;
import com.go2plus.core.specialTopic.service.SpecialTopicService;
import com.go2plus.core.specialTopic.vo.SpecialNew;
import com.go2plus.core.specialTopic.vo.SpecialTopic;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 专题Controller
 * 
 * @author gaofeng
 * @since 2015-10-20
 */
@Controller
public class SpecialTopicController extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(PortalController.class);
  @Resource
  private SpecialTopicService specialTopicService;

  /**
   * 主题选货
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/specialTopic/themeProduct")
  public ModelAndView themeProduct(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SpecialTopicController.themeProduct()");
    Box box = loadNewBox(request);
    List<SpecialTopic> specialTopicList = specialTopicService.querySpecial();
    box.setAttribute("specialTopicList", specialTopicList);

    return createModelAndView("/specialTopic/themeProduct.jsp", box);
  }

  /**
   * 活动主题详情页
   */

  @RequestMapping(value = "/specialTopic/display/{id}")
  public ModelAndView topicDisplay(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) {
    log.debug("SpecialTopicController.grandCeremony()");
    Box box = loadNewBox(request);
    StringBuffer url = new StringBuffer("/specialTopic/specialPage/page_").append(id).append(".jsp");
    return createModelAndView(url.toString(), box);
  }

  /**
   * 1212盛典
   * 
   * @param request
   * @param response
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/specialTopic/grandCeremony")
  public ModelAndView grandCeremony(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SpecialTopicController.grandCeremony()");
    Box box = loadNewBox(request);
    StringBuffer url = new StringBuffer("/specialTopic/specialPage/page_50.jsp");
    return createModelAndView(url.toString(), box);
  }
}
