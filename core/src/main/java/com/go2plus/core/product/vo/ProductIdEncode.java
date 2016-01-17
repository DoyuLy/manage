package com.go2plus.core.product.vo;

import java.util.Date;

// 产品ID字母表
public class ProductIdEncode {
  private Integer id;
  private Integer productId;
  private String  encodeId;
  private Date    createTime;

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

  public String getEncodeId() {
    return encodeId;
  }

  public void setEncodeId(String encodeId) {
    this.encodeId = encodeId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
