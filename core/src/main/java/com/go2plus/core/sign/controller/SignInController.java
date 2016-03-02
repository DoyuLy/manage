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
import com.go2plus.core.sys.service.UserService;
import com.go2plus.core.sys.vo.User;

/**
 * 登录Controller, 处理用户登录相关的请求
 * 
 * @author duyu
 * @since 2015-10-20
 */
@Controller
public class SignInController extends BaseVerificationController {
	private final static Logger log = LoggerFactory
			.getLogger(SignInController.class);

	@Resource
	private UserService userService;

	/**
	 * 验证码
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/verify", method = RequestMethod.GET)
	public void getVerifyCodeImg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Box box = loadNewBox(request);
		if (!"POST".equalsIgnoreCase(request.getMethod())) {
			return createModelAndView("/core/account/login.jsp", box);
		}
		String userName = box.$p("username");
		String passWord = X.USER_PASS_PREFIX + box.$p("password");
		String verifyCode = box.$p("verifycode");
		userName = (userName == null || userName.isEmpty()) ? "" : userName
				.trim();
		passWord = (passWord == null || passWord.isEmpty()) ? "" : MD5
				.md5Encode(passWord.trim());
		verifyCode = (verifyCode == null || verifyCode.isEmpty()) ? ""
				: verifyCode.trim().toLowerCase();

		// TODO 预定义错误码 enum
		int errorCode = 0; // 0:正常;1:用户名账号或密码不能为空;2:没有此用户;3:密码错误;4:验证码过期;5.验证码错误;6:非法登录
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
					diff = format.parse(X.nowString()).getTime()
							- format.parse(cookie.getValue()).getTime();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (diff / 1000 > Integer.parseInt(X.getTimeout())) {
					errorCode = 4;
					box.setAttribute("errorCode", errorCode);
					return createModelAndView("/core/account/login.jsp", box);
				}

				if (!box.$c(X.ENCRYPTED + X.KEY).getValue()
						.equalsIgnoreCase(verifyCode)) {
					errorCode = 5;
					box.setAttribute("errorCode", errorCode);
					return createModelAndView("/core/account/login.jsp", box);
				}

				/**
				 * for(Cookie c : cookies){
				 * if(c.getName().equalsIgnoreCase(X.ENCRYPTED+X.TIME)){ long
				 * diff = format.parse( X.nowString()).getTime() -
				 * format.parse(c.getValue()).getTime(); if(diff > 600){
				 * errorCode = 4; box.setAttribute("errorCode", errorCode);
				 * return createModelAndView("/core/account/login.jsp", box); }
				 * } }
				 

				// TODO HASH签名
				
				 * String hash =
				 * MD5.md5Encode(MD5.md5Encode(verifyCode.toLowerCase
				 * ()+X.USER_PASS_PREFIX)+X.USER_PASS_PREFIX+cookie.getValue());
				 * if(hash != box.$c(X.ENCRYPTED+"hash").getValue()){ errorCode
				 * = 6; box.setAttribute("errorCode", errorCode); return
				 * createModelAndView("/core/account/login.jsp", box); }
				 **/

				user = userService.findUser(u);
				if (user == null) {
					errorCode = 3;
					box.setAttribute("errorCode", errorCode);
					return createModelAndView("/core/account/login.jsp", box);
				} else {
					// TODO update login time /IP /last_session
					// /last_session_time
					Date logintime = new Date();
					String ip = HtmlParser.GetClientIp(request);
					String sessionid = MD5.md5Encode(X.uuid());
					user.setLastLoginIp(ip);
					user.setLastLoginTime(logintime);

					//int i = userService.updateUser(user);

					// 登录成功设置session 与 cookie
					Cookie c = new Cookie(X.USER, user.getId().toString());
					c.setMaxAge(-1);
					box.getCookie().put(X.USER, c);
//					Cookie userType = new Cookie(X.USER_TYPE,user.getType()
//							.toString());
				//	userType.setMaxAge(-1);
					//box.getCookie().put(X.USER_TYPE, userType);
					writeCookies(box, response);

					// request.getSession().setAttribute(X.USER, user);
//					request.getSession().setAttribute(X.USER,
//							user.getId().toString());
//					request.getSession().setAttribute(X.USER_TYPE,
//							user.getType().toString());
//					request.getSession().setAttribute(X.USER_NAME,
//							user.getUsername());

					// TODO use for login unique
					request.getSession().setAttribute(X.SESSION_ID, sessionid);

					String refer = (String) request.getSession().getAttribute(
							"refer");
//					switch (user.getType()) {
//					// 卖家
//					case 0:
//						if (!StringUtils.isEmpty(refer)) {
//							request.getSession().removeAttribute("refer");
//							response.sendRedirect(refer);
//						} else {
//							response.sendRedirect("/userCenter/seller");
//						}
//						break;
//					// 商家
//					case 1:
//						if (!StringUtils.isEmpty(refer)) {
//							request.getSession().removeAttribute("refer");
//							response.sendRedirect(refer);
//						} else {
//							response.sendRedirect("/userCenter/supplier");
//						}
//						break;
//					// 摄影
//					case 2:
//						response.sendRedirect("");
//						break;
//					// 代发
//					case 3:
//						response.sendRedirect("");
//						break;
//					}
					return null;
				}
			}
		}
	}

}
