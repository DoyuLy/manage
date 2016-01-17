package com.go2plus.core.userCenter.vo;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * @score_category 记录商家评分分类
 * @author yuyl
 * 
 */

public class ScoreCategory {
  private Integer id;
  private String title;
  private String cid;
  private Float score;
  private Integer state;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getCid() {
    return cid;
  }
  public void setCid(String cid) {
    this.cid = cid;
  }
  public Float getScore() {
    return score;
  }
  public void setScore(Float score) {
    this.score = score;
  }
  public Integer getState() {
    return state;
  }
  public void setState(Integer state) {
    this.state = state;
  }
  
}
