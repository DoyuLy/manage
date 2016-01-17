package com.go2plus.core.userCenter.vo;

import java.util.Date;
import java.util.List;

import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.Site;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * Supplier Dao
 * 
 * 记录快递服务商信息, 并做为代发系统的快递信息表的原始表（代发系统的快递信息表会定时从这张表同步数据更新自己）
 * 
 * @author yuyanlin
 * @since 2015-11-03
 */
public class Supplier {
  private Integer       id;               // 表主键
  private Integer       userId;           // 商家用户ID
  private Integer       marketId;         // 所属市场ID
  private Integer       siteId;           // 商家网站子域名ID
  private String        title;            // 商家名称
  private String        brand;            // 商家品牌名称
  private String        contact;          // 联系人
  private String        capital;          // 商家名称首字母
  private String        address;          // 商家地址
  private String        qqun;             // （未使用）
  private String        qq;               // 商家QQ
  private String        phone;            // 商家备用联系电话
  private String        avatar;           // 商家认证的身份证照
  private String        cardNumber;       // 商家认证的身份证号码
  private String        cardMid;          // 身份证哈希码
  private Integer       isPrint;          // 商家门牌是否已打印，1为是，0为否
  private Integer       isHideStats;      // 是否隐藏商家产品详情页的人气数据，1为是，0为否
  private Integer       isAudit;          // 是否已审核，1为是，0为否（已弃用）
  private Integer       isManufacturer;   // 是否为生产厂家，1为是，0为否
  private Integer       certifiedType;    // 商家认证等级，0为未认证，1为初级认证（现已弃用，只有老用户有一部分为初级认证），2为高级认证
  private String        recheck;          // （未启用）
  private Integer       membershipType;   // 认证类型，1为保证金认证，2为服务费认证
  private Date          serviceCreateTime; // 高级认证处理时间
  private Date          serviceStartTime; // 服务费认证的认证期开始时间
  private Date          serviceEndTime;   // 服务费认证的认证期结束时间
  private Integer       weight;           // 权重
  private Integer       haveStrength;     // （未启用）
  private Integer       state;            // 表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Date          certifiedTime;    // （未启用）
  private Date          createTime;       // 记录创建时间
  private Date          updateTime;       // 记录最后修改时间

  private User          user;
  private SupplierRank  supplierRank;
  private List<Product> products;
  private SupplierStats supplierStats;
  private Site          site;

  private Integer       num;

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public Site getSite() {
    return site;
  }

  public void setSite(Site site) {
    this.site = site;
  }

  public SupplierStats getSupplierStats() {
    return supplierStats;
  }

  public void setSupplierStats(SupplierStats supplierStats) {
    this.supplierStats = supplierStats;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public SupplierRank getSupplierRank() {
    return supplierRank;
  }

  public void setSupplierRank(SupplierRank supplierRank) {
    this.supplierRank = supplierRank;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  public Integer getMarketId() {
    return marketId;
  }

  public void setMarketId(Integer marketId) {
    this.marketId = marketId;
  }

  public Integer getSiteId() {
    return siteId;
  }

  public void setSiteId(Integer siteId) {
    this.siteId = siteId;
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

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getQqun() {
    return qqun;
  }

  public void setQqun(String qqun) {
    this.qqun = qqun;
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

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
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

  public Integer getIsPrint() {
    return isPrint;
  }

  public void setIsPrint(Integer isPrint) {
    this.isPrint = isPrint;
  }

  public Integer getIsAudit() {
    return isAudit;
  }

  public void setIsAudit(Integer isAudit) {
    this.isAudit = isAudit;
  }

  public Integer getCertifiedType() {
    return certifiedType;
  }

  public void setCertifiedType(Integer certifiedType) {
    this.certifiedType = certifiedType;
  }

  public String getRecheck() {
    return recheck;
  }

  public void setRecheck(String recheck) {
    this.recheck = recheck;
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

  public Date getServiceStartTime() {
    return serviceStartTime;
  }

  public void setServiceStartTime(Date serviceStartTime) {
    this.serviceStartTime = serviceStartTime;
  }

  public Date getServiceEndTime() {
    return serviceEndTime;
  }

  public void setServiceEndTime(Date serviceEndTime) {
    this.serviceEndTime = serviceEndTime;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Date getCertifiedTime() {
    return certifiedTime;
  }

  public void setCertifiedTime(Date certifiedTime) {
    this.certifiedTime = certifiedTime;
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

  public Integer getHaveStrength() {
    return haveStrength;
  }

  public void setHaveStrength(Integer haveStrength) {
    this.haveStrength = haveStrength;
  }

  public Integer getIsManufacturer() {
    return isManufacturer;
  }

  public void setIsManufacturer(Integer isManufacturer) {
    this.isManufacturer = isManufacturer;
  }

  public Integer getIsHideStats() {
    return isHideStats;
  }

  public void setIsHideStats(Integer isHideStats) {
    this.isHideStats = isHideStats;
  }
  
  public Integer settledIn() {
    Long divisor = 1000*86400*30L;
    Double d = Math.floor( (new Date().getTime() - createTime.getTime())/divisor );

    return d.intValue();
  }

}
