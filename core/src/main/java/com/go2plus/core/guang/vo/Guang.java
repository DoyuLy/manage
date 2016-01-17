package com.go2plus.core.guang.vo;

import java.util.Date;

import com.go2plus.core.product.vo.Product;
/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * @category 逛逛对象 
 * @author liyang
 * 
 */
public class Guang {
  private Integer id;//主键
  private Integer categoryId;// 产品分类ID(关联category表)
  private Integer productId;
  private Integer sevenDiffCount;//七日人气变化量
  private String title;
  private String articleNumber;
  private Double price;//价格
  private String characters;//描述
  private String props;//产品属性
  private Integer state;//状态，默认等于1
  private Date publishTime;//发布时间
  private Date createTime;
  
  private Integer num;//
  
  //产品
  private Product product;
  
  //
  private String name;
  
  private String face;
  
  private String downCountAlltime;//下载次数
  
  private String content;//描述
  
  private String order;//排序
  
  private Integer page;//第几页
  
  private String renewTime;
  
  private boolean isLike;//是否已喜欢
  
  private Integer likeNum;//喜欢总量
  
  
  
  
  
  public boolean getisLike() {
    return isLike;
  }
  public void setLike(boolean isLike) {
    this.isLike = isLike;
  }
  public Integer getLikeNum() {
    return likeNum;
  }
  public void setLikeNum(Integer likeNum) {
    this.likeNum = likeNum;
  }
  public String getRenewTime() {
    return renewTime;
  }
  public void setRenewTime(String renewTime) {
    this.renewTime = renewTime;
  }
  public Integer getPage() {
    return page;
  }
  public void setPage(Integer page) {
    this.page = page;
  }
  public String getOrder() {
    return order;
  }
  public void setOrder(String order) {
    this.order = order;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getFace() {
    return face;
  }
  public void setFace(String face) {
    this.face = face;
  }
  public String getDownCountAlltime() {
    return downCountAlltime;
  }
  public void setDownCountAlltime(String downCountAlltime) {
    this.downCountAlltime = downCountAlltime;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Integer getId() {
    return id;
  }
  public Integer getNum() {
    return num;
  }
  public void setNum(Integer num) {
    this.num = num;
  }
  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }
  public Integer getProductId() {
    return productId;
  }
  public void setProductId(Integer productId) {
    this.productId = productId;
  }
  public Integer getSevenDiffCount() {
    return sevenDiffCount;
  }
  public void setSevenDiffCount(Integer sevenDiffCount) {
    this.sevenDiffCount = sevenDiffCount;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getArticleNumber() {
    return articleNumber;
  }
  public void setArticleNumber(String articleNumber) {
    this.articleNumber = articleNumber;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  public String getCharacters() {
    return characters;
  }
  public void setCharacters(String characters) {
    this.characters = characters;
  }
  public String getProps() {
    return props;
  }
  public void setProps(String props) {
    this.props = props;
  }
  public Integer getState() {
    return state;
  }
  public void setState(Integer state) {
    this.state = state;
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
}
