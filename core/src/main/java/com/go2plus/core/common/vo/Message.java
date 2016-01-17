package com.go2plus.core.common.vo;

import java.util.Date;
import java.util.List;

import com.go2plus.core.product.vo.Site;
import com.go2plus.core.userCenter.vo.InSeller2Product;
import com.go2plus.core.userCenter.vo.Supplier;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * 记录商家产品公告及商家公告
 * @author Administrator
 *
 */
public class Message {
  private Integer          id;          //表主键 
  private Integer          userId;      //商家用户ID
  private Integer          productId;   //产品ID，如果为产品公告，则会记录产品ID，商家公告时，字段为空
  private String           content;     //公告信息
  private String           type;        //产品分类，corplog为产品公告，corpnews为商家公告
  private Integer          weight;      //权重
  private Integer          state;       //表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Date             createTime;  //记录创建时间
  private Date             updateTime;  //记录最后修改时间

  private Supplier         supplier;    //关联supplier表
  
  private Site             site;        //关联site表
  private InSeller2Product inSeller2Product;  //关联ln_seller2product表

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Site getSite() {
    return site;
  }

  public void setSite(Site site) {
    this.site = site;
  }

  public InSeller2Product getInSeller2Product() {
    return inSeller2Product;
  }

  public void setInSeller2Product(InSeller2Product inSeller2Product) {
    this.inSeller2Product = inSeller2Product;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  /**
   * @return the userId
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * @param userId
   *          the userId to set
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
