package com.go2plus.core.userCenter.vo;

import java.util.Date;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * @supplie_credit_new 记录商家排名的加分及扣分明细
 * @author yuyl
 * 
 */

public class SupplierCreditNew {  
  private Integer id;
  private Integer userId;
  private Integer type;        //分数类型ID 关联score_category表cid
  private String comment;      //分数类型名称
  private Integer unit;        //单位数量
  private Float score;         //分数每单位
  private Integer operatorId;  //操作管理员ID
  private Integer createDay;   //创建日期
  private Date createTime;
  private Date updateTime;
  private Long totalScore; //统计分数
  
  
  public Long getTotalScore() {
    return totalScore;
  }
  public void setTotalScore(Long totalScore) {
    this.totalScore = totalScore;
  }
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
  public Integer getType() {
    return type;
  }
  public void setType(Integer type) {
    this.type = type;
  }
  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }
  public Integer getUnit() {
    return unit;
  }
  public void setUnit(Integer unit) {
    this.unit = unit;
  }
  public Float getScore() {
    return score;
  }
  public void setScore(Float score) {
    this.score = score;
  }
  public Integer getOperatorId() {
    return operatorId;
  }
  public void setOperatorId(Integer operatorId) {
    this.operatorId = operatorId;
  }
  public Integer getCreateDay() {
    return createDay;
  }
  public void setCreateDay(Integer createDay) {
    this.createDay = createDay;
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
