package com.go2plus.core.page.vo;

import java.util.Date;

/**
 * 
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 保存商家的商家的公司介绍及服务承诺、摄影的团队介绍及服务介绍，以及网站的资质证书、联系方式、独款说明和特色服务的说明
 * 
 * @author yuyanlin
 * @since 2015-11-03
 * 
 */

public class Page {
  private Integer id;          //表主键
  private Integer userId;      //商家/摄影的用户ID
  private String  title;       //服务承诺/公司介绍/团队介绍/服务介绍/资质证书/联系方式/独款说明/特色服务
  private String  content;     //内容（html格式）
  private Integer state;       //表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Date    createTime;  //记录创建时间
  private Date    updateTime;  //记录最后修改时间

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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
