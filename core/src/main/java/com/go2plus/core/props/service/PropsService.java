package com.go2plus.core.props.service;

import java.util.HashMap;

public interface PropsService {
  
  /**
   * 从聚石塔获取属性的json串
   * @param pid
   * @return String
   */
  public String getProps(String pid); 
  
  /**
   * 将生成的属性选择框存为静态页面的字符串
   * @param pid
   * @return String
   */
  public String savePropHtml(String pid);

  public final static HashMap idMap = new HashMap(){{
      put("50012032","c1");
      put("50012033","c2");
      put("50012028","c3");
      put("50012825","c4");
      put("50012042","c5");
    }};
 
}