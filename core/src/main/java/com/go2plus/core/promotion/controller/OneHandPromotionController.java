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

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import com.alibaba.fastjson.JSONObject;
import com.go2plus.common.encrypt.MD5;
import com.go2plus.common.json.Json;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.common.redis.RedisUtil;
import com.go2plus.core.promotion.service.OneHandPromotionService;
import com.go2plus.core.promotion.service.ValidatorService;
import com.go2plus.core.promotion.vo.AdPosition;
import com.go2plus.core.promotion.vo.HashPromotion;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * 用户中心——我的广告——一手货源广告
 * 
 * @Description: TODO
 * @author lhc
 * @date 2015-12-3
 * 
 */
@Controller
@RequestMapping("/promotion/")
public class OneHandPromotionController extends BaseController {

  private final static Logger     log      = LoggerFactory.getLogger(OneHandPromotionController.class);

  @Autowired
  private OneHandPromotionService oneHandService;

  @Autowired
  private ValidatorService        validatorService;

  private boolean                 useRedis = false;

  // 测试用户ID
  private int                     userId   = 84;

  /**
   * 个人公告订购中心——一手货源广告
   * 
   * @param request
   * @param response
   * @return
   */
  @SuppressWarnings("unused")
  @RequestMapping("/index")
  public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    try {

      // # 防刷新开始
      // $wait = $this->input->get('wait');
      // if ($wait) {
      // $user['pt'] = 1;
      // $this->cession->set_userdata($user, 'user');
      // header('Location: /manage/promotion/index');
      // exit;
      // }
      //
      // $pt = $this->cession->userdata('pt', 'user');
      // $user['pt'] = (!$pt) ? 1 : $pt + 1;
      //
      // if ($pt > 0 && $pt % 50 == 0) load_page('对不起',
      // '您的浏览器可能存在问题导致页面刷新异常，请更换浏览器或稍后再试！',
      // '/manage/promotion/index?wait=1', 5);
      // $this->cession->set_userdata($user, 'user');
      // # 防刷新结束

      Supplier supplier = null;
      if (useRedis) {
        supplier = oneHandService.getByUserIdFromRedis(userId);
      } else {
        supplier = oneHandService.getByUserId(userId);
      }
      box.setAttribute("supplier", supplier);
      boolean isOpen = true;
      int coupon = 0; // 优惠券

      boolean hasPermission = false;
      // 国际商贸城认证级别以上商家有权限
      if (supplier.getMarketId() == 5 && supplier.getCertifiedType() > 0) {
        hasPermission = true;
      }
      // 找到记录才提示该信息
      if (supplier != null && !hasPermission) {
        box.setAttribute("msg", "对不起，您无法使用自助广告订购系统。<BR>目前仅国际商贸城认证商家支持使用该功能，如需开通认证请联系网站客服QQ 4006611603！");
        return createModelAndView("core/promotion/index.jsp", box);
      } else if (supplier == null) {
        box.setAttribute("msg", "一瞬间，太多人涌进来，请稍后刷新再试");
        return createModelAndView("core/promotion/index.jsp", box);
      }

        if (useRedis) {
          List<Promotion> promotions = new ArrayList<>();
          // 随机排序
          Collections.shuffle(promotions);
          int size = promotions.size() > 60 ? 60 : promotions.size();
          promotions = promotions.subList(0, size);
          box.setAttribute("promotions", promotions);
        } else {
          double discount = 1;
          int num = 29;
          // 显示的开始日期
          Date startTime = getStartDate();
          // 显示可供订购的列表
          boolean isShow = true;
          List<AdPosition> map = oneHandService.getOnsBy("1");
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
    return createModelAndView("core/promotion/index.jsp", box);
  }

  /**
   * 到一手货源广告订购页面
   * 
   * @param posX
   * @param startTime
   * @param hash
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/toOrder")
  public ModelAndView toOrder(String posX, String startTime, String hash, HttpServletRequest request, HttpServletResponse response) {
    Box box = loadNewBox(request);
    try {
      int totalFee = 500;
      double discount = 1;
      Promotion promotion = new Promotion();
      promotion.setUserId(userId);
      promotion.setPosX(posX);
      promotion.setStartTime(validatorService.toDate(startTime));
      promotion.setTotalFee(totalFee);
      promotion.setDiscount(discount);
      // 黑名单检验
      if (validatorService.isOnBlackList(userId)) {
        box.setAttribute("msg", "由于涉嫌违规，您订购一手货源广告的权利已被限制，详情请与客服联系");
        return createModelAndView("core/promotion/order.jsp", box);
      }
      if (!validatorService.isPass(hash, getHash(promotion))) {
        box.setAttribute("msg", "对不起, 您的请求有误！");
        return createModelAndView("core/promotion/order.jsp", box);
      }

      boolean rs = false;
      if (useRedis) {
        rs = oneHandService.checkFPRuleFromRedis(posX, startTime, userId);
      } else {
        rs = oneHandService.checkFPRule(posX, validatorService.toDate(startTime), userId);
      }

      if (!rs) {
        box.setAttribute("msg", "由于同一时间你已订购 2 个广告，或本次订购将导致连续广告时间超过 10 天，故本次订购失败。");
        return createModelAndView("core/promotion/order.jsp", box);
      }

      String[] operators = { "-", "+" };
      Integer count = null;

      if (useRedis) {
        count = oneHandService.getFPsByUserIdFromRedis(userId, validatorService.toDate("2015-06-01"),
            validatorService.toDate("2016-01-01"), null);
      } else {
        count = oneHandService.getFPsByUserId(userId, validatorService.toDate("2015-06-01"), validatorService.toDate("2016-01-01"), null);
      }

      int[] arr = new int[2];
      Random random = new Random();
      switch (count) {
      case 0:
        arr[0] = random.nextInt(21) + 10;
        arr[1] = random.nextInt(21) + 10;
        break;
      case 1:
        arr[0] = random.nextInt(41) + 30;
        arr[1] = random.nextInt(21) + 10;
        break;
      case 2:
        arr[0] = random.nextInt(401) + 100;
        arr[1] = random.nextInt(401) + 100;
        break;
      case 3:
        arr[0] = random.nextInt(2001) + 1000;
        arr[1] = random.nextInt(2001) + 1000;
        break;
      default:
        arr[0] = random.nextInt(20001) + 10000;
        arr[1] = random.nextInt(20001) + 10000;
        break;
      }
      String operator = operators[random.nextInt(2)];
      if (arr[0] < arr[1]) {
        operator = operators[1];
      }
      if ((arr[0] - arr[1]) <= 10 && operator.equals("-")) {
        operator = operators[1];
      }

      box.setAttribute("x", arr[0]);
      box.setAttribute("y", arr[1]);
      box.setAttribute("posX", posX);
      box.setAttribute("startTime", startTime);
      // box.setAttribute("hash", hash);
      box.setAttribute("operator", operator);
      box.setAttribute("refer", "/promotion/index");
      box.setAttribute("totalFee", totalFee);
      box.setAttribute("discount", discount);

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      log.error(e.getMessage());
    }
    return createModelAndView("core/promotion/order.jsp", box);
  }

  @RequestMapping(value = "/order", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject order(String hash, String refer, int x, int y, String operator, int result, String posX, String startTime,
      Integer totalFee, Double discount, HttpServletRequest request, HttpServletResponse response) {
    JSONObject object = new JSONObject();
    object.put("success", false);
    try {
      Supplier supplier = oneHandService.getByUserId(userId);

      Promotion promotion = new Promotion();
      promotion.setUserId(userId);
      promotion.setPosX(posX);
      promotion.setPosY(posX);
      promotion.setStartTime(validatorService.toDate(startTime));
      promotion.setEndTime(validatorService.addWeek(validatorService.toDate(startTime), 1));
      promotion.setTotalFee(totalFee);
      promotion.setDiscount(discount);
      promotion.setLink("http://" + supplier.getSite().getSubdomain() + ".go2.cn/");
      promotion.setTitle(supplier.getTitle().trim() + "[" + posX + "]");
      promotion.setComment("");
      promotion.setPayState(1);
      promotion.setState(1);
      promotion.setAddTime(new Date());
      promotion.setCreateTime(new Date());

      if (StringUtils.isEmpty(refer)) {
        refer = "/promotion/";
      }

      // 黑名单检验
      if (validatorService.isOnBlackList(userId)) {
        object.put("msg", "由于涉嫌违规，您订购一手货源广告的权利已被限制，详情请与客服联系");
        return object;
      }

      // if (!validatorService.isPass(hash, getHash(promotion))) {
      // object.put("msg", "对不起, 您的请求有误！");
      // return object;
      // }

      if (!validatorService.isDate(startTime, "yyyy-MM-dd")) {
        object.put("msg", "对不起，您的请求有误，请从页面点开链接");
        return object;
      }
      if (!validatorService.isPosX(posX, null)) {
        object.put("msg", "对不起，您的请求有误，请从页面点开链接");
        return object;
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

      // 黑名单检验
      if (validatorService.isOnBlackList(userId)) {
        object.put("msg", "由于涉嫌违规，您订购一手货源广告的权利已被限制，详情请与客服联系");
        return object;
      }

      if (useRedis) {
        Promotion promotion2 = oneHandService.isAvaiableFPFromRedis(posX, startTime);
        if (promotion2 != null) {
          String fieldName = promotion2.getPosX() + "_" + validatorService.toDate(promotion2.getStartTime());
          Jedis redis = RedisUtil.getPool().getResource();
          // 从avaiableFPs移除 ，添加到锁队列lockAvaiableFPs中(存储已经订购的广告位)
          Pipeline pipeline = redis.pipelined();
          pipeline.hset("lockAvaiableFPs", fieldName, Json.toJson(promotion2));
          pipeline.hdel("avaiableFPs", fieldName);
          pipeline.exec();
          if (oneHandService.addFP(promotion) && oneHandService.delAD(posX, startTime, "1")) {
            // 成功过后，不成功恢复到avaiableFPs中，并在promotions增加一条记录
            oneHandService.addFpFromRedis(promotion);
            object.put("success", true);
            // object.put("msg",
            // "<div>正在提交处理，请勿关闭本窗口……</div><script type=\"text/javascript\">function notify() { var str=\"恭喜，广告位 "+posX+"（开始时间："+startTime+
            // "）订购成功！\";document.write(str);} setTimeout(\"notify()\", 3000);</script>");
            object.put("msg", "恭喜您，用户中心广告位" + posX + "（开始时间：" + startTime + "）订购成功！");
            return object;
          } else {
            object.put("msg", "对不起，您慢了一拍，该位置已被他人抢购走了！");
            return object;
          }
        } else {
          object.put("msg", "对不起，您慢了一拍，该位置已被他人抢购走了！");
          return object;
        }
      } else {

        if (validatorService.isAvaiableFP(posX, promotion.getStartTime())) {
          boolean flag = oneHandService.addFP(promotion);
          Thread.sleep(1);
          if (flag) {
            object.put("success", true);
            object.put("msg", "<div>正在提交处理，请勿关闭本窗口……</div><script type=\"text/javascript\">function notify() { var str=\"恭喜，广告位 " + posX
                + "（开始时间：" + startTime + "）订购成功！\";document.write(str);} setTimeout(\"notify()\", 3000);</script>");
            return object;
          } else {
            object.put("msg", "对不起，您慢了一拍，该位置已被他人抢购走了！");
            return object;
          }
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

  private String getHash(Promotion promotion) throws Exception {
    StringBuffer buffer = new StringBuffer();
    buffer.append(promotion.getPosX());
    buffer.append(MD5.md5Encode(promotion.getUserId() + ""));
    buffer.append(validatorService.toDate(promotion.getStartTime()));
    return MD5.md5Encode(buffer.toString());
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
}
