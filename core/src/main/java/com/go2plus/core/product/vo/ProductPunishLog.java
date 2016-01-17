package com.go2plus.core.product.vo;

import java.util.Date;

public class ProductPunishLog {
  private Integer id;             //
  private Integer productId;      //
  private Integer referProductId; //
  private Integer operatorId;     //
  private Integer type;           //
  private String  memo;           //
  private Integer state;          //
  private Date    createTime;     //
  private Date    updateTime;     //

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

  public Integer getReferProductId() {
    return referProductId;
  }

  public void setReferProductId(Integer referProductId) {
    this.referProductId = referProductId;
  }

  public Integer getOperatorId() {
    return operatorId;
  }

  public void setOperatorId(Integer operatorId) {
    this.operatorId = operatorId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
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
