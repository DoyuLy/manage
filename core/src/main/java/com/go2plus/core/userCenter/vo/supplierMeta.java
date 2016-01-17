package com.go2plus.core.userCenter.vo;
/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 供货商扩展
 * SupplierMeta
 * @author liyang
 * @since 2015-12-11
 *
 */
public class supplierMeta {
  private Integer id;
  private Integer userId;
  private String nature;  //经营性质
  private String guimo; //规模
  private String setting; //发货设置
  private String recruit; //分销招募
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  public String getNature() {
    return nature;
  }
  public void setNature(String nature) {
    this.nature = nature;
  }
  public String getGuimo() {
    return guimo;
  }
  public void setGuimo(String guimo) {
    this.guimo = guimo;
  }
  public String getSetting() {
    return setting;
  }
  public void setSetting(String setting) {
    this.setting = setting;
  }
  public String getRecruit() {
    return recruit;
  }
  public void setRecruit(String recruit) {
    this.recruit = recruit;
  }
  
   
}
