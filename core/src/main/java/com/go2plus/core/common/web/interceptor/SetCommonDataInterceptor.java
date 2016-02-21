package com.go2plus.core.common.web.interceptor;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.go2plus.common.X;
import com.go2plus.common.encrypt.AES;
import com.go2plus.core.common.Constants;
import com.go2plus.core.common.utils.LogUtils;
import com.go2plus.core.common.utils.SecurityUtil;
import com.go2plus.core.common.web.upload.FileUploadUtils;
import com.go2plus.core.sys.vo.User;

/**
 * 设置通用数据的Interceptor
 * <p/>
 * 使用Filter时 文件上传时 getParameter时为null 所以改成Interceptor
 * <p/>
 * 1、ctx---->request.contextPath 2、currentURL---->当前地址
 * <p>
 * User: mtwu
 * <p>
 * Date: 13-1-22 下午4:35
 * <p>
 * Version: 1.0
 */
public class SetCommonDataInterceptor extends HandlerInterceptorAdapter{

  private final PathMatcher     pathMatcher                       = new AntPathMatcher();
  
  @Resource
  protected AES                 aes;
  
  private static final String[] DEFAULT_EXCLUDE_PARAMETER_PATTERN = new String[] { "\\&\\w*page.pn=\\d+", "\\?\\w*page.pn=\\d+",
      "\\&\\w*page.size=\\d+"                                    };
  private static final String   InterceptorUrl                    = "/userCenter";
  private static final String   LoginUrl                          = "/login";
  private static final String   AdminUrl                          = "/admin";
  private String[]              excludeParameterPatterns          = DEFAULT_EXCLUDE_PARAMETER_PATTERN;
  private String[]              excludeUrlPatterns                = null;

  public void setExcludeParameterPatterns(String[] excludeParameterPatterns) {
    this.excludeParameterPatterns = excludeParameterPatterns;
  }

  public void setExcludeUrlPatterns(final String[] excludeUrlPatterns) {
    this.excludeUrlPatterns = excludeUrlPatterns;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    
    if (request.getAttribute(Constants.CONTEXT_PATH) == null) {
      if(org.apache.commons.lang3.StringUtils.isNotEmpty(X.getConfig("server.domains"))){
        request.setAttribute(Constants.CONTEXT_PATH, request.getScheme()+"://"+X.getConfig("server.domains")+":"+request.getServerPort()+request.getContextPath());
      }
      else{
        request.setAttribute(Constants.CONTEXT_PATH, request.getContextPath());     
      }
    }
    if (request.getAttribute(Constants.CURRENT_URL) == null) {
      
      request.setAttribute(Constants.CURRENT_URL, URLEncoder.encode(extractCurrentURL(request, true),"UTF-8"));
    }
    if (request.getAttribute(Constants.NO_QUERYSTRING_CURRENT_URL) == null) {
      request.setAttribute(Constants.NO_QUERYSTRING_CURRENT_URL, extractCurrentURL(request, false));
    }
    if (request.getAttribute(Constants.BACK_URL) == null) {
      request.setAttribute(Constants.BACK_URL, extractBackURL(request));
    }

    if (request.getAttribute(Constants.IMAGESERVERURL) == null) {
      request.setAttribute(Constants.IMAGESERVERURL, FileUploadUtils.getServerUrl());
    }
    
    
    // 检测userId和 userType
    User cuser = SecurityUtil.getUserInfoFromCookie(request);
    User suser = SecurityUtil.getUserInfoFromSession(request);
    
    if (suser==null) {
      if(cuser != null){
        SecurityUtil.addUserInfo2Session(cuser, request);
      }
    }
    else if (cuser == null){
      cuser = suser;
      SecurityUtil.addUserInfo2Cookie(suser, response);
    }
    
    String reqUrl = request.getRequestURI();
    System.out.println("reuqestUrl:["+isExclude(request)+"]"+reqUrl);
    if (isExclude(request)) {
      return true;
    }
    //用户行为
    LogUtils.logAccess(request);
    
    // not login
    if (cuser == null) {
      // String pageUrl = pageView.getUrl();
      String url = request.getRequestURI();
      if (url.contains(InterceptorUrl) || url.contains(AdminUrl)) {
        response.sendRedirect(request.getContextPath()+LoginUrl);
        return false;
      } else {
        return true;
      }
    } else {
      String url = request.getRequestURI();
      
      if (url.contains(InterceptorUrl + "/common")) {
        return true;
      }
      
      if (url.contains(InterceptorUrl) || url.contains(AdminUrl)) {
        switch (cuser.getUserType()) {
        case "model":
          if (url.contains(InterceptorUrl + "/model")) {
            return true;
          } else {
            response.sendRedirect(request.getContextPath()+LoginUrl);
            return false;
          }
        case "photographer":
          if (url.contains(InterceptorUrl + "/photographer")) {
            return true;
          } else {
            response.sendRedirect(request.getContextPath()+LoginUrl);
            return false;
          }
        case "admin":
          if (url.contains(AdminUrl)) {
            return true;
          } else {
            response.sendRedirect(request.getContextPath()+LoginUrl);
            return false;
          }
        }
      }
    }

    return true;
  }

  private boolean isExclude(final HttpServletRequest request) {
    if (excludeUrlPatterns == null) {
      return false;
    }
    for (String pattern : excludeUrlPatterns) {
      if (pathMatcher.match(pattern.trim(), request.getServletPath())) {
        return true;
      }
    }
    return false;
  }

  private String extractCurrentURL(HttpServletRequest request, boolean needQueryString) {
    String url = request.getRequestURI();
    String queryString = request.getQueryString();
    if (!StringUtils.isEmpty(queryString)) {
      queryString = "?" + queryString;
      for (String pattern : excludeParameterPatterns) {
        queryString = queryString.replaceAll(pattern, "");
      }
      if (queryString.startsWith("&")) {
        queryString = "?" + queryString.substring(1);
      }
    }
    if (!StringUtils.isEmpty(queryString) && needQueryString) {
      url = url + queryString;
    }
    return getBasePath(request) + url;
  }

  /**
   * 上一次请求的地址 1、先从request.parameter中查找BackURL 2、获取header中的 referer
   * 
   * @param request
   * @return
   */
  private String extractBackURL(HttpServletRequest request) {
    String url = request.getParameter(Constants.BACK_URL);

    // 使用Filter时 文件上传时 getParameter时为null 所以改成Interceptor

    if (StringUtils.isEmpty(url)) {
      url = request.getHeader("Referer");
    }

    if (!StringUtils.isEmpty(url) && (url.startsWith("http://") || url.startsWith("https://"))) {
      return url;
    }

    if (!StringUtils.isEmpty(url) && url.startsWith(request.getContextPath())) {
      url = getBasePath(request) + url;
    }
    return url;
  }

  private String getBasePath(HttpServletRequest req) {
    StringBuffer baseUrl = new StringBuffer();
    String scheme = req.getScheme();
    int port = req.getServerPort();

    // String servletPath = req.getServletPath ();
    // String pathInfo = req.getPathInfo ();

    baseUrl.append(scheme); // http, https
    baseUrl.append("://");
    baseUrl.append(req.getServerName());
    if ((scheme.equals("http") && port != 80) || (scheme.equals("https") && port != 443)) {
      baseUrl.append(':');
      baseUrl.append(req.getServerPort());
    }
    return baseUrl.toString();
  }
  
  public static void main(String args[]){
    String regex = "/**/static/**";
    PathMatcher  pathMatcher = new AntPathMatcher();
    System.out.println(pathMatcher.match(regex, "/static/css/userCenter/userCenterNav.css"));
  }
}
