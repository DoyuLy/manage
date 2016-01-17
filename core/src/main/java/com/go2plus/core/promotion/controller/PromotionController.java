package com.go2plus.core.promotion.controller;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONArray;
import com.go2plus.common.mvc.BaseVerificationController;
import com.go2plus.common.mvc.Box;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.service.PromotionService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.MyPromotion;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.sign.controller.SignInController;

/**
 * 
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 本类只用作《我的广告设置》
 * 
 * @author azq
 * @since 上午11:02:24
 */
@Controller
public class PromotionController extends BaseVerificationController {
  private final static Logger log    = LoggerFactory.getLogger(SignInController.class);
  private BufferedImage       imageS = null;
  @Autowired
  private PromotionService    promotionService;
  // 测试用户ID
  private int                 userId = 84;

  /**
   * 取消广告
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/promotion/cancelAd")
  @ResponseBody
  public void cancelAd(int id, HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    int updateNum = promotionService.updatePromotion(id);
    Promotion cancelPromotion = promotionService.getCancelPromotion(id);
    AdPosition adPosition = new AdPosition();
    adPosition.setStartTime(cancelPromotion.getStartTime());
    adPosition.setEndTime(cancelPromotion.getEndTime());
    adPosition.setPosX(cancelPromotion.getPosX());
    adPosition.setPosY(cancelPromotion.getPosY());
    if (cancelPromotion.getPosX().matches("^[u].*")) {
      adPosition.setType(2);
    }
    if (cancelPromotion.getPosX().matches("^[g].*")) {
      adPosition.setType(3);
    }
    if (cancelPromotion.getPosX().matches("^[e|f|x|y|a|fs|fw|fr|fr|fj].*")) {
      adPosition.setType(4);
    }
    if (cancelPromotion.getPosX().matches("^[c|d|i|j|k|o|p|q|r|s].*")) {
      adPosition.setType(1);
    }
    int addNum = promotionService.addAD(adPosition);
    if (updateNum == 1 && addNum == 1) {
      try {
        response.sendRedirect("/promotion/myPromotion");
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        response.sendRedirect("/promotion/myPromotion");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 弹出我的MODAL
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/promotion/mModalOut")
  @ResponseBody
  public ModelAndView mModalOut(String promotionId, HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    List<Product> myProduct = promotionService.getMyProduct(userId + "");
    box.setAttribute("product", myProduct);
    box.setAttribute("promotionId", promotionId);
    return createModelAndView("/core/promotion/myPromotionModal.jsp", box);
  }

  /**
   * 设置成功
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/promotion/setPromotion")
  public ModelAndView setPromotion(String promotionId, String productId, HttpServletRequest request, HttpServletResponse response) {
    int suc = promotionService.setPromotion(productId, promotionId);
    Box box = loadNewBox(request);
    if (suc == 1) {
      return createModelAndView("/core/promotion/setPromotionSuc.jsp", box);
    } else {
      return createModelAndView("/core/promotion/setPromotionSuc.jsp", box);
    }
  }

  /**
   * 我已抢到的广告列表
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/promotion/myPromotion")
  public ModelAndView myPromotion(HttpServletRequest request, HttpServletResponse response) {
    List<MyPromotion> myPromtion = promotionService.getMyPromotion(userId + "");
    Box box = loadNewBox(request);
    box.setAttribute("promotion", myPromtion);
    return createModelAndView("/core/promotion/myPromotion.jsp", box);
  }

  /*
   * 《以下不用 （广告列表，弹窗，图片验证码）与其独立类(OneHandPromotionController,UserCenterPromotionController...)图片验证区别,较优
   */
  /**
   * 读取promotion列表
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/promotion/promotion")
  public ModelAndView promotion(Integer id, HttpServletRequest request, HttpServletResponse response) {
    Jedis jedis = RedisUtil.getPool().getResource();
    Box box = loadNewBox(request);
    String redisString = jedis.get("promotion" + id);
    if (redisString != null) {
      List<Promotion> promotion = (List<Promotion>) JSONArray.parse(redisString);
      box.setAttribute("promotion", promotion);
    } else {
      List<Promotion> promotion = promotionService.getGrabFPs();
      String promotionJson = JSONArray.toJSONString(promotion);
      jedis.set("promotion" + id, promotionJson);
      box.setAttribute("promotion", promotion);
    }
    return createModelAndView("/core/promotion/promotion.jsp", box);
  }

  /**
   * 提交抢购
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/promotion/regPromotion")
  public ModelAndView regPromotion(HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    // String userId=box.$p("userId");
    // String id=box.$p("id");
    String userId = "12";
    String id = "21";
    int suc = promotionService.getPromotion(userId, id);
    if (suc == 1) {
      return createModelAndView("/core/promotion/promotionSuc.jsp", box);
    } else {
      return createModelAndView("/core/promotion/promotionSuc.jsp", box);
    }
  }

  /**
   * 生成验证码
   * 
   * @param request
   * @param response
   * @return
   */

  @RequestMapping("/promotion/identifyImg")
  @ResponseBody
  public void getIdentifyImg(HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    response.setHeader("Progma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    try {
      outputVerification(box, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 弹出MODAL
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/promotion/modalOut")
  @ResponseBody
  public ModelAndView modalOut(HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    return createModelAndView("/core/promotion/promotionModal.jsp", box);
  }
}
