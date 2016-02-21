package com.go2plus.core.common.enums;
/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-18
 * <p>Version: 1.0
 */
public enum AdsiteOrderStatus {

  s00("初始化"), s10("有效"),s14("过期"),s88("失效");
  
  private final String info;

  private AdsiteOrderStatus(String info) {
      this.info = info;
  }

  public String getInfo() {
      return info;
  }
}
