package com.go2plus.core.product.vo;

import java.util.Date;

public class ProductGuang {
  private Integer id;           //
  private Integer productId;    //
  private Integer categoryId;   //
  private Integer sevenDiffCou; // 七日人气变化量
  private String  title;        //
  private String  articleNumber; //
  private Double  price;        //
  private String  characters;   // 描述
  private String  props;        // 产品属性
  private Integer state;        //
  private Date    publishTime;  // 产品发布时间
  private Date    createTime;   //

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

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getSevenDiffCou() {
    return sevenDiffCou;
  }

  public void setSevenDiffCou(Integer sevenDiffCou) {
    this.sevenDiffCou = sevenDiffCou;
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
