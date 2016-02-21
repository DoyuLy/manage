package com.go2plus.core.common.enums;
/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-9
 * <p>Version: 1.0
 */
public enum PhotographerType {

  person("个人服务商"),business("企业服务商");

  private final String info;

  private PhotographerType(String info) {
      this.info = info;
  }

  public String getInfo() {
      return info;
  }
}
