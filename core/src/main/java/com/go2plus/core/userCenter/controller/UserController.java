package com.go2plus.core.userCenter.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.go2plus.common.X;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.common.service.MessageService;
import com.go2plus.core.common.vo.FinalResultVo;
import com.go2plus.core.common.vo.Message;
import com.go2plus.core.common.vo.ResultVo;
import com.go2plus.core.product.service.ProductService;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.promotion.vo.Promotion;
import com.go2plus.core.userCenter.service.SupplierService;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.User;

@Controller
public class UserController extends BaseController {
  private final static Logger   log    = LoggerFactory.getLogger(UserController.class);

  @Resource
  private SupplierService       supplierService;

  @Resource
  private ProductService        productService;

  @Resource
  private MessageService        messageService;
  @Resource
  private UserService           userService;

  @RequestMapping("/userCenter/supplier")
  public ModelAndView supplierUserIndex(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.supplierUserIndex()");
    Box box = loadNewBox(request);
    String certifiedType = supplierService.getCertifiedType(1333);
    String supplierId = box.$cv(X.USER);
    box.setAttribute("certifiedType", certifiedType);
    box.setAttribute("subNav", "index");
    return createModelAndView("/userCenter/supplier/index.jsp", box);
  }

  
  // 厂家-我的资料-认证类型
  @RequestMapping("/userCenter/supplier/authenticationType")
  public ModelAndView authenticationType(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.authenticationType()");
    Box box = loadNewBox(request);
    box.setAttribute("subNav", "info");
    return createModelAndView("/userCenter/supplier/authenticationType.jsp", box);
  }

  

  // 厂家-我的消息-厂家公告
  @RequestMapping("/userCenter/supplier/myAnnounce")
  public ModelAndView myAnnounce(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.myAnnounce()");
    Box box = loadNewBox(request);
    String user = box.$cv("user");
    int userId = 0;
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }
    String content = box.$p("msg_notice");
    // 保存消息
    // 设置默认值
    Date create_time = new Date();
    String type = "corpnews";
    int weigth = 0;
    int state = 1;
    // 组装对象
    Message message = new Message();
    message.setUserId(userId);
    message.setContent(content);
    message.setCreateTime(create_time);
    message.setType(type);
    message.setWeight(weigth);
    message.setState(state);

    messageService.saveUserMessage(message);

    // 显示消息
    List<Message> messageList = messageService.showLastMessage(userId);
    // 区分厂家公告和操作日志
    List<Message> supplierAnnounceList = new ArrayList<>();
    Iterator<Message> outMessage = messageList.iterator();
    while (outMessage.hasNext()) {
      Message msg = outMessage.next();
      // 厂家消息
      if (msg.getType().equals("corpnews")) {
        supplierAnnounceList.add(msg);
      }
    }
    box.setAttribute("supplierAnnounceList", supplierAnnounceList);

    box.setAttribute("subNav", "msg");
    return createModelAndView("/userCenter/supplier/myAnnounce.jsp", box);
  }

  // 厂家-我的消息-操作日志
  @RequestMapping("/userCenter/supplier/myOperation")
  public ModelAndView myOperation(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.myOperation()");
    Box box = loadNewBox(request);

    // 显示最新消息
    String user = box.$cv("user");
    int userId = 0;
    if(!StringUtils.isEmpty(user)){
      userId = Integer.parseInt(user);
    }

    List<Message> messageList = messageService.showLastMessage(userId);
    List<Message> operationLogList = new ArrayList<>();
    Iterator<Message> message = messageList.iterator();
    while (message.hasNext()) {
      Message msg = message.next();
      // 厂家消息
      if (msg.getType().equals("corplog")) {
        operationLogList.add(msg);
      }
    }
    box.setAttribute("operationLogList", operationLogList);

    box.setAttribute("subNav", "msg");
    return createModelAndView("/userCenter/supplier/myOperation.jsp", box);
  }
  
  // 2B端
 
  /**
   * 获取用户广告中心
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/userCenter/seller")
  public ModelAndView getUCPromotions(HttpServletRequest request, HttpServletResponse response){
    log.debug("UserController.getUCPromotions()");
      Box box = loadNewBox(request);
      
      int pageSize = 30;
      int pageIndex = 1;
      int totalcount = 0;
      //int offset = (pageIndex - 1) * pageSize;

      //String sellerId = box.$cv(X.USER);
      
      List<Promotion> promotions = productService.getUCPromotions();
      totalcount = promotions == null ? 0 : promotions.size(); 

      ResultVo promotionResult = new ResultVo(totalcount, pageSize, pageIndex, "", "", promotions);
      //广告位
      FinalResultVo promotionVo = new FinalResultVo(true, promotionResult, "");
      
      //最新上架产品
      List<Product> recommends = productService.getRecommendList();
      totalcount = recommends == null ? 0 : recommends.size();
      ResultVo recommendResult = new ResultVo(totalcount, pageSize, pageIndex, "", "", recommends);
      //广告位
      FinalResultVo recommendVo = new FinalResultVo(true, recommendResult, "");
      
      String json = JSON.toJSONString(recommendVo);
      
      box.setAttribute("subNav", "seller");
      box.setAttribute("promotions", promotionVo);
      box.setAttribute("recommends", recommendVo);

      return createModelAndView("/userCenter/seller/index.jsp", box);
  }
  
  /**
   * 厂家-我的资料-修改密码
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = { "/userCenter/supplier/password", "/userCenter/seller/password" })
  public ModelAndView passwordForm(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.password()");
    Box box = loadNewBox(request);
    box.setAttribute("page", "password");
    String sellerId = box.$cv(X.USER);
    User u = new User();
    u.setId(Integer.parseInt(sellerId));
    User user = userService.findUser(u);
    user.setPassword("");
    box.setAttribute("userForm", user);
    box.setAttribute("subNav", "myInfo");

    if (user.getType().equals(0)) {
      box.setAttribute("subNav", "myInfo");
      return createModelAndView("/userCenter/seller/password.jsp", box);
    } else if (user.getType().equals(1)) {
      box.setAttribute("subNav", "info");
      return createModelAndView("/userCenter/supplier/password.jsp", box);
    } else {
      return null;
    }
  }

  /**
   * 厂家-我的资料-修改密码
   * 
   * @param request
   * @param response
   * @param user
   * @return
   * 
   * @author yuyanlin
   * @throws Exception
   */
  @RequestMapping(value = { "/userCenter/supplier/password", "/userCenter/seller/password" }, method = RequestMethod.POST)
  public ModelAndView passwordSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user)
      throws Exception {
    log.debug("UserController.password()");
    Box box = loadNewBox(request);
    String passwordMD5 = userService.convertStringToPassword(user.getPassword());
    //获取原密码并验证原密码是否正确
    String passOld = userService.convertStringToPassword(box.$p("oldpassword"));
    user.setPassword(passOld);
    if(userService.findUser(user)==null){
      //原密码错误 
      box.setAttribute("msg", "原密码错误");
    }else{

      user.setPassword(passwordMD5);

      userService.updateUserPassword(user);
      
      box.setAttribute("msg", "修改成功");
    }
    
    box.setAttribute("page", "password");
    user.setPassword("");
    box.setAttribute("userForm", user);
   
    User seller = new User();
    String sellerId = box.$cv(X.USER);
    seller.setId(Integer.parseInt(sellerId));
    User u = userService.findUser(seller);

    if (u.getType().equals(0)) {
      box.setAttribute("subNav", "info");
      return createModelAndView("/userCenter/seller/password.jsp", box);
    } else if (u.getType().equals(1)) {
      box.setAttribute("subNav", "info");
      return createModelAndView("/userCenter/supplier/password.jsp", box);
    } else {
      return null;
    }
  }

  /**
   * 厂家-我的资料-登记手机
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = { "/userCenter/supplier/mobile", "/userCenter/seller/mobile" })
  public ModelAndView mobileForm(HttpServletRequest request, HttpServletResponse response) {
    log.debug("UserController.mobileForm()");
    Box box = loadNewBox(request);
    box.setAttribute("page", "mobile");

    User seller = new User();
    String sellerId = box.$cv(X.USER);
    seller.setId(Integer.parseInt(sellerId));
    User user = userService.findUser(seller);
    box.setAttribute("userForm", user);

    if (user.getType().equals(0)) {
      box.setAttribute("subNav", "myInfo");
      return createModelAndView("/userCenter/seller/mobile.jsp", box);
    } else if (user.getType().equals(1)) {
      box.setAttribute("subNav", "info");
      return createModelAndView("/userCenter/supplier/mobile.jsp", box);
    } else {
      return null;
    }

  }

  /**
   * 厂家-我的资料-修改手机
   * 
   * @param request
   * @param response
   * @param user
   * @return
   * 
   * @author yuyanlin
   */
  @RequestMapping(value = { "/userCenter/supplier/mobile", "/userCenter/seller/mobile" }, method = RequestMethod.POST)
  public ModelAndView mobileSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
    log.debug("UserController.mobileSubmit()");
    Box box = loadNewBox(request);
    userService.updateUserMobile(user);
    User seller = new User();
    String sellerId = box.$cv(X.USER);
    seller.setId(Integer.parseInt(sellerId));
    User u = userService.findUser(seller);
    box.setAttribute("userForm", u);

    if (u.getType().equals(0)) {
      box.setAttribute("subNav", "info");
      return createModelAndView("/userCenter/seller/mobile.jsp", box);
    } else if (u.getType().equals(1)) {
      box.setAttribute("subNav", "info");
      return createModelAndView("/userCenter/supplier/mobile.jsp", box);
    } else {
      return null;
    }

  }
  
  
  
}
