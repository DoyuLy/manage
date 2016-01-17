package com.go2plus.core.sign.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.go2plus.common.X;
import com.go2plus.common.encrypt.AES;
import com.go2plus.common.encrypt.MD5;
import com.go2plus.common.http.HttpAgent;
import com.go2plus.common.mail.SendEMail;
import com.go2plus.common.mvc.BaseVerificationController;
import com.go2plus.common.mvc.Box;
import com.go2plus.common.page.HtmlParser;
import com.go2plus.core.product.vo.Site;
import com.go2plus.core.userCenter.dao.UserDao;
import com.go2plus.core.userCenter.service.SupplierService;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.Daifa;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.SupplierStats;
import com.go2plus.core.userCenter.vo.User;
import com.go2plus.core.userCenter.vo.UserMeta;
import com.go2plus.core.userCenter.vo.supplierMeta;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 登录Controller, 处理用户登录相关的请求
 * 
 * @author gaofeng
 * @since 2015-10-20
 */
@Controller
public class SignInController extends BaseVerificationController {
  private final static Logger log = LoggerFactory.getLogger(SignInController.class);

  @Resource
  private UserService         userService;

  /**
   * 跳转到登录页面
   * 
   * @param request
   * @param response
   * @return
   */
  /*
   * @RequestMapping("/signIn/index") public ModelAndView index(HttpServletRequest request, HttpServletResponse response) { Box box =
   * loadNewBox(request); return createModelAndView("/signIn/index.jsp", box); }
   */

  /**
   * 登录
   * 
   * @param request
   * @param response
   * @return
   */
  /*
   * @RequestMapping("/signIn") public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) { Box box =
   * loadNewBox(request); Cookie c = new Cookie(X.USER, box.$p("userId")); c.setPath("/"); c.setMaxAge(-1); box.getCookie().put(X.USER, c);
   * Cookie userType = new Cookie(X.USER_TYPE, box.$p("userType")); userType.setPath(X.WEB_ROOT); userType.setMaxAge(-1);
   * box.getCookie().put(X.USER_TYPE, userType); writeCookies(box, response); return createModelAndView("/signIn/jumpBack.jsp", box); }
   */

  /**
   * 验证码
   * 
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/login/verify", method = RequestMethod.GET)
  public void getVerifyCodeImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Box box = loadNewBox(request);
    response.setHeader("Progma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");

    outputVerification(box, response);
  }

  /**
   * 登录接口
   * 
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping(value="/login")
  public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
      Box box = loadNewBox(request);
      if(!"POST".equalsIgnoreCase(request.getMethod())){
        return createModelAndView("/core/account/login.jsp", box);
      }
      String userName = box.$p("username");
      String passWord = X.USER_PASS_PREFIX + box.$p("password");
      String verifyCode = box.$p("verifycode");
      userName = (userName == null || userName.isEmpty()) ? "" : userName.trim();
      passWord = (passWord == null || passWord.isEmpty()) ? "" : MD5.md5Encode(passWord.trim());
      verifyCode = (verifyCode == null || verifyCode.isEmpty()) ? "" : verifyCode.trim().toLowerCase();

      // TODO 预定义错误码 enum
      int errorCode = 0; // 0:正常;1：用户名账号或密码不能为空;2:没有此用户;3:密码错误;4:验证码过期;5.验证码错误;6:非法登录
      boolean f = true;
      if (userName.isEmpty() || userName.isEmpty()) {
        errorCode = 1;
        box.setAttribute("errorCode", errorCode);
        return createModelAndView("/core/account/login.jsp", box);
      } else {
        User u = new User();
        u.setUsername(userName);
        u.setPassword(passWord);
        User user = userService.findUser(u);
        if (user == null) {
          errorCode = 2;
          box.setAttribute("errorCode", errorCode);
          return createModelAndView("/core/account/login.jsp", box);
        } else {
          // TODO 验证码过期验证
          // Cookie[] cookies = request.getCookies();
          DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

          Cookie cookie = box.$c(X.ENCRYPTED + X.TIME);
          long diff = 1000000;
          try {
            diff = format.parse(X.nowString()).getTime() - format.parse(cookie.getValue()).getTime();
          } catch (Exception e) {
            e.printStackTrace();
          }

          if (diff / 1000 > Integer.parseInt(X.getTimeout())) {
            errorCode = 4;
            box.setAttribute("errorCode", errorCode);
            return createModelAndView("/core/account/login.jsp", box);
          }

          if (!box.$c(X.ENCRYPTED + X.KEY).getValue().equalsIgnoreCase(verifyCode)) {
            errorCode = 5;
            box.setAttribute("errorCode", errorCode);
            return createModelAndView("/core/account/login.jsp", box);
          }

          /*
           * for(Cookie c : cookies){ if(c.getName().equalsIgnoreCase(X.ENCRYPTED+X.TIME)){ long diff = format.parse(
           * X.nowString()).getTime() - format.parse(c.getValue()).getTime(); if(diff > 600){ errorCode = 4; box.setAttribute("errorCode",
           * errorCode); return createModelAndView("/core/account/login.jsp", box); } } }
           */

          // TODO HASH签名
          /*
           * String hash = MD5.md5Encode(MD5.md5Encode(verifyCode.toLowerCase()+X.USER_PASS_PREFIX)+X.USER_PASS_PREFIX+cookie.getValue());
           * if(hash != box.$c(X.ENCRYPTED+"hash").getValue()){ errorCode = 6; box.setAttribute("errorCode", errorCode); return
           * createModelAndView("/core/account/login.jsp", box); }
           */

          user = userService.findUser(u);
          if (user == null) {
            errorCode = 3;
            box.setAttribute("errorCode", errorCode);
            return createModelAndView("/core/account/login.jsp", box);
          } else {
            // TODO update login time /IP /last_session /last_session_time
            Date logintime = new Date();
            String ip = HtmlParser.GetClientIp(request);
            String sessionid = MD5.md5Encode(X.uuid());
            user.setLastLoginIp(ip);
            user.setLastLoginTime(logintime);
            user.setLastSession(sessionid);
            user.setLastSessionTime(logintime);

            int i = userService.updateUser(user);

            // 登录成功设置session 与 cookie
            Cookie c = new Cookie(X.USER, user.getId().toString());
            c.setMaxAge(-1);
            box.getCookie().put(X.USER, c);
            Cookie userType = new Cookie(X.USER_TYPE, user.getType().toString());
            userType.setMaxAge(-1);
            box.getCookie().put(X.USER_TYPE, userType);
            writeCookies(box, response);

            // request.getSession().setAttribute(X.USER, user);
            request.getSession().setAttribute(X.USER, user.getId().toString());
            request.getSession().setAttribute(X.USER_TYPE, user.getType().toString());
            request.getSession().setAttribute(X.USER_NAME, user.getUsername());

            // TODO use for login unique
            request.getSession().setAttribute(X.SESSION_ID, sessionid);
            
         
            String refer = (String)request.getSession().getAttribute("refer");
            switch (user.getType()) {
            // 卖家
            case 0:
              if(!StringUtils.isEmpty(refer)){
                request.getSession().removeAttribute("refer");
                response.sendRedirect(refer);
              }else{
                response.sendRedirect("/userCenter/seller");
              }
              break;
            // 商家
            case 1:
              if(!StringUtils.isEmpty(refer)){
                request.getSession().removeAttribute("refer");
                response.sendRedirect(refer);
              }else{
                response.sendRedirect("/userCenter/supplier");
              }
              break;
            // 摄影
            case 2:
              response.sendRedirect("");
              break;
            // 代发
            case 3:
              response.sendRedirect("");
              break;
            }
            return null;
          }
        }
      }
  }

  /**
   * 注册页面
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register")
  public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.register()");
    Box box = loadNewBox(request);
    box.setAttribute("select", "seller");
    return createModelAndView("core/account/register.jsp", box);
  }

  /**
   * 注册成为卖家
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value="/register/register_as_seller",method=RequestMethod.POST)
  public ModelAndView registerAsSeller(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.registerAsSeller()");
    Box box = loadNewBox(request);
    box.setAttribute("select", "seller");
    //获取所有参数
    String userName = box.$p("username");
    String type = box.$p("type");
    String password_01 = box.$p("password_01");
    String password = box.$p("password");
    String[] store = request.getParameterValues("store");
    String qq = box.$p("qqnumber");
    String mobile = box.$p("phonenumber");
    String email = box.$p("email");
    String others = box.$p("others");
    String code = box.$p("code");
    String agree = box.$p("agree");
    //判断验证码
    String codeCookie = box.$c(X.ENCRYPTED + X.KEY).getValue();
    if(!code.equalsIgnoreCase(codeCookie)){
      box.setAttribute("msg", "验证码错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    String storeStr = "";
    //店铺拼接
    StringBuilder stores = new StringBuilder();
    if(store!=null&&store.length>0){
      for (int i = 0; i < store.length; i++) {
        stores.append(store[i]+",");
      }
      if(!StringUtils.isEmpty(others)){
        stores.append(others);
      }else{
        storeStr = stores.substring(0, stores.length()-1);
      }
    }
    
    //密码是否一致验证
    String password1 = "";
    String password2 = "";
    try {
      password1 = userService.convertStringToPassword(password_01);
      password2 = userService.convertStringToPassword(password);
      if(!password1.equals(password2)){
        box.setAttribute("msg", "两次密码不一致！");
        return createModelAndView("core/account/register.jsp", box);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    //用户名格式验证
    if(!userService.checkData("username", userName)){
      box.setAttribute("msg", "用户名格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    //验证密码问题
    if(password.length()<6||password.length()>16){
      box.setAttribute("msg", "密码只能在6位到16位之间！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    /*if(Pattern.matches("[\\da-zA-Z]+", password)){
      box.setAttribute("msg", "密码格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }*/
    
    //验证手机号码
    if(!userService.checkData("mobile", mobile)){
      box.setAttribute("msg", "错误的手机号码！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    //验证qq号
    if(!userService.checkData("qq",  qq)){
      box.setAttribute("msg", "qq格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    // 邮箱验证
    if(!userService.checkData("email",  email)){
      box.setAttribute("msg", "邮箱格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    //验证用户名手机号码和邮箱是否存在
    boolean isUserNameExist  = userService.isUserNameExist(userName);
    if(isUserNameExist){
      box.setAttribute("msg", "用户名已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean isMobileExist  = userService.isMobileExist(mobile);
    if(isMobileExist){
      box.setAttribute("msg", "手机号码已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean emailValidate  = userService.emailValidate(email);
    if(emailValidate){
      box.setAttribute("msg", "邮箱已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    //封装数据
    Date date = new Date();
    User user = new User();
    user.setUsername(userName);
    user.setPassword(password1);
    user.setType(Integer.parseInt(type));
    user.setMobile(mobile);
    user.setCreateTime(date);
    user.setCreateIp(box.getPageView().getIp());
    UserMeta userMeta = new UserMeta();
    userMeta.setEmail(email);
    userMeta.setQq(qq);
    userMeta.setStores(storeStr);
    userMeta.setCreateTime(date);
    //添加采购商
    user.setUserMeta(userMeta);
    userService.saveSeller(user);
    
    //注册成功跳至登录页面
    try {
      response.sendRedirect("/login");
    } catch (IOException e) {
      e.printStackTrace();
    }
    //失败则跳到注册页面
    return createModelAndView("core/account/register.jsp", box);
  }

  /**
   * 注册成为厂家
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register/register_as_supplier")
  public ModelAndView registerAsSupplier(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.registerAsSupplier()");
    Box box = loadNewBox(request);
    box.setAttribute("select", "supplier");
    //获取所有参数
    String userName = box.$p("username");
    String type = box.$p("type");
    String password_01 = box.$p("password_01");
    String password = box.$p("password");
    //这些存在site表
    String link = box.$p("link");//店铺链接
    String factoryName = box.$p("factoryname");
    String storeaddr = box.$p("storeaddr");//档口地址
    String facaddr = box.$p("facaddr");//厂址,暂时没存
    String contact = box.$p("contact");//联系人
    String[] nature = request.getParameterValues("nature");//经营性质
    String workerNumber = box.$p("worker_number");//生产规模
    String[] carry = request.getParameterValues("carry");//发货设置
    String[] agency = request.getParameterValues("agency");//分销招募
    
    //user表
    String qq = box.$p("qqnumber");
    String mobile = box.$p("phonenumber");
    String email = box.$p("email");
    String code = box.$p("code");
    String agree = box.$p("agree");
  //判断验证码
    String codeCookie = box.$c(X.ENCRYPTED + X.KEY).getValue();
    if(!code.equalsIgnoreCase(codeCookie)){
      box.setAttribute("msg", "验证码错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    //拼接经营性质字符转，以“，”连接
    String natureStr = "";
    if(nature!=null&&nature.length>0){
      for (int i = 0; i < nature.length; i++) {
        natureStr += nature[i]+",";
      }
      natureStr = natureStr.substring(0, natureStr.length()-1);
    }
    
    //发货设置
    String carryStr = "";
    if(carry!=null&&carry.length>0){
      for (int i = 0; i < carry.length; i++) {
        carryStr += carry[i]+",";
      }
      carryStr = carryStr.substring(0, carryStr.length()-1);
    }
    
    //分销招募
    String agencyStr = "";
    if(agency!=null&&agency.length>1){
      for (int i = 1; i < agency.length; i++) {
        agencyStr+=agency[i]+",";
      }
      agencyStr = agencyStr.substring(0,agencyStr.length()-1);
    }
  //密码是否一致验证
    String password1 = "";
    String password2 = "";
    try {
      password1 = userService.convertStringToPassword(password_01);
      password2 = userService.convertStringToPassword(password);
      if(!password1.equals(password2)){
        box.setAttribute("msg", "两次密码不一致！");
        return createModelAndView("core/account/register.jsp", box);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    //用户名格式验证
    if(!userService.checkData("username", userName)){
      box.setAttribute("msg", "用户名格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    //验证密码问题
    if(password.length()<6||password.length()>16){
      box.setAttribute("msg", "密码只能在6位到16位之间！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    /*if(Pattern.matches("[\\da-zA-Z]+", password)){
      box.setAttribute("msg", "密码格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }*/
    
    //验证手机号码
    if(!userService.checkData("mobile", mobile)){
      box.setAttribute("msg", "错误的手机号码！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    //验证qq号
    if(!userService.checkData("qq",  qq)){
      box.setAttribute("msg", "qq格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    // 邮箱验证
    if(!userService.checkData("email",  email)){
      box.setAttribute("msg", "邮箱格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    //店铺子域名验证
    if(!userService.checkData("link", link)){
      box.setAttribute("msg", "子域名格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    //商家名称验证
    if(!userService.checkData("username", factoryName)){
      box.setAttribute("msg", "商家名称格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    // 联系人进行验证
    if(!userService.checkData("chn", contact)){
      box.setAttribute("msg", "联系人必须是汉字！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    //验证用户名手机号码和邮箱和店铺地址和厂商名称是否存在
    boolean isUserNameExist  = userService.isUserNameExist(userName);
    if(isUserNameExist){
      box.setAttribute("msg", "用户名已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean isMobileExist  = userService.isMobileExist(mobile);
    if(isMobileExist){
      box.setAttribute("msg", "手机号码已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean emailValidate  = userService.emailValidate(email);
    if(emailValidate){
      box.setAttribute("msg", "邮箱已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean urlValidate = userService.urlValidate(link);
    if(urlValidate){
      box.setAttribute("msg", "店铺地址已经存在！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean isFacNameExist = userService.titleValidate(factoryName); 
    if(isFacNameExist){
      box.setAttribute("msg", "厂商名称已经存在！");
      return createModelAndView("core/account/register.jsp", box);
    }
    //获取当前时间
    Date date = new Date();
    //封装数据
    User user = new User();
    user.setType(Integer.parseInt(type));
    user.setUsername(userName);
    user.setPassword(password1);
    user.setMobile(mobile);
    user.setCreateIp(box.getPageView().getIp());
    user.setCreateTime(date);
    UserMeta userMeta = new UserMeta();
    userMeta.setEmail(email);
    userMeta.setQq(qq);
    userMeta.setCreateTime(date);
    Site site = new Site();
    site.setSubdomain(link);
    site.setCreateTime(date);
    Supplier supplier = new Supplier();
    supplier.setTitle(factoryName);
    supplier.setContact(contact);
    supplier.setAddress(storeaddr);
    supplier.setQq(qq);
    supplierMeta supplierMeta = new supplierMeta();
    supplierMeta.setNature(natureStr);
    supplierMeta.setGuimo(workerNumber);
    supplierMeta.setSetting(carryStr);
    supplierMeta.setRecruit(agencyStr);
    SupplierStats supplierStats = new SupplierStats();
    supplierStats.setState(1);
    supplierStats.setCreateTime(date);
    boolean result = userService.saveSupplier(user,userMeta,site,supplier,supplierMeta,supplierStats);
    //注册成功跳至登录页面
    if(result){
      try {
        response.sendRedirect("/login");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return createModelAndView("core/account/register.jsp", box);
  }
  
  /**
   * 注册成为代发商
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register/registerAsDaiFa")
  public ModelAndView registerAsDaiFa(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.registerAsDaiFa()");
    Box box = loadNewBox(request);
    box.setAttribute("select", "daifa");
    //获取所有参数
    String userName = box.$p("username");
    String type = box.$p("type");
    String password_01 = box.$p("password_01");
    String password = box.$p("password");
    String contact = box.$p("contact");//联系人
    String mobile = box.$p("phonenumber");
    String qq = box.$p("qqnumber");
    String email = box.$p("email");
    String serverteam = box.$p("serverteam");
    String code = box.$p("code");
    String agree = box.$p("agree");
    
    //判断验证码
    String codeCookie = box.$c(X.ENCRYPTED + X.KEY).getValue();
    if(!code.equalsIgnoreCase(codeCookie)){
      box.setAttribute("msg", "验证码错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
  //密码是否一致验证
    String password1 = "";
    String password2 = "";
    try {
      password1 = userService.convertStringToPassword(password_01);
      password2 = userService.convertStringToPassword(password);
      if(!password1.equals(password2)){
        box.setAttribute("msg", "两次密码不一致！");
        return createModelAndView("core/account/register.jsp", box);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    //用户名格式验证
    if(!userService.checkData("username", userName)){
      box.setAttribute("msg", "用户名格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
  //验证密码问题
    if(password.length()<6||password.length()>16){
      box.setAttribute("msg", "密码只能在6位到16位之间！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    /*if(Pattern.matches("[\\da-zA-Z]+", password)){
      box.setAttribute("msg", "密码格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }*/
    
    //验证手机号码
    if(!userService.checkData("mobile", mobile)){
      box.setAttribute("msg", "错误的手机号码！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    //验证qq号
    if(!userService.checkData("qq",  qq)){
      box.setAttribute("msg", "qq格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
    // 邮箱验证
    if(!userService.checkData("email",  email)){
      box.setAttribute("msg", "邮箱格式错误！");
      return createModelAndView("core/account/register.jsp", box);
    }
  //验证用户名手机号码和邮箱是否存在
    boolean isUserNameExist  = userService.isUserNameExist(userName);
    if(isUserNameExist){
      box.setAttribute("msg", "用户名已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean isMobileExist  = userService.isMobileExist(mobile);
    if(isMobileExist){
      box.setAttribute("msg", "手机号码已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    boolean emailValidate  = userService.emailValidate(email);
    if(emailValidate){
      box.setAttribute("msg", "邮箱已被注册！");
      return createModelAndView("core/account/register.jsp", box);
    }
    
    
    //封装数据
    Date date = new Date();
    User user = new User();
    user.setUsername(userName);
    user.setPassword(password1);
    user.setType(Integer.parseInt(type));
    user.setMobile(mobile);
    user.setCreateTime(date);
    user.setCreateIp(box.getPageView().getIp());
    UserMeta userMeta = new UserMeta();
    userMeta.setEmail(email);
    userMeta.setQq(qq);
    userMeta.setCreateTime(date);
    Daifa daifa = new Daifa();
    daifa.setContact(contact);
    daifa.setQq(qq);
    daifa.setServiceNature(serverteam.isEmpty()==true?"":serverteam);
    boolean rt = userService.saveDaifa(user, userMeta, daifa);
    //注册成功就跳至登录页面
    if(rt){
      try {
        response.sendRedirect("/login");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }else{
      return createModelAndView("core/account/register.jsp", box);
    }
    return createModelAndView("core/account/register.jsp", box);
  }
  
  
  
  
  /**
   * 验证用户名是否存在
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register/ajaxname")
  @ResponseBody
  public boolean ajaxName(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.ajaxName()");
    Box box = loadNewBox(request);
    String userName = box.$p("username");
    return userService.isUserNameExist(userName);
  }
  
  /**
   * 验证手机号码是否存在
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register/ajaxmobile")
  @ResponseBody
  public boolean ajaxMobile(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.ajaxMobile()");
    Box box = loadNewBox(request);
    String mobile = box.$p("mobile");
    return  userService.isMobileExist(mobile);
  }
  
  /**
   * 验证url
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register/ajaxUrl")
  @ResponseBody
  public boolean ajaxUrl(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.ajaxUrl()");
    Box box = loadNewBox(request);
    String url = box.$p("link");
    return userService.urlValidate(url);
  }
  
  /**
   * 验证邮箱
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register/ajaxEmail")
  @ResponseBody
  public boolean ajaxEmail(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.ajaxEmail()");
    Box box = loadNewBox(request);
    String email = box.$p("email");
    return userService.emailValidate(email);
  }
  
  /**
   * 验证商家名称
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/register/ajaxTitle")
  @ResponseBody
  public boolean ajaxTitle(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.ajaxTitle()");
    Box box = loadNewBox(request);
    String factoryname = box.$p("factoryname");
    return userService.titleValidate(factoryname);
  }
  
  
  /**
   * 验证验证码
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/validateCode")
  @ResponseBody
  public boolean validateCode(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.validateCode()");
    Box box = loadNewBox(request);
    String code =  box.$p("code");
    String codeCookie = box.$c(X.ENCRYPTED + X.KEY).getValue();
    return code.equalsIgnoreCase(codeCookie);
  }
  
  

  /**
   * 找回密码(一共四步)
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/forgetPassword")
  public ModelAndView forgotPassword(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.forgotPassword()");
    Box box = loadNewBox(request);
    //设置一个进入该页面的时间,超过五分钟即为超时
   /* Cookie c = new Cookie(X.ENCRYPTED+"forgetPasswordTime", System.currentTimeMillis()+"");
    c.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"forgetPasswordTime", c);
    writeCookies(box, response);*/
    box.setAttribute("step", "1");
    return createModelAndView("core/account/forgotPassword.jsp", box);
  }
  /**
   * 获取用户名
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/forgetPassword/getname")
  public ModelAndView forgotPasswordGetname(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.forgotPasswordGetname()");
    Box box = loadNewBox(request);
    //获取所有参数
    String userName = box.$p("username");
    String code = box.$p("code");
    if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(code)){
      box.setAttribute("step", "1");
      return createModelAndView("core/account/forgotPassword.jsp", box);
    }
    //判断验证码
    String codeCookie = box.$c(X.ENCRYPTED + X.KEY).getValue();
    if(!code.equalsIgnoreCase(codeCookie)||StringUtils.isEmpty(codeCookie)){
      //box.setAttribute("msg", "验证码错误！");
      box.setAttribute("step", "1");
      return createModelAndView("core/account/forgotPassword.jsp", box);
    }
    //判断用户名是否存在
    if(!userService.isUserNameExist(userName)){
      //box.setAttribute("msg", "用户名不存在！");
      box.setAttribute("step", "1");
      return createModelAndView("core/account/forgotPassword.jsp", box);
    }
    //根据用户名查询手机号码
    User u = new User();
    u.setUsername(userName);
    User user = userService.findUser(u);
    int between = user.getMobile().length()/2;
    String mobile = user.getMobile().substring(0, between-2) + "****" + user.getMobile().substring(between+2, user.getMobile().length());
    box.setAttribute("mobile", mobile);
    box.setAttribute("mobileTrue", user.getMobile());
    int userId = user.getId();
    //将userid加密存到cookie,后面的步骤都必须验证
    Cookie cUserId = new Cookie(X.ENCRYPTED+"userIdForgetPassword",userId+"");
    cUserId.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"userIdForgetPassword",cUserId);
    
    Cookie cMobile = new Cookie(X.ENCRYPTED+"mobileForgetPassword",user.getMobile());
    cMobile.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"mobileForgetPassword",cMobile);
    
    String email = userService.findEmailByUserId(userId);
    Cookie cEmail = new Cookie(X.ENCRYPTED+"emailForgetPassword",email);
    cEmail.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"emailForgetPassword",cEmail);
    
    //定义一个验证码时间cookie
    Cookie emailCodeTime = new Cookie(X.ENCRYPTED+"emailCodeTime","-1");
    cEmail.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"emailCodeTime",emailCodeTime);
    //定义手机验证码时间
    Cookie phoneCodeTime = new Cookie(X.ENCRYPTED+"phoneCodeTime","-1");
    cEmail.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"phoneCodeTime",phoneCodeTime);
    
    writeCookies(box, response);
    String regex = "(\\w{3})(\\w+)(\\w{3})(@\\w+)";
    box.setAttribute("email", email.replaceAll(regex, "$1****$3$4"));
    box.setAttribute("emailTrue", email);
    return createModelAndView("core/account/forgotPassword.jsp", box);
  }
  /**
   * 检查手机
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/forgetPassword/checkMobile")
  public ModelAndView checkMobile(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.checkMobile()");
    Box box = loadNewBox(request);
    
    //验证ways是否为空
    String ways = box.$p("ways");
    if(StringUtils.isEmpty(ways)){
      box.setAttribute("step", "1");
      return createModelAndView("core/account/forgotPassword.jsp", box);
    }
    
    String codePhone = box.$p("code_phone");
    String codePhoneCookie = box.$cv(X.ENCRYPTED+"phoneCode");
    //String mobile = box.$p("mobile");
    
    //String email = box.$p("email");
    String emailCode = box.$p("code_email");
    String emailCodeCookie = box.$cv(X.ENCRYPTED+"emailCode");
    
    if("0".equals(ways)){
      //验证是否非法操作
      if(StringUtils.isEmpty(codePhone)||StringUtils.isEmpty(codePhoneCookie)){
        box.setAttribute("step", "1");
        return createModelAndView("core/account/forgotPassword.jsp", box);
      }
      //对比验证码
      if(!codePhone.equalsIgnoreCase(codePhoneCookie)){
        box.setAttribute("step", "1");
        return createModelAndView("core/account/forgotPassword.jsp", box);
      }
    }else if("1".equals(ways)){
        //验证邮箱
        if(StringUtils.isEmpty(emailCode)||StringUtils.isEmpty(emailCodeCookie)){
          box.setAttribute("step", "1");
          return createModelAndView("core/account/forgotPassword.jsp", box);
        }
      //对比验证码
      if(!emailCode.equalsIgnoreCase(emailCodeCookie)){
        box.setAttribute("step", "1");
        return createModelAndView("core/account/forgotPassword.jsp", box);
      }
    }else{
      box.setAttribute("step", "1");
      return createModelAndView("core/account/forgotPassword.jsp", box);
    }
    box.setAttribute("step", "3");
    return createModelAndView("core/account/forgotPassword.jsp", box);
  }
  
  /**修改密码，跳到成功
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/forgetPassword/setNewpassword")
  public ModelAndView setNewpassword(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.setNewpassword()");
    Box box = loadNewBox(request);
    String password01 =  box.$p("password01");
    String password02 =  box.$p("password02");
    
    //密码是否一致验证
    String password1 = "";
    String password2 = "";
    try {
      password1 = userService.convertStringToPassword(password01);
      password2 = userService.convertStringToPassword(password02);
      if(!password1.equals(password2)){
        //box.setAttribute("msg", "两次密码不一致！");
        box.setAttribute("step", "1");
        return createModelAndView("core/account/forgotPassword.jsp", box);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    //取出useid
    String userId = box.$cv(X.ENCRYPTED+"userIdForgetPassword");
    if(StringUtils.isEmpty(userId)){
      box.setAttribute("step", "1");
      return createModelAndView("core/account/forgotPassword.jsp", box);
    }
    User user = new User();
    user.setId(Integer.parseInt(userId));
    user.setPassword(password1);
    userService.updateUserPassword(user);
    //清除cookie
    box.removeCookie(X.ENCRYPTED+"userIdForgetPassword");
    box.removeCookie(X.ENCRYPTED+"mobileForgetPassword");
    box.removeCookie(X.ENCRYPTED+"emailForgetPassword");
    box.removeCookie(X.ENCRYPTED+"phoneCode");
    box.removeCookie(X.ENCRYPTED+"phoneCodeTime");
    box.removeCookie(X.ENCRYPTED+"emailCode");
    box.removeCookie(X.ENCRYPTED+"emailCodeTime");
    writeCookies(box, response);
    box.setAttribute("step", "4");
    return createModelAndView("core/account/forgotPassword.jsp", box);
  }
  
  
  /**
   * 检查验证是否正确
   * @return
   */
  @RequestMapping("/forgetPassword/ajaxmobilecode")
  @ResponseBody
  public boolean ajaxMobileCode(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.MobileValidateSend()");
    Box box = loadNewBox(request);
    String phoneCode = box.$p("code");
    String phoneCodeCookie = box.$cv(X.ENCRYPTED+"phoneCode");
    if(StringUtils.isEmpty(phoneCode)||StringUtils.isEmpty(phoneCodeCookie)){
      return false;
    }
    if(phoneCodeCookie.equalsIgnoreCase(phoneCode)){
      return true;
    }
    return false;
  }
  
  /**
   * 手机验证码
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value="/mobileCode",produces = "application/html;charset=utf-8")
  @ResponseBody
  public String MobileValidateSend(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.MobileValidateSend()");
    Box box = loadNewBox(request);
    String phoneCodeTime = box.$cv(X.ENCRYPTED+"phoneCodeTime");
    long currentTime = System.currentTimeMillis();
    if(StringUtils.isEmpty(phoneCodeTime)){
      return "非法操作";
    }else{
      if("-1".equals(phoneCodeTime)){
        //存下当前时间
        Cookie c = new Cookie(X.ENCRYPTED+"phoneCodeTime", currentTime+"");
        c.setMaxAge(-1);
        box.setCookie(X.ENCRYPTED+"phoneCodeTime", c);
      }else{
        //如果不等于1，比较当前时间
        long lastTime = Long.parseLong(phoneCodeTime);
        if((currentTime-lastTime)/1000<=60){
          return "请在一分钟后再次发送";
        }
      }
    }
    
    String mobile = box.$p("mobile");
    mobile = aes.encrypt(mobile);
    //生成验证码
    String code = RandomStringUtils.randomNumeric(6);
    
    String content = aes.encrypt(code);
    String url = "http://"+X.getConfig("com.go2plus.globle.sms.host")+"/sms/sender/send?mobileNumbers="+mobile+"&content="+content;
    //String url = "http://192.168.3.107:8000/sms/sender/send?mobileNumbers="+mobile+"&content="+content;
    String ret = HttpAgent.get(url);
    if(!"success".equals(ret.trim())){
      return "发送失败";
    }
    Cookie cookie = new Cookie(X.ENCRYPTED+"phoneCode", code);
    cookie.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"phoneCode", cookie);
    writeCookies(box, response);
    return "发送成功";
  }
  
  
  /**
   * 检查邮箱验证是否正确
   * @return
   */
  @RequestMapping("/forgetPassword/ajaxemailcode")
  @ResponseBody
  public boolean ajaxEmailCode(HttpServletRequest request, HttpServletResponse response) {
    log.debug("SignInController.ajaxEmailCode()");
    Box box = loadNewBox(request);
    String emailCode = box.$p("code");
    String emailCodeCookie = box.$cv(X.ENCRYPTED+"emailCode");
    if(StringUtils.isEmpty(emailCode)||StringUtils.isEmpty(emailCodeCookie)){
      return false;
    }
    
    if(emailCodeCookie.equalsIgnoreCase(emailCode)){
      return true;
    }
    return false;
  }
  
  /**
   * 发送邮件验证码
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value="/eamilCode",produces = "application/html;charset=utf-8")
  @ResponseBody
  public String SendEmailCode(HttpServletRequest request, HttpServletResponse response){
    log.debug("SignInController.SendEmailCode()");
    Box box = loadNewBox(request);
    //从cookie取出emailCodeTime判断是否存在，如果不存在提示非法操作
    String emailCodeTime = box.$cv(X.ENCRYPTED+"emailCodeTime");
    long currentTime = System.currentTimeMillis();
    if(StringUtils.isEmpty(emailCodeTime)){
      return "非法操作";
    }else{
      if("-1".equals(emailCodeTime)){
        //存下当前时间
        Cookie c = new Cookie(X.ENCRYPTED+"emailCodeTime", currentTime+"");
        c.setMaxAge(-1);
        box.setCookie(X.ENCRYPTED+"emailCodeTime", c);
      }else{
        //如果不等于1，比较当前时间
        long lastTime = Long.parseLong(emailCodeTime);
        if((currentTime-lastTime)/1000<=60){
          return "请在一分钟后再次发送";
        }
      }
    }
    String email = box.$p("email");
    if(StringUtils.isEmpty(email)){
      return "请输入邮箱地址";
    }
    if(!userService.checkData("email", email)){
      return "邮箱格式错误，请及时修改邮箱";
    }
    String code = RandomStringUtils.randomNumeric(6);
    //发送邮件验证码,并加密存到cookie
    Cookie c = new Cookie(X.ENCRYPTED+"emailCode", code);
    c.setMaxAge(-1);
    box.setCookie(X.ENCRYPTED+"emailCode", c);
    writeCookies(box, response);
    SendEMail.mail(email,"星购途找回密码",code);
    return "发送成功";
  }
  
  

}
