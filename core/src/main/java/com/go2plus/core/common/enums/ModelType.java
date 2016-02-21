package com.go2plus.core.common.enums;
/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-9
 * <p>Version: 1.0
 */
public enum ModelType {

  parttime("兼职"),fulltime("全职");

  private final String info;

  private ModelType(String info) {
      this.info = info;
  }

  public String getInfo() {
      return info;
  }
}
