package com.go2plus.core.publish.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.go2plus.common.X;
import com.go2plus.common.img.ImgAddressConvert;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.common.mvc.Box;
import com.go2plus.core.product.vo.Product;
import com.go2plus.core.publish.service.PublishService;
import com.go2plus.core.publish.vo.LogDownload;
import com.go2plus.core.publish.vo.ProductDownload;
import com.go2plus.core.publish.vo.TaobaoItem;
import com.go2plus.core.userCenter.service.UserService;
import com.go2plus.core.userCenter.vo.User;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * 发布到淘宝/阿里/微店 Controller
 * 
 * @author duyu
 * @since 2015-12-30
 */
@Controller
public class PublishController extends BaseController {
	private final static Logger logger = LoggerFactory
			.getLogger(PublishController.class);

	@Resource
	private PublishService publishService;
	@Resource
	private UserService    userService;

	/**
	 * 
	 * @param type
	 *            1:淘宝 , 2:阿里 (微店目前无表)
	 * @param pid
	 *            产品加密id
	 * @param request
	 * @param response
	 * @param session
	 * @return 发布平台(带token)地址
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/product/publish/{type}/{pid}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody()
	public String publish(@PathVariable String type, @PathVariable String pid, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		Box box = loadNewBox(request);

		if (null == type || type.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "发布第三方平台不能为空！";
		}
		if (null == pid || pid.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "产品id不能为空！";
		}

		// test
		String test1 = X.decodeId("gaskei"); // 237856
		String test2 = X.encodeId("237856"); // gaskei

		String userId = box.$cv(X.USER);
		String userType = box.$cv(X.USER_TYPE);

		if (null == userId || null == userType) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}

		List<TaobaoItem> itemRecords = publishService.getTaobaoItemsRecord(
				userId, pid);
		// 厂家与摄影禁止发布
		if (userType.equals("1") || userType.equals("2")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "厂家与摄影账号不能使用本功能！";
		}
		// 发布限制5次以内
		if (itemRecords.size() >= 5) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "该产品发布次数超过限制！";
		}
		if (itemRecords.size() >= 0) {
			int isWireless = 1;
			if(itemRecords.size() != 0){
				DateFormat df = new SimpleDateFormat(X.TIMEA);
				long diff = System.currentTimeMillis()
						- df.parse(df.format(itemRecords.get(0).getPublishTime()))
								.getTime();
				// 3分钟内禁止重复发布
				if (diff > 18000) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return "您的发布速度太快，请稍后再发布！";
				}
				isWireless = itemRecords.get(0)
						.getWlState();
			}
			String subUrl = MessageFormat
					.format("url={0}&uid={1}&pid={2}&type={3}&s=9&is_auto_wireless={4}",
							X.SERVER_NAME_DOMAIN, userId,
							type.equals("1") ? X.decodeId(pid) : pid, type,
							isWireless);
			return publishService.getEncrypt(subUrl, type);
		} else {
			return null;
		}

	}

	/**
	 * 数据包下载
	 * 
	 * @param pid
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/product/download/{pid}", method = RequestMethod.GET)
	@ResponseBody()
	public ModelAndView download(@PathVariable String pid,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Box box = loadNewBox(request);

		String userId = box.$cv(X.USER);
		String userType = box.$cv(X.USER_TYPE);
		if (null == userId || userId.equals("")) {
			response.sendRedirect("/login");
			return null;
		}

		if (null == pid || pid.isEmpty()) {
			box.setAttribute("error", "无此产品！");
			return createModelAndView("/core/product/download.jsp", box);
		}
		//卖家 与 代发 无权下载 (TODO 在界面进行屏蔽下载按钮)
		if (userType.equals("3") || userType.equals("0")) {
			box.setAttribute("error", "您无权访问本页面！");
			return createModelAndView("/core/product/download.jsp", box);
		}

		User u = new User();
		u.setId(Integer.parseInt(userId));
		User user = userService.findUser(u);
		if (null == userId || null == user) {
			box.setAttribute("error", "非法用户！");
			return createModelAndView("/core/product/download.jsp", box);
		}
		
		// 解码
		pid = X.decodeId(pid);
		List<ProductDownload> list = publishService.getDownloadProduct(pid);
		
		if(null != list && list.size() > 0){
			if(!list.get(0).getState().equals(1)){
				box.setAttribute("error", "该产品未上架，不能下载！");
				return createModelAndView("/core/product/download.jsp", box);
			}else{
				int times = publishService.getDownOrLinkTimes(userId);
				long date = (new Date()).getTime();
				
				//入驻超一月用户的次数限制
				if((date - user.getCreateTime().getTime()) > 2592000){
					if(times > 200){
						box.setAttribute("error", "您今天的下载或外联已达到上限！");
						return createModelAndView("/core/product/download.jsp", box);
					}
				}else if((date - user.getCreateTime().getTime()) > 86400){
					//入驻在一天到一月间用户的次数限制
					if(times > 60){
						box.setAttribute("error", "您注册未满一月，您今天的下载或外联已达到上限！");
						return createModelAndView("/core/product/download.jsp", box);
					}
				}else{
					if(times > 20){
						box.setAttribute("error", "作为新用户，您今天的下载或外联已达到上限！");
						return createModelAndView("/core/product/download.jsp", box);
					}
				}
				List<ProductDownload> products = publishService.getProductBySupplierId(userId, pid);
				
				/*Product curProduct = publishService.getFile(pid);
				if(null != curProduct){
					curProduct.setId(Integer.parseInt(pid));
					curProduct.setFile("");
				}
				
				box.setAttribute("curProduct", curProduct);
				box.setAttribute("fileSize", "");*/
				box.setAttribute("products", products);
				box.setAttribute("pid", pid);
				return createModelAndView("/core/product/download.jsp", box);
			}
		}else{
			box.setAttribute("error", "系统错误！");
			return createModelAndView("/core/product/download.jsp", box);
		}
		
	}
	
	
	/**
	 * 获取产品压缩包下载文件
	 * @param pid
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	
	@RequestMapping(value = "/product/getfile/{pid}", method = RequestMethod.GET)
	@ResponseBody()
	public String getFile(@PathVariable String pid,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		Box box = loadNewBox(request);

		String userId = box.$cv(X.USER);
		String userType = box.$cv(X.USER_TYPE);
		if (null == userId || userId.equals("")) {
			response.sendRedirect("/login");
			return null;
		}

		if (null == pid || pid.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "无此产品！";
		}
		
		User u = new User();
		u.setId(Integer.parseInt(userId));
		User user = userService.findUser(u);
		if (null == userId || null == user) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return "非法用户！";
		}
		
		Product product = publishService.getFile(pid);
		if(null != product){
			product.setId(Integer.parseInt(pid));
			return JSON.toJSONString(product);
		}else return null;
	}
	
	/**
	 * 下载时更新下载日志
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/product/update/downloadLog", method = RequestMethod.POST)
	@ResponseBody()
	public String updateDownloadLog(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Box box = loadNewBox(request);
		
		String pid = box.$p("pid");
		if(null == pid || pid.equals("")){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "无此产品！";
		}
		
		//TODO 
		return null;
	}
	
	/**
	 * 外链
	 * @param pid
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/product/link/{pid}", method = RequestMethod.GET)
	@ResponseBody()
	public ModelAndView link(@PathVariable String pid, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Box box = loadNewBox(request);
		
		String userId = box.$cv(X.USER);
		String userType = box.$cv(X.USER_TYPE);
		
		if(null == pid || pid.equals("")){
			box.setAttribute("error", "无此产品！");
			return createModelAndView("/core/product/link.jsp", box);
		}
		
		User u = new User();
		u.setId(Integer.parseInt(userId));
		User user = userService.findUser(u);
		if (null == userId || null == user) {
			box.setAttribute("error", "非法用户！");
			return createModelAndView("/core/product/link.jsp", box);
		}
		
		
		// 解码
		pid = X.decodeId(pid);
		//获取下载/外链产品的信息
		List<ProductDownload> list = publishService.getDownloadProduct(pid);

		if (null != list && list.size() > 0) {
			if (!list.get(0).getState().equals(1)) {
				box.setAttribute("error", "该产品未上架，不能下载！");
				return createModelAndView("/core/product/link.jsp", box);
			} else {
				//获取当天外链次数
				int times = publishService.getDownOrLinkTimes(userId);
				long date = (new Date()).getTime();

				// 入驻超一月用户的次数限制
				if ((date - user.getCreateTime().getTime()) > 2592000) {
					if (times > 200) {
						box.setAttribute("error", "您今天的下载或外联已达到上限！");
						return createModelAndView("/core/product/link.jsp", box);
					}
				} else if ((date - user.getCreateTime().getTime()) > 86400) {
					// 入驻在一天到一月间用户的次数限制
					if (times > 60) {
						box.setAttribute("error", "您注册未满一月，您今天的下载或外联已达到上限！");
						return createModelAndView("/core/product/link.jsp", box);
					}
				} else {
					if (times > 20) {
						box.setAttribute("error", "作为新用户，您今天的下载或外联已达到上限！");
						return createModelAndView("/core/product/link.jsp", box);
					}
				}

				// 获取产品的关联记录信息
				LogDownload downloadLog = publishService.getProductLinkInfo(
						userId, pid);
				if(downloadLog != null){
					// 修改产品外联次数
					int i = publishService.updateProductLinkTimes(downloadLog
							.getId().toString(), downloadLog.getTimes() + 1);
				}else{
					// 插入外链记录
					LogDownload o = new LogDownload();
					o.setUserId(Integer.parseInt(userId));
					o.setSupplierUserId(list.get(0).getUserId());
					o.setProductId(Integer.parseInt(pid));
					o.setPrice(list.get(0).getPrice());
					o.setTimes(1);
					o.setType(1);
					o.setCreateTime(new Date());
					o.setCreateIp(box.getPageView().getIp());
					o.setCreateMonth(Calendar.getInstance().get(Calendar.MONTH));
					o.setCreateDay(Calendar.getInstance().get(Calendar.DATE));
					
					//TODO update DB
				}

				String[] imgsArr = ImgAddressConvert.commonConvertImgUrl(list.get(0).getProductMeta().getDescriptionBin(), userId, "thumb", "taobao", "750x750", true).split("\\|\\|");
				String des = ImgAddressConvert.commonConvertImgUrl(list.get(0).getProductMeta().getDescriptionBin(), userId, "thumb", "taobao", "750x750", false);
				list.get(0).getProductMeta().setDescriptionBin(des);
				
				
				box.setAttribute("product", list.get(0));
				box.setAttribute("imgsArr", imgsArr);
				box.setAttribute("lastDownload", downloadLog != null ? downloadLog.getTimes() : 0);
				box.setAttribute("pid", pid);
				
				
				
				String json = JSON.toJSONString(list);
				
				return createModelAndView("/core/product/link.jsp", box);
			}
		} else {
			box.setAttribute("error", "系统错误！");
			return createModelAndView("/core/product/link.jsp", box);
		}
	}
}
