package com.go2plus.core.backgroundManage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

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

import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.backgroundManage.service.NavigationBarService;
import com.go2plus.core.backgroundManage.vo.ConsoleAd;
import com.go2plus.core.backgroundManage.vo.NavigationBar;
import com.go2plus.core.promotion.service.ValidatorService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.OrderedFPs;
import com.go2plus.core.promotion.vo.Promotion;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 导航条后台配置Controller
 * 
 * @author gaozhenghua
 * @since 2015-11-18
 */
@Controller
public class navigationBarController extends BaseController {
  private final static Logger  log = LoggerFactory.getLogger(navigationBarController.class);
  @Resource
  private NavigationBarService navigationBarService;
  @Autowired
  private ValidatorService     validatorService;

  /**
   * 导航条配置后台管理
   * 
   * 显示导航条列表
   * 
   * @param request
   * @param response
   * @return
   */

  @RequestMapping(value = "/manage/navBar")
  public ModelAndView navigationBar(HttpServletRequest request, HttpServletResponse response) {
    log.debug("navigationBarController.addNavigationBar()");
    Box box = loadNewBox(request);
    NavigationBar serachNavigation = new NavigationBar();
    List<NavigationBar> navigationBarList = navigationBarService.selectNavigationBar(serachNavigation);
    box.setAttribute("navigationBarList", navigationBarList);
    return createModelAndView("/backgroundManage/navigationBar.jsp", box);

  }

  /**
   * 导航条配置后台管理
   * 
   * 添加导航条
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/manage/addNavBar")
  public ModelAndView addNavigationBar(HttpServletRequest request, HttpServletResponse response) {
    log.debug("navigationBarController.addNavigationBar()");
    Box box = loadNewBox(request);
    // 显示页面
    return createModelAndView("/backgroundManage/addNavigationBar.jsp", box);

  }

  /**
   * 导航条配置后台管理 保存配置信息
   * 
   * @param request
   * @param response
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/manage/saveNavBar", method = RequestMethod.POST)
  public void saveNavigationBar(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("navigationBarController.saveNavigationBar()");

    Box box = loadNewBox(request);

    // 解析参数
    String area = box.$p("area");
    String navigationSubdomain = box.$p("navigationSubdomain");
    String navigationName = box.$p("navigationName");
    String navigationWeights = box.$p("navigationWeights");
    String content = box.$p("content");

    // 组装对象
    NavigationBar navigationBar = new NavigationBar();
    navigationBar.setArea(area);
    navigationBar.setNavigationSubdomain(navigationSubdomain);
    navigationBar.setNavigationName(navigationName);
    navigationBar.setNavigationWeights(Integer.parseInt(navigationWeights));
    navigationBar.setContent(content);
    navigationBar.setState(1);

    int rows = navigationBarService.saveNavigationBar(navigationBar);
    box.setAttribute("rows", rows);
    response.sendRedirect("/manage/navBar");
  }

  /**
   * 导航条配置后台管理
   * 
   * 删除导航条
   * 
   * @param request
   * @param response
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/manage/delNavBar/{id}")
  @ResponseBody()
  public String deleteNavigationBar(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("navigationBarController.deleteNavigationBar()");

    int rowNums = navigationBarService.deleteNavigationBar(Integer.parseInt(id));
    // response.sendRedirect("/backgroundManage/navigationBar");
    return Integer.toString(rowNums);
  }

  /**
   * 导航条配置后台管理
   * 
   * @param request
   * @param response
   * @return
   * @throws IOException
   */

  @RequestMapping(value = "/manage/updateNavBar/", method = RequestMethod.POST)
  @ResponseBody()
  public String updateNavigationBar(HttpServletRequest request, HttpServletResponse response) throws IOException {
    log.debug("navigationBarController.updateNavigationBar()");
    Box box = loadNewBox(request);
    // 解析参数
    String id = box.$p("id");
    String area = box.$p("area");
    String subdomain = box.$p("subdomain");
    String navName = box.$p("name");
    String weights = box.$p("weights");

    // 组装对象
    NavigationBar navigationBar = new NavigationBar();

    navigationBar.setId(Integer.parseInt(id));
    navigationBar.setArea(area);
    navigationBar.setNavigationSubdomain(subdomain);
    navigationBar.setNavigationName(navName);
    navigationBar.setNavigationWeights(Integer.parseInt(weights));

    int rows = navigationBarService.updateNavigationBar(navigationBar);
    return Integer.toString(rows);
  }

  /**
   * 广告生成选择器
   * 
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/manage/goAd")
  public ModelAndView goAd(HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    return createModelAndView("/backgroundManage/consoleAdTimeBar.jsp", box);
  }

  @RequestMapping(value = "/manage/consoleAd")
  public ModelAndView consoleAd(String startTime, String endTime, int type, HttpServletRequest request, HttpServletResponse response) {
    log.debug("navigationBarController.consoleAd()");
    Box box = loadNewBox(request);
    Date date = null;
    Date date2 = null;
    // 后台记录表插入
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      date = sdf.parse(startTime);
      date2 = sdf.parse(endTime);
    } catch (Exception e) {
      // TODO: handle exception
    }
    ConsoleAd consoleAd = new ConsoleAd();
    consoleAd.setStartTime(date);
    consoleAd.setEndTime(date2);
    consoleAd.setType(type);
    int saveConsoleAd = navigationBarService.saveConsoleAd(consoleAd);
    // 生成广告位表数据
    // 读取配置文件
    navigationBarController test = new navigationBarController();
    Properties prop = new Properties();
    InputStream in = test.getClass().getResourceAsStream("/ad.properties");
    try {
      prop.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      // 显示的开始日期
      Date startDate = getStartDate();
      // 本周二日期
      Date currentTuesOri = getCurrentTues();
      // 当前日期
      Date nowDate = getNowDate();
      // 显示可供订购的列表
      boolean isShow = true;
      // 删除已有类型广告
      navigationBarService.delAD(type + "");
      // 批操作合集
      ArrayList<AdPosition> batchMap = new ArrayList<AdPosition>();
      if (isShow) {
        boolean isOpen = true;
        int coupon = 0;
        String FP_STRING = "";
        String matches = "";
        // 一手货源
        if (type == 1) {
          FP_STRING = prop.getProperty("FP_STRING1");
          matches = prop.getProperty("matches1");
          // 按月份获取推荐位广告
          OrderedFPs fPs = navigationBarService.getOrderedFPs(FP_STRING);
          // 最近删除的广告
          List<String> recentDeletedFPs = navigationBarService.getDeletedFPs(7200);
          // 位置最早的结束时间
          TreeMap<String, Date> endTimeData = fPs.getData();
          // 位置被占用
          TreeMap<String, List<Promotion>> occu = fPs.getOccu();
          for (String key : endTimeData.keySet()) {
            // 获取可用的产品推荐位广告
            List<Promotion> list = navigationBarService.getAvaiableFPs(date2, endTimeData.get(key), occu.get(key));
            if (list != null) {
              for (Promotion promotion : list) {
                String str = key + "_" + validatorService.toDate(promotion.getStartTime());
                if (!validatorService.isSet(recentDeletedFPs, str) && !key.matches(matches)) {
                  if (!isOpen) {
                    promotion.setCoupon(coupon);
                  }
                  AdPosition adPositon = new AdPosition();
                  adPositon.setPosX(key);
                  adPositon.setType(type);
                  adPositon.setStartTime(promotion.getStartTime());
                  adPositon.setEndTime(validatorService.addWeek(promotion.getStartTime(), 1));
                  batchMap.add(adPositon);
                }
              }
            }
          }
        }
        // 用户中心
        if (type == 2) {
          FP_STRING = prop.getProperty("FP_STRING2");
          // 判断是否为周一和周二
          Boolean dayB = ((validatorService.getWeek7(nowDate) != 2) && (validatorService.getWeek7(nowDate) != 3));
          TreeMap<String, Promotion> orderedUCsBy = null;
          if (dayB) {
            orderedUCsBy = navigationBarService.getOrderedUCsBy(currentTuesOri);
            for (int i = 1; i <= 30; i++) {
              String pos = "u" + i;
              if (!validatorService.isSet(orderedUCsBy, pos)) {
                AdPosition adPositon = new AdPosition();
                adPositon.setPosX(pos);
                adPositon.setType(type);
                adPositon.setStartTime(currentTuesOri);
                adPositon.setEndTime(validatorService.addWeek(currentTuesOri, 1));
                batchMap.add(adPositon);
              }
            }
          } else {
            Date addWeek = validatorService.addWeek7(currentTuesOri, 1);
            orderedUCsBy = navigationBarService.getOrderedUCsBy(addWeek);
            for (int i = 1; i <= 30; i++) {
              String pos = "u" + i;
              if (!validatorService.isSet(orderedUCsBy, pos)) {
                AdPosition adPositon = new AdPosition();
                adPositon.setPosX(pos);
                adPositon.setType(type);
                adPositon.setStartTime(addWeek);
                adPositon.setEndTime(validatorService.addWeek(addWeek, 1));
                batchMap.add(adPositon);
              }
            }
          }
        }
        // 搜索结果页
        if (type == 3) {
          FP_STRING = prop.getProperty("FP_STRING3");
          // 判断是否为周一和周二
          Boolean dayB = ((validatorService.getWeek7(nowDate) != 2) && (validatorService.getWeek7(nowDate) != 3));
          if (dayB) {
            Date addWeek = validatorService.addWeek7(currentTuesOri, 2);
            Date addWeek2 = validatorService.addWeek7(currentTuesOri, 1);
            TreeMap<String, Promotion> orderedUCsBy = navigationBarService.getOrderedUCsBy(addWeek);
            for (int i = 1; i <= 36; i++) {
              String pos = "g" + i;
              if (!validatorService.isSet(orderedUCsBy, pos)) {
                AdPosition adPositon = new AdPosition();
                adPositon.setPosX(pos);
                adPositon.setType(type);
                adPositon.setStartTime(addWeek);
                adPositon.setEndTime(validatorService.addWeek(addWeek, 1));
                batchMap.add(adPositon);
              }
              TreeMap<String, Promotion> subOrderedUCsBy = navigationBarService.getOrderedUCsBy(addWeek2);
              if (!validatorService.isSet(subOrderedUCsBy, pos)) {
                AdPosition adPositon = new AdPosition();
                adPositon.setPosX(pos);
                adPositon.setType(type);
                adPositon.setStartTime(addWeek2);
                adPositon.setEndTime(validatorService.addWeek(addWeek2, 1));
                batchMap.add(adPositon);
              }
            }
          } else {
            Date addWeek = validatorService.addWeek7(currentTuesOri, 2);
            TreeMap<String, Promotion> orderedUCsBy = navigationBarService.getOrderedUCsBy(addWeek);
            for (int i = 1; i <= 36; i++) {
              String pos = "g" + i;
              if (!validatorService.isSet(orderedUCsBy, pos)) {
                AdPosition adPositon = new AdPosition();
                adPositon.setPosX(pos);
                adPositon.setType(type);
                adPositon.setStartTime(addWeek);
                adPositon.setEndTime(validatorService.addWeek(addWeek, 1));
                batchMap.add(adPositon);
              }
            }
          }
        }
        // 市场商家
        if (type == 4) {
          TreeMap<String, Date> orderedMRsBy = navigationBarService.getOrderedMRsBy();
          for (String d : orderedMRsBy.keySet()) {
            if (orderedMRsBy.get(d).after(validatorService.addWeek(startDate, 10))) {
              continue;
            }
            if (orderedMRsBy.get(d).before(validatorService.addDay(startDate, 1))) {
              orderedMRsBy.put(d, validatorService.addDay(startDate, 1));
            }
            AdPosition adPositon = new AdPosition();
            adPositon.setPosX(d);
            adPositon.setType(type);
            adPositon.setStartTime(orderedMRsBy.get(d));
            adPositon.setEndTime(validatorService.addWeek(orderedMRsBy.get(d), 1));
            batchMap.add(adPositon);
          }
        }
        if(batchMap.size() != 0){
          navigationBarService.addAD(batchMap);
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      log.error(e.getMessage());
    }
    return createModelAndView("/backgroundManage/consoleAdTimeBar.jsp", box);
  }

  /**
   * 获取开始日期 市场商家用
   * 
   * @return
   */
  private Date getStartDate() {
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    // 如果是周一或周二则改为下一周
    if (day == 2) {
      calendar.add(Calendar.DAY_OF_YEAR, 7);
    }
    if (day == 3) {
      calendar.add(Calendar.DAY_OF_YEAR, 6);
    }
    return calendar.getTime();
  }

  // 获取当前时间 用户中心，搜索结果页用
  private Date getNowDate() {
    Calendar calendar = Calendar.getInstance();
    return calendar.getTime();
  }

  // 获得本周日期与星期二的相差天数
  private int getTuesPlus() {
    Calendar cd = Calendar.getInstance();
    int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
    if (dayOfWeek == 1) {
      return -6;
    } else {
      return 3 - dayOfWeek;
    }
  }

  // 获得本周星期二的日期
  private Date getCurrentTues() {
    int tuesPlus = this.getTuesPlus();
    GregorianCalendar currentDate = new GregorianCalendar();
    currentDate.add(GregorianCalendar.DATE, tuesPlus);
    Date tues = currentDate.getTime();
    Calendar c = Calendar.getInstance();
    c.setTime(tues);
    return c.getTime();
  }
}
