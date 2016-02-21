package com.go2plus.core.common.enums;
/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-9
 * <p>Version: 1.0
 */
public enum UserStatus {

  normal("正常状态"), blocked("封禁状态");

  private final String info;

  private UserStatus(String info) {
      this.info = info;
  }

  public String getInfo() {
      return info;
  }
}
