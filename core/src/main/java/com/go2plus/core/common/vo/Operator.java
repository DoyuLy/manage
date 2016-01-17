package com.go2plus.core.common.vo;

import java.util.Date;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * @operator 记录网站管理后台管理员账户信息
 * @author yuyl
 * 
 */

public class Operator {
  
  private Integer id;             
  private String username;
  private String password;
  private String super_password;  //前台超级密码
  private String title;           //管理员真实姓名
  private Integer role;           //管理员类型, 1为超级管理员，2为管理员
  private String permission;      //管理员各模块操作权限
  private String mobile;          
  private String qq;
  private Integer state;          //表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Date createTime;
  private Date updateTime;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getSuper_password() {
    return super_password;
  }
  public void setSuper_password(String super_password) {
    this.super_password = super_password;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Integer getRole() {
    return role;
  }
  public void setRole(Integer role) {
    this.role = role;
  }
  public String getPermission() {
    return permission;
  }
  public void setPermission(String permission) {
    this.permission = permission;
  }
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }
  public String getQq() {
    return qq;
  }
  public void setQq(String qq) {
    this.qq = qq;
  }
  public Integer getState() {
    return state;
  }
  public void setState(Integer state) {
    this.state = state;
  }
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
  public Date getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  } 
  
}
