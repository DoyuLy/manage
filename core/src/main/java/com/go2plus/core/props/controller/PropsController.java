package com.go2plus.core.props.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
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
import org.springframework.web.servlet.ModelAndView;

import com.go2plus.common.json.Json;
import com.go2plus.common.mvc.BaseController;
import com.go2plus.core.props.service.PropsService;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import redis.clients.jedis.*;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 属性Controller, 获取各种鞋子在淘宝中的属性数据
 * 
 * @author denglin
 * @since 2015-11-13
 */

@Controller
public class PropsController extends BaseController {
  private final static Logger log = LoggerFactory.getLogger(PropsController.class);

  @Resource
  private PropsService        propsService;

  /**
   * 生成一个鞋种对应的属性下拉选框外部访问链接
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/props/index")@ResponseBody()
  public ModelAndView index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    
    log.debug("PropsController.index()");
    
    String pid = request.getParameter("pid");
    if(request.getParameter("pid") == null || request.getParameter("pid").length() <= 0){
      pid = "50012032";
    }
    try{
      // 调用接口获取淘宝数据
      String propStr = propsService.getProps(pid);
      // 将返回数据转换为json数组
      List<HashMap>  jsonArr = (List<HashMap>)Json.fromJson(propStr, List.class);
      //List<HashMap> jsonArr= (List<HashMap>)Json.fromJson((String)propStr,new TypeToken<List<HashMap>>(){}.getType());

      //JSONArray jsonArr = JSON.parseArray(propStr);
      // 需要排除的属性 如 “品牌”
      String withoutStr = "122216347,1627207,21921,1632501,20000,2234705,21541,20788,1053795,1627767,2234811,10537956,14837340,14837354,28994916,122216345,122216608,13021751,122640606,2020542,20549,122216515,122216632";
      
      String[] withoutArr = withoutStr.split(",");
      // 去除上面列出pid的数据
      for(int i =0; i< jsonArr.size(); i++){
        
        //JSONObject jo = (JSONObject)jsonArr.get(i);
        // 获取每个元素中的pid（因为gson转换后的pid成了科学计数法，要转换以下）
        Map<String, Object> jo = (Map<String, Object>)jsonArr.get(i);
        String pidaa = jo.get("pid").toString();
        Double bd = new Double(pidaa);
        
        // System.out.println(String.valueOf(bd.longValue()));
        // 比较pid判断是否需要排除
        if(Arrays.asList(withoutArr).contains(String.valueOf(bd.longValue()))){
          jsonArr.remove(i);
          i--;
        }
      }

      
      if(jsonArr.size() > 0){
        // 得到服务器文件相对位置
        String path= session.getServletContext().getRealPath("/");
        //
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File(path + "jsp\\core\\props\\"));
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
        // 
        Template template = cfg.getTemplate("props.jsp");
        
        Map<String, Object> propsMap = new HashMap<String, Object>();  

        propsMap.put("props", jsonArr);
        
        System.out.println(jsonArr);
        try {
          // 后台打印结果
          //Writer out = new OutputStreamWriter(System.out); 
          //template.process(propsMap, out);
          //out.flush();  

          // 保存到html文件到指定位置
          File fileDir = new File(path+"jsp\\common\\");
          // 不存在目录时创建一个
          org.apache.commons.io.FileUtils.forceMkdir(fileDir);  

          File output = new File(fileDir + "/propStatic_" + PropsService.idMap.get(pid) + ".html");
          //File output = new File(fileDir + "/propStatic.html");

          Writer writer = new FileWriter(output);
          
          template.process(propsMap, writer); 
          
          writer.close();  
          
        } catch (TemplateException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } 
      }
      
    }catch(Exception e){
      System.out.println("save html file failed");
      //ret =  "save html file failed";
    }

    return createModelAndView("core/props/index.jsp");
  }

  /**
   * 获取一个鞋种对应的属性的字符串，渲染成页面
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/props/props")
  public ModelAndView index1(HttpServletRequest request, HttpServletResponse response) {
    log.debug("PropsController.index()");
//
//    //return null; // 这个方法不用了
////    连接redis服务器，192.168.0.100:6379
////    jedis = new Jedis("192.168.56.101", 6379);
////    System.out.println("reids连接成功...");
////    jedis.setex("java:test", 20, "xinxin");
//    
//
//    String pid = request.getParameter("pid");
//
//    if(request.getParameter("pid") == null || request.getParameter("pid").length() <= 0){
//      pid = "50012032";
//    }
//    // 调用接口获取淘宝数据
//    String propStr = propsService.getProps(pid);
//
//    JSONArray jsonArr = JSON.parseArray(propStr);
//    
//    String withoutStr = "122216347,1627207,21921,1632501,20000,2234705,21541,20788,1053795,1627767,2234811,10537956,14837340,14837354,28994916,122216345,122216608,13021751,122640606,2020542,20549,122216515,122216632";
//    
//    String[] withoutArr = withoutStr.split(",");
//
//    // 去除上面列出pid的数据
//    for(int i =0; i< jsonArr.size(); i++){
//      
//      JSONObject jo = (JSONObject)jsonArr.get(i);
//      // System.out.println(jo.getString("pid")+"=="+jsonArr.size());
//      if(Arrays.asList(withoutArr).contains(jo.getString("pid"))){
//        jsonArr.remove(i);
//        i--;
//      }
//    }
//
//    Box box = loadNewBox(request);
//
//    box.setAttribute("props", jsonArr);
//    System.out.println(createModelAndView("core/props/props.jsp", box));
    return null;//createModelAndView("core/props/props.jsp", box);
  }
  

}
