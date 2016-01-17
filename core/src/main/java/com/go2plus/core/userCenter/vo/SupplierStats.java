package com.go2plus.core.userCenter.vo;

import java.util.Date;

import com.mysql.jdbc.Blob;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * SupplierStats Dao
 * 
 * 记录商家各项统计信息，由服务器定时任务进行统计后，写入数据表
 * 
 * @author yuyanlin
 * @since 2015-11-11
 *
 */
public class SupplierStats {
  private Integer id;
  private Integer userId;
  private Integer productCount;
  private Integer userCount;
  private Integer taobaoUserCount;
  private Integer viewCount;
  private Integer highlightLimit;
  private Integer showcaseLimit;
  private Integer showcaseCount;
  private Integer loginCount;
  private Integer recommandWeight;
  private String recentProducts;
  private Blob ext1;
  private Integer state;
  private Date createTime;
  private Date updateTime;
  
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
  public Integer getProductCount() {
    return productCount;
  }
  public void setProductCount(Integer productCount) {
    this.productCount = productCount;
  }
  public Integer getUserCount() {
    return userCount;
  }
  public void setUserCount(Integer userCount) {
    this.userCount = userCount;
  }
  public Integer getTaobaoUserCount() {
    return taobaoUserCount;
  }
  public void setTaobaoUserCount(Integer taobaoUserCount) {
    this.taobaoUserCount = taobaoUserCount;
  }
  public Integer getViewCount() {
    return viewCount;
  }
  public void setViewCount(Integer viewCount) {
    this.viewCount = viewCount;
  }
  public Integer getHighlightLimit() {
    return highlightLimit;
  }
  public void setHighlightLimit(Integer highlightLimit) {
    this.highlightLimit = highlightLimit;
  }
  public Integer getShowcaseLimit() {
    return showcaseLimit;
  }
  public void setShowcaseLimit(Integer showcaseLimit) {
    this.showcaseLimit = showcaseLimit;
  }
  public Integer getShowcaseCount() {
    return showcaseCount;
  }
  public void setShowcaseCount(Integer showcaseCount) {
    this.showcaseCount = showcaseCount;
  }
  public Integer getLoginCount() {
    return loginCount;
  }
  public void setLoginCount(Integer loginCount) {
    this.loginCount = loginCount;
  }
  public Integer getRecommandWeight() {
    return recommandWeight;
  }
  public void setRecommandWeight(Integer recommandWeight) {
    this.recommandWeight = recommandWeight;
  }
  public String getRecentProducts() {
    return recentProducts;
  }
  public void setRecentProducts(String recentProducts) {
    this.recentProducts = recentProducts;
  }
  public Blob getExt1() {
    return ext1;
  }
  public void setExt1(Blob ext1) {
    this.ext1 = ext1;
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
