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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.go2plus.common.X;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.User;

@Controller
public class UserController extends BaseController {
  private final static Logger   log    = LoggerFactory.getLogger(UserController.class);

  @Resource
  private UserService           userService;

  
  /**
   * 厂家-我的资料-修改密码
   * 
   * @param request
   * @param response
   * @return
   * 
   * @author duyu
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
   * @author duyu
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
}
