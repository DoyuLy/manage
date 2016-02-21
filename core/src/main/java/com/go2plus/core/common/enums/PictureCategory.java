package com.go2plus.core.common.enums;
/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-9
 * <p>Version: 1.0
 */
public enum PictureCategory {
  
  primary("主图"),bags("箱包"),shoes("鞋类"),kilds("童装"),clothing("服装"),textiles("家纺"),cosmetics("化妆品"),digital("数码"),jewelry("首饰"),electrical("家电"),other("其他");

  private final String info;

  private PictureCategory(String info) {
      this.info = info;
  }

  public String getInfo() {
      return info;
  }
  
}
