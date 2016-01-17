package com.go2plus.core.userCenter.vo;

import java.util.Date;

import com.go2plus.core.product.vo.Product;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * SellerFavorite Vo
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */

public class SellerFavorite {
  private Integer userId;
  private Date updateTime;
  private Integer state;
  private Integer productId;
  private Integer id;
  private Date createTime;
  
  private Supplier supplier;
  private User user;
  private Product product;
  
  public Supplier getSupplier() {
    return supplier;
  }
  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }
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
  
  
}
