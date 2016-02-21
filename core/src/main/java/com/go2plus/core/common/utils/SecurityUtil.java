package com.go2plus.core.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.go2plus.common.X;
import com.go2plus.common.encrypt.AES;
import com.go2plus.core.sys.service.UserService;
import com.go2plus.core.sys.vo.User;

public class SecurityUtil {
    private static InheritableThreadLocal<User> userThreadLocal = new InheritableThreadLocal<User>();
    private static AES aes = SpringUtils.getBean("aes");
    private static UserService userService = SpringUtils.getBean("userServiceImpl");
    public static  User getLoginOperator(){
      HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
      Object _id = request.getSession().getAttribute(X.USER);
      //获取登录的用户
      
      User user = userService.findById(Long.valueOf(_id.toString()));
      if(null==user){
        return null;
      }
      return user;
    }
    public static  String getLoginOperatorName(){
      HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
      Object _name = request.getSession().getAttribute(X.USER_NAME);
      if(_name == null){
        return null;
      }
      return _name.toString();
    }
    public static  String getLoginOperatorType(){
      HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
      Object _type = request.getSession().getAttribute(X.USER_TYPE);
      if(_type == null){
        return null;
      }
      return _type.toString();
    }
    
    public static void addUserInfo2Cookie(Long id,String username, String userType, HttpServletResponse response){
      User user = new User();
      user.setId(id);
      user.setUsername(username);
      user.setUserType(userType);
      addUserInfo2Cookie(user, response);
    }
    public static void addUserInfo2Cookie(User user,HttpServletResponse response){
      // 登录成功设置session 与 cookie
      
      String domains = X.getConfig("server.cookie.domains");
      String maxage = X.getConfig("server.cookie.maxage");
      int maxAge = -1;
      if(StringUtils.isNotEmpty(maxage)){
        maxAge = Integer.parseInt(maxage);
      }
      Cookie cuid = new Cookie(X.USER, X.USER.startsWith(X.ENCRYPTED) ? aes.encrypt(user.getId().toString()) : user.getId().toString());
      cuid.setMaxAge(maxAge);
      cuid.setPath(X.WEB_ROOT);
      
      Cookie cutype = new Cookie(X.USER_TYPE, X.USER_TYPE.startsWith(X.ENCRYPTED) ? aes.encrypt(user.getUserType()) : user.getUserType());
      cutype.setMaxAge(maxAge);
      cutype.setPath(X.WEB_ROOT);

      Cookie cuname = new Cookie(X.USER_NAME, X.USER_NAME.startsWith(X.ENCRYPTED) ? aes.encrypt(user.getUsername()) : user.getUsername());
      cuname.setMaxAge(maxAge);
      cuname.setPath(X.WEB_ROOT);
      
      if(StringUtils.isNotEmpty(domains)){
        cuid.setDomain(domains);
        cutype.setDomain(domains);
        cuname.setDomain(domains);
      }
      response.addCookie(cuid);
      response.addCookie(cutype);
      response.addCookie(cuname);
    }
    public static User getUserInfoFromCookie(HttpServletRequest request){
      // 检测userId和 userType
      Cookie[] clientCookiesArray = request.getCookies();
      if (null != clientCookiesArray) {
        String userId = "";
        String userType = "";
        String username = "";
        for (Cookie c : clientCookiesArray) {
          String name = c.getName();
          String value = name.startsWith(X.ENCRYPTED) ? aes.decrypt(c.getValue()) : c.getValue();
          if(name.equals(X.USER)){
            userId = value;
            continue;
          }
          if(name.equals(X.USER_TYPE)){
            userType = value;
            continue;
          }
          if(name.equals(X.USER_NAME)){
            username = value;
            continue;
          }
        }
        if(StringUtils.isNotEmpty(userId)&&StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(userType)){
          User user = new User();
          user.setId(Long.valueOf(userId));
          user.setUsername(username);
          user.setUserType(userType);
          return user;
        }
      }
      return null;
    }
    public static void addUserInfo2Session(Long id,String username, String userType, HttpServletRequest request){
      User user = new User();
      user.setId(id);
      user.setUsername(username);
      user.setUserType(userType);
      addUserInfo2Session(user, request);
    }
    public static void addUserInfo2Session(User user,HttpServletRequest request){
      request.getSession(true).setAttribute(X.USER, user.getId().toString());
      request.getSession().setAttribute(X.USER_TYPE, user.getUserType().toString());
      request.getSession().setAttribute(X.USER_NAME, user.getUsername());
    }
    public static User getUserInfoFromSession(HttpServletRequest request){
      Object userId = request.getSession().getAttribute(X.USER);
      Object userType = request.getSession().getAttribute(X.USER_TYPE);
      Object username = request.getSession().getAttribute(X.USER_NAME);
      if(userId != null && username != null && userType != null){
        User user = new User();
        user.setId(Long.valueOf(userId.toString()));
        user.setUsername(username.toString());
        user.setUserType(userType.toString());
        return user;
      }
      return null;
    }
    public static void removeUserinfoFromSession(HttpServletRequest request){
      request.getSession().removeAttribute(X.USER);
      request.getSession().removeAttribute(X.USER_TYPE);
      request.getSession().removeAttribute(X.USER_NAME);
    }
    public static void removeUserinfoFromCookie(HttpServletResponse response){
      String domains = X.getConfig("server.cookie.domains");
      Cookie cuid = new Cookie(X.USER, "");
      cuid.setMaxAge(0);
      cuid.setPath(X.WEB_ROOT);
      
      Cookie cutype = new Cookie(X.USER_TYPE, "");
      cutype.setMaxAge(0);
      cutype.setPath(X.WEB_ROOT);

      Cookie cuname = new Cookie(X.USER_NAME, "");
      cuname.setMaxAge(0);
      cuname.setPath(X.WEB_ROOT);
      
      if(StringUtils.isNotEmpty(domains)){
        cuid.setDomain(domains);
        cutype.setDomain(domains);
        cuname.setDomain(domains);
      }
      response.addCookie(cuid);
      response.addCookie(cutype);
      response.addCookie(cuname);
    }
}
