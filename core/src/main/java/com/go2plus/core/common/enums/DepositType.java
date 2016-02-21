package com.go2plus.core.common.enums;
/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-9
 * <p>Version: 1.0
 */
public enum DepositType {

  apply("申请保证金"),add("追加保证金");

  private final String info;

  private DepositType(String info) {
      this.info = info;
  }

  public String getInfo() {
      return info;
  }
}
