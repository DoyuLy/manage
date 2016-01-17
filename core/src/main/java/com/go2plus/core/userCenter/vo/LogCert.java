package com.go2plus.core.userCenter.vo;

import java.util.Date;

import com.mysql.jdbc.Blob;

public class LogCert {
  private Integer id;                // 表主键
  private Integer userId;            // 商家用户ID
  private String  title;             // 商家名称
  private String  brand;             // 商家品牌名称
  private Integer certifiedType;     // 认证等级
  private String  cardNumber;        // 身份证号
  private String  cardMid;           // 身份证hash哈希码
  private String  avatar;            // 身份证照片
  private String  marketTitle;       // 商家所属市场名称
  private String  address;           // 商家地址
  private Integer supplierState;     // 商家状态
  private String  operatorTitle;     // 操作员真实姓名
  private Blob    comment;           // 备注
  private Integer membershipType;    // 商家认证分类，1为保证金商家，2为服务费商家
  private Date    serviceCreateTime; // 开通高级认证时间
  private Date    serviceStartDate;  // 服务费开始时间

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getCertifiedType() {
    return certifiedType;
  }

  public void setCertifiedType(Integer certifiedType) {
    this.certifiedType = certifiedType;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardMid() {
    return cardMid;
  }

  public void setCardMid(String cardMid) {
    this.cardMid = cardMid;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getMarketTitle() {
    return marketTitle;
  }

  public void setMarketTitle(String marketTitle) {
    this.marketTitle = marketTitle;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getSupplierState() {
    return supplierState;
  }

  public void setSupplierState(Integer supplierState) {
    this.supplierState = supplierState;
  }

  public String getOperatorTitle() {
    return operatorTitle;
  }

  public void setOperatorTitle(String operatorTitle) {
    this.operatorTitle = operatorTitle;
  }

  public Blob getComment() {
    return comment;
  }

  public void setComment(Blob comment) {
    this.comment = comment;
  }

  public Integer getMembershipType() {
    return membershipType;
  }

  public void setMembershipType(Integer membershipType) {
    this.membershipType = membershipType;
  }

  public Date getServiceCreateTime() {
    return serviceCreateTime;
  }

  public void setServiceCreateTime(Date serviceCreateTime) {
    this.serviceCreateTime = serviceCreateTime;
  }

  public Date getServiceStartDate() {
    return serviceStartDate;
  }

  public void setServiceStartDate(Date serviceStartDate) {
    this.serviceStartDate = serviceStartDate;
  }

  public Date getServiceEndDate() {
    return serviceEndDate;
  }

  public void setServiceEndDate(Date serviceEndDate) {
    this.serviceEndDate = serviceEndDate;
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

  private Date    serviceEndDate; // 服务费结束时间
  private Integer state;          // 表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Date    createTime;     // 记录创建时间
  private Date    updateTime;     // 记录最后修改时间

}
