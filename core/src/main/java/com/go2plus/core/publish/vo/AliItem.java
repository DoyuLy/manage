package com.go2plus.core.publish.vo;

import java.util.Date;


/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 卖家或代发发布到阿里的产品记录
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */
public class AliItem {
  private Integer  id;              // 表主键
  private Integer  userId;          // 卖家或代发向阿里发布产品时，记录的卖家或代发的用户ID
  private Integer  aliSellerId;     // 记录是哪一个阿里授权用户
  private Integer  productId;       // 记录发布的哪一款产品
  private Long     offerid;         // 发布到阿里的产品ID
  private String   features;        // 阿里返回的产品发布信息（未利用）
  private String   aliResourceOwner; // 阿里昵称
  private String   aliMemberId;     // 阿里用户ID
  private Integer  aliState;        // 表示发布到阿里产品的上架状态，1上架，0下架，-1已删除（因阿里没有相应接口，该功能未启用）
  private Integer  state;           // 表示该记录的状态，1为启用，0为禁用，-1为已删除
  private String   createIp;        // 用户发布到阿里时的IP
  private Integer  createDay;       // 用户发布到阿里的日期
  private Integer  createMonth;     // 用户发布到阿里的月份
  private Date     createTime;      // 记录创建时间
  private Date     updateTime;      // 记录最后修改时间



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

  public Integer getAliSellerId() {
    return aliSellerId;
  }

  public void setAliSellerId(Integer aliSellerId) {
    this.aliSellerId = aliSellerId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Long getOfferid() {
    return offerid;
  }

  public void setOfferid(Long offerid) {
    this.offerid = offerid;
  }

  public String getFeatures() {
    return features;
  }

  public void setFeatures(String features) {
    this.features = features;
  }

  public String getAliResourceOwner() {
    return aliResourceOwner;
  }

  public void setAliResourceOwner(String aliResourceOwner) {
    this.aliResourceOwner = aliResourceOwner;
  }

  public String getAliMemberId() {
    return aliMemberId;
  }

  public void setAliMemberId(String aliMemberId) {
    this.aliMemberId = aliMemberId;
  }

  public Integer getAliState() {
    return aliState;
  }

  public void setAliState(Integer aliState) {
    this.aliState = aliState;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public String getCreateIp() {
    return createIp;
  }

  public void setCreateIp(String createIp) {
    this.createIp = createIp;
  }

  public Integer getCreateDay() {
    return createDay;
  }

  public void setCreateDay(Integer createDay) {
    this.createDay = createDay;
  }

  public Integer getCreateMonth() {
    return createMonth;
  }

  public void setCreateMonth(Integer createMonth) {
    this.createMonth = createMonth;
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
