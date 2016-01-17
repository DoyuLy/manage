
package com.go2plus.core.props.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.go2plus.core.props.service.PropsService;

@Service
public class PropsServiceImpl implements PropsService {

  /**
   * 从聚石塔获取属性的json串
   * @param pid
   * @return String
   */
  public String getProps(String pid) {
    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder();
    try{
      URL url = new URL("http://eapi.ximgs.net/oauth/taobao/getProps/" + pid);
      String line;

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.connect();// 连接会话
      // 获取输入流
      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      
      while ((line = br.readLine()) != null) {// 循环读取流
          sb.append(line);
      }
      br.close();// 关闭流
      connection.disconnect();// 断开连接
      
      System.out.println(sb.toString());
      
    }catch(Exception e){
      System.out.println("failed");
    }
    
    return sb.toString();
  }

  /**
   * 将生成的属性选择框存为静态页面的字符串
   * @param pid
   * @return String
   */
  @Override
  public String savePropHtml(String pid) {
    // TODO Auto-generated method stub
    // 添加一个字符编码声明在前面 不然加载静态页面会有中文乱码
    StringBuilder sb = new StringBuilder();
    try{
      
      URL url = new URL("http://localhost:8080/props/props?pid=" + pid);
      String line;
      sb.append("<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>");
      
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.connect();   // 连接会话
      // 获取输入流
      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      
      // 循环读取流
      while ((line = br.readLine()) != null) {
          sb.append(line);
      }
      
      br.close();   // 关闭流
      connection.disconnect();  // 断开连接
     
    }catch(Exception e){
      System.out.println(e);
    }
    return sb.toString();
  }
}