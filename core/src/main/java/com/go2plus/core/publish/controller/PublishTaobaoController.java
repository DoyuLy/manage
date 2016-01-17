package com.go2plus.core.publish.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.go2plus.common.json.Json;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.core.props.controller.PropsController;
import com.go2plus.core.publish.service.PublishService;
import com.go2plus.core.publish.vo.TaobaoItem;


/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 发布到淘宝跳转Controller
 * 
 * @author denglin
 * @since 2015-11-23
 */

@Controller
public class PublishTaobaoController extends BaseController {
  
  private final static Logger log = LoggerFactory.getLogger(PropsController.class);
  
  @Resource
  private PublishService publishTaobaoService;

  /**
   * 接受一个发布的请求验证是否可以发布并跳转至发布页面
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/publishTo/index")@ResponseBody()
  public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    
    log.debug("PropsController.index()");
    
    // 商品id
    String pid = request.getParameter("pid");
    // 用户id 登录健全后需要获取  todo
    String userId = "111539";
    
    System.out.print("1233333333333333" + pid);
    
    List<TaobaoItem> itemRecords = publishTaobaoService.getTaobaoItemsRecord(userId, pid);
    
    Map<String, String> retMap = new HashMap<String, String>();
    
    if(itemRecords.size() > 5){
      retMap.put("state", "2");
    }
    else if(itemRecords.size() > 0){

      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      
      try {
        Date nowTime = df.parse(df.format( new Date() ));
        Date lastPublish = df.parse(df.format( itemRecords.get(0).getPublishTime()));
        
        long diff = nowTime.getTime() - lastPublish.getTime();
        if(diff < 180000){
          retMap.put("state", "1");
        }
        else{
          retMap.put("state", "0");
        }
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    else{
      retMap.put("state", "0");
    }

    if(retMap.get("state") == "0"){
      // url 本站的地址； userid 用户id session里面可取； pid 产品id; type 用户类型 session里面可取； s 默认已取消； is_auto_wireless 用户是否存在 存在true不存在false
      // url=test.go2.cn&uid=156449&pid=oaceam&type=0&s=SERVER_SIGN&is_auto_wireless=
      String keyStr = "url=www.go2.cn&uid=" + userId + "&pid=" + pid + "&type=" + "1" + "&s=9&is_auto_wireless=";
      
      // 暂时用php端生成加密
      try{
        URL url = new URL("http://test1.ximgs.net/oauth/taobao/getUrl?subUrl=" + keyStr);
        String line;
        StringBuilder sb = new StringBuilder();
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();// 连接会话
        // 获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        // 循环读取流
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();// 关闭流
        connection.disconnect();// 断开连接
        
        System.out.println(sb.toString());
        
        retMap.put("url", "http://eapi.ximgs.net/oauth/taobao/publish?key=" + sb.toString());
        
      }catch(Exception e){
        System.out.println("failed");
      }
    }
    
    return Json.toJson(retMap);
  }
}
