package com.go2plus.core.specialTopic.vo;

import java.util.Date;

public class SpecialNew {
  private Integer id;
  private String  title;//专题名称
  private String  banner;//专题活动图片，展示在商家管理后台，专题活动列表页面
  private String  info;//专题规则
  private String  template;//专题活动首页模板代码
  private Integer discount;//
  private Integer clearance;//
  private Date    enrollStartTime;//报名开始时间
  private Date    enrollEndTime;//报名开始时间
  private Date    startTime;//专题活动开始时间
  private Date    endTime;//专题活动结束时间
  private Integer state;
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

  public String getBanner() {
    return banner;
  }

  public void setBanner(String banner) {
    this.banner = banner;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  public Integer getClearance() {
    return clearance;
  }

  public void setClearance(Integer clearance) {
    this.clearance = clearance;
  }

  public Date getEnrollStartTime() {
    return enrollStartTime;
  }

  public void setEnrollStartTime(Date enrollStartTime) {
    this.enrollStartTime = enrollStartTime;
  }

  public Date getEnrollEndTime() {
    return enrollEndTime;
  }

  public void setEnrollEndTime(Date enrollEndTime) {
    this.enrollEndTime = enrollEndTime;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
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
