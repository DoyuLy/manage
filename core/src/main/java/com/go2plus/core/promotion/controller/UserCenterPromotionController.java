package com.go2plus.core.promotion.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.go2plus.common.encrypt.MD5;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.promotion.service.UserCenterPromotionService;
import com.go2plus.core.promotion.service.ValidatorService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.HashPromotion;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * 用户中心——我的广告——供应商排行榜
 * 
 * @Description: TODO
 * @author lhc
 * @date 2015-12-3
 * 
 */
@Controller
@RequestMapping("/promotion/")
public class UserCenterPromotionController extends BaseController {

  private final static Logger        log      = LoggerFactory.getLogger(UserCenterPromotionController.class);

  @Autowired
  private UserCenterPromotionService userCenterService;
  @Autowired
  private ValidatorService           validatorService;
  private boolean                    useRedis = false;

  // 测试用户ID
  private int                        userId   = 84;

  /**
   * 用户中心广告管理
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/uclist")
  public ModelAndView uclist(HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    try {
      // 显示的开始日期
      Date startTime = getStartDate();
      // 显示可供订购的列表
      boolean isShow = true;
      // 获取商家信息
      Supplier supplier = userCenterService.getByUserId(userId);
      box.setAttribute("supplier", supplier);
      if (supplier.getMarketId() != 5) {
        box.setAttribute("msg", "对不起, 用户中心广告目前只面向国际商贸城高级认证厂家开放！");
        return createModelAndView("core/promotion/uclist.jsp", box);
      } else if (supplier.getCertifiedType() != 2) {
        box.setAttribute("msg", "对不起, 用户中心广告目前只面向国际商贸城高级认证厂家开放，请联系客服QQ 4006611603 开通高级认证！");
        return createModelAndView("core/promotion/uclist.jsp", box);
      }
      if (validatorService.isTop100Supplier(userId)) {
        isShow = false;
        box.setAttribute("reason", "对不起，您目前位于综合排名TOP100以内，不能订购本位置广告，把机会留给更需要的厂商吧！");
      }
      if (userCenterService.checkSPRule(startTime, userId) > 0) {
        isShow = false;
        box.setAttribute("reason", "恭喜你，您已订购成功同期开始的用户中心广告位或搜索结果广告位<br>请到“<a href=\"/manage/promotion/myfps\">我订购的广告</a>”中查看！");
      }
      if (isShow) {
        Integer totalFee = 300;
        double discount = 1;
        int num = 29;
        List<AdPosition> map = userCenterService.getUCsBy("2");
        ArrayList<HashPromotion> promotions = new ArrayList<>();
        if(map!=null){
          // 随机排序
          Collections.shuffle(map);
          int size = map.size() > 30 ? 30 : map.size();
          List<AdPosition> ad = map.subList(0, size);
  
          for (int i = 0; i <= num; i++) {
            Promotion promotion = new Promotion();
            promotion.setPosX(ad.get(i).getPosX());
            promotion.setStartTime(ad.get(i).getStartTime());
            promotion.setEndTime(ad.get(i).getEndTime());
            promotion.setTotalFee(totalFee);
            promotion.setUserId(userId);
            promotion.setDiscount(discount);
            promotions.add(new HashPromotion(promotion, getHash(promotion)));
          }
        }
        box.setAttribute("promotions", promotions);
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      log.error(e.getMessage());
    }
    return createModelAndView("core/promotion/uclist.jsp", box);
  }

  /**
   * 用户中心广告订购页
   * 
   * @param posX
   * @param startTime
   * @param totalFee
   * @param discount
   * @param hash
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/toOrderUc")
  public ModelAndView toOrderUc(String posX, String startTime, Integer totalFee, Double discount, String hash, HttpServletRequest request,
      HttpServletResponse response) {
    Box box = loadNewBox(request);
    try {

      // 黑名单检验
      if (validatorService.isOnBlackList(userId)) {
        box.setAttribute("msg", "亲，您有逾期广告费未结清，暂时无法使用广告功能，请联系客服处理！");
        return createModelAndView("core/promotion/order_uc.jsp", box);
      }

      Promotion promotion = new Promotion();
      promotion.setUserId(userId);
      promotion.setPosX(posX);
      promotion.setStartTime(validatorService.toDate(startTime));
      promotion.setTotalFee(totalFee);
      promotion.setDiscount(discount);
      // 获取商家信息
      Supplier supplier = userCenterService.getByUserId(userId);

      // 权限认证检验
      if (supplier.getMarketId() != 5) {
        box.setAttribute("msg", "对不起, 用户中心广告目前只面向国际商贸城高级认证厂家开放！");
        return createModelAndView("core/promotion/order_uc.jsp", box);
      } else if (supplier.getCertifiedType() != 2) {
        box.setAttribute("msg", "对不起, 用户中心广告目前只面向国际商贸城高级认证厂家开放，请联系客服QQ 4006611603 开通高级认证！");
        return createModelAndView("core/promotion/order_uc.jsp", box);
      }

      if (validatorService.disableFunc(userId)) {
        box.setAttribute("msg", "由于涉嫌违规，您订购用户中心广告的权利已被限制，详情请与客服联系");
        return createModelAndView("core/promotion/order_uc.jsp", box);
      }

      if (!validatorService.isPass(hash, getHash(promotion))) {
        box.setAttribute("msg", "对不起, 您的请求有误！");
        return createModelAndView("core/promotion/order_uc.jsp", box);
      }
      Thread.sleep(1);
      if (userCenterService.checkSPRule(promotion.getStartTime(), userId) > 0) {
        box.setAttribute("msg", "对不起，您本期已经订购了用户中心广告，把机会留点给别的商家吧！");
        return createModelAndView("core/promotion/order_uc.jsp", box);
      }
      String[] operators = { "-", "+" };
      int[] arr = new int[2];
      int rank = supplier.getSupplierRank().getRank();
      Random random = new Random();
      if (rank > 100 && rank < 200) {
        arr[0] = random.nextInt(11) + 30;
        arr[1] = random.nextInt(11) + 30;
      } else if (rank >= 200 && rank < 300) {
        arr[0] = random.nextInt(11) + 20;
        arr[1] = random.nextInt(11) + 20;
      } else if (rank >= 300 && rank < 500) {
        arr[0] = random.nextInt(11) + 10;
        arr[1] = random.nextInt(11) + 10;
      } else {
        arr[0] = random.nextInt(10) + 1;
        arr[1] = random.nextInt(10) + 1;
      }
      // 提升多次订购成功的厂家难度
      int num = 0;
      // 上周二搜索结果|用户中心
      int num1 = userCenterService.checkSPRule(getDateByTue(-1), userId);
      if (num1 > 0) {
        num += num1;
      }
      // 本周二搜索结果|用户中心
      int num2 = userCenterService.checkSPRule(getDateByTue(0), userId);
      if (num2 > 0) {
        num += num2;
      }
      // 下周二搜索结果|用户中心
      int num3 = userCenterService.checkSPRule(getDateByTue(1), userId);
      if (num3 > 0) {
        num += num3;
      }

      switch (num) {
      case 1:
        arr[0] = random.nextInt(71) + 30;
        arr[1] = random.nextInt(71) + 30;
        break;
      case 2:
        arr[0] = random.nextInt(201) + 100;
        arr[1] = random.nextInt(201) + 100;
        break;
      case 3:
        arr[0] = random.nextInt(501) + 300;
        arr[1] = random.nextInt(501) + 300;
        break;
      }
      String operator = operators[random.nextInt(2)];
      if (arr[0] < arr[1]) {
        operator = operators[1];
      }
      box.setAttribute("x", arr[0]);
      box.setAttribute("y", arr[1]);
      box.setAttribute("supplier", supplier);
      box.setAttribute("posX", posX);
      box.setAttribute("startTime", startTime);
      box.setAttribute("hash", hash);
      box.setAttribute("operator", operator);
      box.setAttribute("refer", "/promotion/uclist");
      box.setAttribute("totalFee", totalFee);
      box.setAttribute("discount", discount);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      log.error(e.getMessage());
    }
    return createModelAndView("core/promotion/order_uc.jsp", box);
  }

  /**
   * 订购用户中心广告位
   * 
   * @param hash
   * @param refer
   * @param x
   * @param y
   * @param operator
   * @param result
   * @param posX
   * @param startTime
   * @param totalFee
   * @param discount
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/order_uc", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject orderUc(String hash, String refer, int x, int y, String operator, int result, String posX, String startTime,
      Integer totalFee, Double discount, HttpServletRequest request, HttpServletResponse response) {
    JSONObject object = new JSONObject();
    object.put("success", false);

    try {
      // 黑名单检验
      if (validatorService.isOnBlackList(userId)) {
        object.put("msg", "亲，您有逾期广告费未结清，暂时无法使用广告功能，请联系客服处理！");
        return object;
      }

      Supplier supplier = null;
      if (useRedis) {
        supplier = userCenterService.getByUserIdFromRedis(userId);
      } else {
        supplier = userCenterService.getByUserId(userId);
      }

      Promotion promotion = new Promotion();
      promotion.setUserId(userId);
      promotion.setPosX(posX);
      promotion.setPosY(posX);
      promotion.setStartTime(validatorService.toDate(startTime));
      promotion.setEndTime(validatorService.addWeek(promotion.getStartTime(), 1));
      promotion.setTotalFee(totalFee);
      promotion.setDiscount(discount);
      promotion.setLink("http://" + supplier.getSite().getSubdomain() + ".go2.cn/");
      promotion.setTitle(supplier.getTitle().trim() + "[" + posX + "]");
      promotion.setComment("");
      promotion.setPayState(1);
      promotion.setState(1);
      promotion.setAddTime(new Date());
      promotion.setCreateTime(new Date());

      // 权限认证检验
      if (supplier.getMarketId() != 5) {
        object.put("msg", "对不起, 用户中心广告目前只面向国际商贸城高级认证厂家开放！");
        return object;

      } else if (supplier.getCertifiedType() != 2) {
        object.put("msg", "对不起, 用户中心广告目前只面向国际商贸城高级认证厂家开放，请联系客服QQ 4006611603 开通高级认证！");
        return object;
      }

      if (validatorService.disableFunc(userId)) {
        object.put("msg", "由于涉嫌违规，您订购用户中心广告的权利已被限制，详情请与客服联系");
        return object;
      }

      if (!validatorService.isPass(hash, getHash(promotion))) {
        object.put("msg", "对不起, 您的请求有误！");
        return object;
      }
      Thread.sleep(1);
      if (userCenterService.checkSPRule(promotion.getStartTime(), userId) > 0) {
        object.put("reason", "对不起，您本期已经订购了用户中心广告，把机会留点给别的商家吧！");
        return object;
      }

      if (StringUtils.isEmpty(refer)) {
        refer = "/promotion/uclist";
      }

      // 检测计算结果
      switch (operator) {
      case "+":
        if ((x + y) != result) {
          object.put("msg", "对不起, 您的计算结果有误，请重新输入");
          return object;
        }
        break;
      case "-":
        if ((x - y) != result) {
          object.put("msg", "对不起, 您的计算结果有误，请重新输入");
          return object;
        }
        break;
      case "x":
        if ((x * y) != result) {
          object.put("msg", "对不起, 您的计算结果有误，请重新输入");
          return object;
        }
        break;
      default:
        object.put("msg", "对不起, 您的请求有误，请从页面点开链接");
        return object;
      }

      if (!validatorService.isDate(startTime, "yyyy-MM-dd")) {
        object.put("msg", "对不起，您的请求有误，请从页面点开链接");
        return object;
      }

      if (!validatorService.isPosX(posX, "usercenter")) {
        object.put("msg", "对不起，您的请求有误，请从页面点开链接");
        return object;
      }

      if (validatorService.isAvaiableFP(posX, promotion.getStartTime())) {
        if (userCenterService.addFP(promotion) && userCenterService.delAD(posX, startTime, "2")) {
          object.put("success", true);
          object.put("msg", "恭喜您，用户中心广告位" + posX + "（开始时间：" + startTime + "）订购成功！");
          return object;
          // // 复核
          // if(userCenterService.getFP(promotion.getStartTime(), userId, posX)){
          // }else{
          // object.put("msg","对不起，您慢了一拍，该位置已被他人抢购走了！");
          // return object;
          // }
        } else {
          object.put("msg", "对不起，您慢了一拍，该位置已被他人抢购走了！");
          return object;
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      log.error(e.getMessage());
    }
    object.put("msg", "对不起，您的请求有误，请从页面点开链接");
    return object;
  }

  /**
   * 获取开始日期
   * 
   * @return
   */
  private Date getStartDate() {
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    // 如果是周一或周二则改为下一周
    if (day == 1 || day == 2) {
      calendar.add(Calendar.WEEK_OF_MONTH, 1);
    }
    return calendar.getTime();
  }

  private Date getDateByTue(int weekNum) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.WEEK_OF_MONTH, weekNum);
    calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
    return calendar.getTime();
  }

  private String getHash(Promotion promotion) throws Exception {
    // TODO Auto-generated method stub
    StringBuffer buffer = new StringBuffer();
    buffer.append(promotion.getPosX());
    buffer.append(MD5.md5Encode(promotion.getUserId() + promotion.getTotalFee() + ""));
    buffer.append(promotion.getDiscount() + validatorService.toDate(promotion.getStartTime()));
    return MD5.md5Encode(buffer.toString());
  }
}
