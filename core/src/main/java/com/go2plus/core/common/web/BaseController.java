package com.go2plus.core.common.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

/**
 * <p>
 * Description:
 * <p>
 * User: mtwu
 * <p>
 * Date: 2015-12-8
 * <p>
 * Version: 1.0
 */
public abstract class BaseController {
  private final String ERROE_MESSAGE     = "msg.op_failure";
  private final String SECCUSS_MESSAGE   = "msg.op_failure";
  private final String SESSION_TOKEN_TAG = "secToken";
  private final String WEB_TOKEN_TAG     = "webToken";

  
  protected void sendOpMsg(HttpServletRequest request, String key, String otherMsg) {
    request.setAttribute("messageKey", key);
    if (otherMsg != null) {
      request.setAttribute("messageOther", otherMsg);
    }
  }

  protected String getRandomNumber() {
    return RandomStringUtils.randomNumeric(18);
  }

  protected void setToken(HttpServletRequest request) {
    String theToken = getRandomNumber();
    WebUtils.setSessionAttribute(request, SESSION_TOKEN_TAG, theToken);
    request.setAttribute(WEB_TOKEN_TAG, theToken);
  }

  protected void resetToken(HttpServletRequest request) {
    WebUtils.setSessionAttribute(request, SESSION_TOKEN_TAG, getRandomNumber());
  }

  protected boolean validToken(HttpServletRequest request) {
    Object obj = WebUtils.getSessionAttribute(request, SESSION_TOKEN_TAG);
    String secToken = null;
    if (obj != null) {
      secToken = (String) obj;
    }
    String webToken = request.getParameter(WEB_TOKEN_TAG);
    if (secToken == null) {
      return true;
    } else if (webToken != null && secToken.equals(webToken)) {
      resetToken(request);
      return true;
    }
    return false;
  }

  public ModelAndView showError() {
    return new ModelAndView("showError");
  }
}