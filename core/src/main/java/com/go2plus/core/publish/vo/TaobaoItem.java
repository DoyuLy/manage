package com.go2plus.core.publish.vo;

import java.util.Date;

import com.go2plus.core.product.vo.Product;
import com.go2plus.core.userCenter.vo.Seller;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.User;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 记录卖家发布到淘宝的商品信息
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

public class TaobaoItem {
  private Integer  id;
  private Integer  userId;        // 卖家用户ID
  private Integer  sellerId;      // 卖家ID
  private Integer  supplierUserId; // 卖家发布到淘宝商品的商家用户ID
  private Integer  productId;     // 商品ID
  private Integer  oldProductId;  // （未启用）
  private Double   price;         // 发布到淘宝的零售价
  private Long     numIid;        // 淘宝商品IID
  private String   taobaoNick;    // 卖家淘宝昵称
  private Integer  taobaoState;   // 发布到淘宝商品的状态，1为上架中，0为已下架，-1为已删除
  private Integer  checkState;    // 检查状态（未启用）
  private Date     lastCheckTime; // 最后检查时间（未启用）
  private Integer  state;         // 发布状态（未启用）
  private Integer  wlState;       //
  private Integer  publishState;  // 发布状态（未启用）
  private Date     publishTime;   // 发布时间（未启用）
  private Date     createTime;
  private String   createIp;
  private Integer  createMonth;
  private Integer  createDay;
  private Date     updateTime;

  private User     user;          // 关联user表
  private Product  product;       // 关联product表
  private Supplier supplier;      // 关联supplier
  private Seller   seller;        // 关联seller表

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
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

  public Integer getSellerId() {
    return sellerId;
  }

  public void setSellerId(Integer sellerId) {
    this.sellerId = sellerId;
  }

  public Integer getSupplierUserId() {
    return supplierUserId;
  }

  public void setSupplierUserId(Integer supplierUserId) {
    this.supplierUserId = supplierUserId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getOldProductId() {
    return oldProductId;
  }

  public void setOldProductId(Integer oldProductId) {
    this.oldProductId = oldProductId;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public long getNumIid() {
    return numIid;
  }

  public void setNumIid(long numIid) {
    this.numIid = numIid;
  }

  public String getTaobaoNick() {
    return taobaoNick;
  }

  public void setTaobaoNick(String taobaoNick) {
    this.taobaoNick = taobaoNick;
  }

  public Integer getTaobaoState() {
    return taobaoState;
  }

  public void setTaobaoState(Integer taobaoState) {
    this.taobaoState = taobaoState;
  }

  public Integer getCheckState() {
    return checkState;
  }

  public void setCheckState(Integer checkState) {
    this.checkState = checkState;
  }

  public Date getLastCheckTime() {
    return lastCheckTime;
  }

  public void setLastCheckTime(Date lastCheckTime) {
    this.lastCheckTime = lastCheckTime;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Integer getWlState() {
    return wlState;
  }

  public void setWlState(Integer wlState) {
    this.wlState = wlState;
  }

  public Integer getPublishState() {
    return publishState;
  }

  public void setPublishState(Integer publishState) {
    this.publishState = publishState;
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCreateIp() {
    return createIp;
  }

  public void setCreateIp(String createIp) {
    this.createIp = createIp;
  }

  public Integer getCreateMonth() {
    return createMonth;
  }

  public void setCreateMonth(Integer createMonth) {
    this.createMonth = createMonth;
  }

  public Integer getCreateDay() {
    return createDay;
  }

  public void setCreateDay(Integer createDay) {
    this.createDay = createDay;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Seller getSeller() {
    return seller;
  }

  public void setSeller(Seller seller) {
    this.seller = seller;
  }

}
