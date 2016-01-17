package com.go2plus.core.publish.vo;

import java.util.Date;

import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.Site;
import com.go2plus.core.userCenter.vo.SellerBlackList;
import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.User;
import com.go2plus.core.userCenter.vo.UserMeta;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 记录卖家产品下载/外联信息
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

public class LogDownload {

  private Integer         userId;            // 卖家/代发用户ID--关联user表id
  private Date            updateTime;        // 记录最后修改时间
  private Integer         type;              // 操作类型，0为下载，1为外联
  private Integer         times;             // 卖家/代发对该产品的下载/外联次数
  private Integer         supplierUserId;    // 商家用户ID--关联user表id
  private Integer         state;             // 表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Integer         productId;         // 产品ID--关联product表id
  private Double          price;             // 产品价格
  private Integer         oldProductId;      // (未启用)
  private Integer         id;                // 表主键
  private Date            createTime;        // 记录创建时间
  private Integer         createMonth;       // 下载月份
  private String          createIp;          // 下载/外联时的卖家/代发IP
  private Integer         createDay;         // 下载日期

  private Supplier        supplier;          // 关联supplier表
  private User            user;              // 关联user表
  private UserMeta        userMeta;          // 关联userMeta表
  private Product         product;           // 关联product表
  private Site            site;              // 关联site表
  private SellerBlackList sellerBlackList;   // 关联黑名单
  // 淘宝卖家下载产品
  private int             downloadProductNum; // 卖家下载的产品个数

  public Site getSite() {
    return site;
  }

  public void setSite(Site site) {
    this.site = site;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getTimes() {
    return times;
  }

  public void setTimes(Integer times) {
    this.times = times;
  }

  public Integer getSupplierUserId() {
    return supplierUserId;
  }

  public void setSupplierUserId(Integer supplierUserId) {
    this.supplierUserId = supplierUserId;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getOldProductId() {
    return oldProductId;
  }

  public void setOldProductId(Integer oldProductId) {
    this.oldProductId = oldProductId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getCreateMonth() {
    return createMonth;
  }

  public void setCreateMonth(Integer createMonth) {
    this.createMonth = createMonth;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getDownloadProductNum() {
    return downloadProductNum;
  }

  public void setDownloadProductNum(int downloadProductNum) {
    this.downloadProductNum = downloadProductNum;
  }

  public SellerBlackList getSellerBlackList() {
    return sellerBlackList;
  }

  public void setSellerBlackList(SellerBlackList sellerBlackList) {
    this.sellerBlackList = sellerBlackList;
  }

  public UserMeta getUserMeta() {
    return userMeta;
  }

  public void setUserMeta(UserMeta userMeta) {
    this.userMeta = userMeta;
  }

}
