package com.go2plus.core.product.vo;

import java.sql.Blob;
import java.util.Date;

public class ProductMeta {
  private Integer id;
  private String  descriptionBin; // 产品详情信息，记录了产品文字描述及产品详情图片地址
  private Integer material;       // 产品材质，1为真皮，2为PU，3为混合，4为布，目前通过定时任务在产品文字描述中匹配上述材质关键字
  private String  tips;           // 产品风格标签，如明星同款、时尚潮流、日韩、欧美等，多个标签用逗号分隔，目前通过定时任务在产品文字描述中匹配上述材质关键字
  private Integer state;
  private Date    createTime;
  private Date    updateTime;
  public Blob     descriptionBlob;

  private Integer productId;

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

  public String getDescriptionBin() {
    return descriptionBin;
  }

  public void setDescriptionBin(String descriptionBin) {
    this.descriptionBin = descriptionBin;
  }

  public Integer getMaterial() {
    return material;
  }

  public void setMaterial(Integer material) {
    this.material = material;
  }

  public String getTips() {
    return tips;
  }

  public void setTips(String tips) {
    this.tips = tips;
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

  public Blob getDescriptionBlob() {
    return descriptionBlob;
  }

  public void setDescriptionBlob(Blob descriptionBlob) {
    this.descriptionBlob = descriptionBlob;
  }
}
