package com.go2plus.core.userCenter.vo;

import java.util.Date;

import com.go2plus.core.product.vo.Site;

public class SellerBlackList {
  private Integer  id;
  private Integer  sellerUserId;
  private Integer  supplierUserId;
  private Integer  isCustomer;
  private String   comment;
  private Integer  state;
  private Date     createTime;
  private Date     updateTime;

  private Seller   seller;
  private Supplier supplier;
  private User     user;
  private Site     site;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Site getSite() {
    return site;
  }

  public void setSite(Site site) {
    this.site = site;
  }

  public Seller getSeller() {
    return seller;
  }

  public void setSeller(Seller seller) {
    this.seller = seller;
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

  public Integer getSellerUserId() {
    return sellerUserId;
  }

  public void setSellerUserId(Integer sellerUserId) {
    this.sellerUserId = sellerUserId;
  }

  public Integer getIsCustomer() {
    return isCustomer;
  }

  public void setIsCustomer(Integer isCustomer) {
    this.isCustomer = isCustomer;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  public Integer getSupplierUserId() {
    return supplierUserId;
  }

  public void setSupplierUserId(Integer supplierUserId) {
    this.supplierUserId = supplierUserId;
  }

}
