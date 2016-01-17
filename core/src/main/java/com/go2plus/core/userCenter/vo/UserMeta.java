package com.go2plus.core.userCenter.vo;

import java.util.Date;

/**
 * 记录卖家的扩展信息
 * 
 * @author gzh
 */
public class UserMeta {
  private Integer id;
  private Integer userId;
  private String  email;
  private String  qq;
  private String  phone;
  private String  title;
  private String  shopUrl;
  private String  smsInfo;
  private Integer state;
  private Date    createTime;
  private Date    updateTime;
  private String  laddress;
  private String  iaddress;
  private String  maddress;
  private String  stores;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getShopUrl() {
    return shopUrl;
  }

  public void setShopUrl(String shopUrl) {
    this.shopUrl = shopUrl;
  }

  public String getSmsInfo() {
    return smsInfo;
  }

  public void setSmsInfo(String smsInfo) {
    this.smsInfo = smsInfo;
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

  public String getLaddress() {
    return laddress;
  }

  public void setLaddress(String laddress) {
    this.laddress = laddress;
  }

  public String getIaddress() {
    return iaddress;
  }

  public void setIaddress(String iaddress) {
    this.iaddress = iaddress;
  }

  public String getMaddress() {
    return maddress;
  }

  public void setMaddress(String maddress) {
    this.maddress = maddress;
  }

  public String getStores() {
    return stores;
  }

  public void setStores(String stores) {
    this.stores = stores;
  }

}
