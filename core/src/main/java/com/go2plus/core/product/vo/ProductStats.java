package com.go2plus.core.product.vo;

import java.util.Date;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * @category 产品下载信息统计
 * @author duyu
 * 
 */
public class ProductStats {
  private Integer id;
  private Integer productId;         // 产品ID(关联产品表)
  private Integer propsCountAlltime; // 产品属性发布时使用总量
  private Integer viewCountAlltime;  // 产品浏览总量
  private Integer downCountAlltime;  // 产品下载总量
  private Integer downCountSeason;   // 产品三日下载量
  private Integer taobaoCountAlltime; // 产品发布到淘宝总量
  private Integer taobaoCountSeason; // 三日产品发布到淘宝量
  private Date    renewTime;         // 产品被下载/发布到淘宝的最后时间
  private Integer promotionWeight;   // 一手货源广告权重，通过定时脚本刷新权重，影响广告位的显示顺序
  private Integer stPromotionWeight; // 精选广告权重，通过定时脚本刷新权重，影响广告位的显示顺序
  private Integer showcaseWeight;    // 橱窗推荐位权重，通过定时脚本刷新权重，影响广告位的显示顺序
  private Integer state;             // 表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Date    createTime;        // 记录创建时间
  private Date    updateTime;        // 记录最后修改时间
  private Integer totalperson;       // 产品下载总量 + 产品发布到淘宝总量

  public Integer getPromotionWeight() {
    return promotionWeight;
  }

  public void setPromotionWeight(Integer promotionWeight) {
    this.promotionWeight = promotionWeight;
  }

  public Integer getStPromotionWeight() {
    return stPromotionWeight;
  }

  public void setStPromotionWeight(Integer stPromotionWeight) {
    this.stPromotionWeight = stPromotionWeight;
  }

  public Integer getShowcaseWeight() {
    return showcaseWeight;
  }

  public void setShowcaseWeight(Integer showcaseWeight) {
    this.showcaseWeight = showcaseWeight;
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

  public Integer getTotalperson() {
    return totalperson;
  }

  public void setTotalperson(Integer totalperson) {
    this.totalperson = totalperson;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getPropsCountAlltime() {
    return propsCountAlltime;
  }

  public void setPropsCountAlltime(Integer propsCountAlltime) {
    this.propsCountAlltime = propsCountAlltime;
  }

  public Integer getViewCountAlltime() {
    return viewCountAlltime;
  }

  public void setViewCountAlltime(Integer viewCountAlltime) {
    this.viewCountAlltime = viewCountAlltime;
  }

  public Integer getDownCountAlltime() {
    return downCountAlltime;
  }

  public void setDownCountAlltime(Integer downCountAlltime) {
    this.downCountAlltime = downCountAlltime;
  }

  public Integer getDownCountSeason() {
    return downCountSeason;
  }

  public void setDownCountSeason(Integer downCountSeason) {
    this.downCountSeason = downCountSeason;
  }

  public Integer getTaobaoCountAlltime() {
    return taobaoCountAlltime;
  }

  public void setTaobaoCountAlltime(Integer taobaoCountAlltime) {
    this.taobaoCountAlltime = taobaoCountAlltime;
  }

  public Integer getTaobaoCountSeason() {
    return taobaoCountSeason;
  }

  public void setTaobaoCountSeason(Integer taobaoCountSeason) {
    this.taobaoCountSeason = taobaoCountSeason;
  }

  public Date getRenewTime() {
    return renewTime;
  }

  public void setRenewTime(Date renewTime) {
    this.renewTime = renewTime;
  }
}
