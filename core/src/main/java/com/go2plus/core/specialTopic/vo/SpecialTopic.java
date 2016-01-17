package com.go2plus.core.specialTopic.vo;

import java.util.Date;

public class SpecialTopic {
  private Integer id;
  private String  title;          // 专题标题
  private String  backgroundImage; // 专题背景图
  private String  specialComment; // 专题描述
  private Date    signupStarttime; // 专题报名开始时间
  private Date    signupEndtime;  // 专题报名结束时间
  private Date    TopicStartTime; // 专题开始时间
  private Date    TopicEndTime;   // 专题结束时间
  private Date    state;
  private Date    createTime;
  private Date    updateTime;

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

  public String getBackgroundImage() {
    return backgroundImage;
  }

  public void setBackgroundImage(String backgroundImage) {
    this.backgroundImage = backgroundImage;
  }

  public String getSpecialComment() {
    return specialComment;
  }

  public void setSpecialComment(String specialComment) {
    this.specialComment = specialComment;
  }

  public Date getSignupStarttime() {
    return signupStarttime;
  }

  public void setSignupStarttime(Date signupStarttime) {
    this.signupStarttime = signupStarttime;
  }

  public Date getSignupEndtime() {
    return signupEndtime;
  }

  public void setSignupEndtime(Date signupEndtime) {
    this.signupEndtime = signupEndtime;
  }

  public Date getState() {
    return state;
  }

  public void setState(Date state) {
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

  public Date getTopicStartTime() {
    return TopicStartTime;
  }

  public void setTopicStartTime(Date topicStartTime) {
    TopicStartTime = topicStartTime;
  }

  public Date getTopicEndTime() {
    return TopicEndTime;
  }

  public void setTopicEndTime(Date topicEndTime) {
    TopicEndTime = topicEndTime;
  }
}
