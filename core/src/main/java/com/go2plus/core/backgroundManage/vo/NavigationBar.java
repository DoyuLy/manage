package com.go2plus.core.backgroundManage.vo;

import java.util.Date;

public class NavigationBar {
  private Integer id;
  private String  area;//板块名
  private String  navigationSubdomain; // 导航栏域名
  private String  navigationName;     // 导航栏名称
  private Integer navigationWeights;  // 导航栏排序权重
  private String  content;            //备注
  private Integer state;
  private Date    createTime;
  private Date    updateTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNavigationSubdomain() {
    return navigationSubdomain;
  }

  public void setNavigationSubdomain(String navigationSubdomain) {
    this.navigationSubdomain = navigationSubdomain;
  }

  public String getNavigationName() {
    return navigationName;
  }

  public void setNavigationName(String navigationName) {
    this.navigationName = navigationName;
  }

  public Integer getNavigationWeights() {
    return navigationWeights;
  }

  public void setNavigationWeights(Integer navigationWeights) {
    this.navigationWeights = navigationWeights;
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

  public int savefirstHandConfiguration(NavigationBar navigationBar) {
    // TODO Auto-generated method stub
    return 0;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

}
