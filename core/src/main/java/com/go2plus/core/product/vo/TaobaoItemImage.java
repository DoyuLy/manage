package com.go2plus.core.product.vo;

import java.util.Date;

public class TaobaoItemImage {
  private Integer id;
  private Integer productId;
  private String  itemName;   // 图片类型，indeximage为首图，indeximages为次首图
  private String  itemValue;  // 图片地址
  private Date    times;      // 被使用次数
  private Integer state;
  private Date    createTime;
  private Date    updateTime;

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

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemValue() {
    return itemValue;
  }

  public void setItemValue(String itemValue) {
    this.itemValue = itemValue;
  }

  public Date getTimes() {
    return times;
  }

  public void setTimes(Date times) {
    this.times = times;
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
}
