package com.go2plus.core.product.vo;

import java.util.Date;

import com.go2plus.core.userCenter.vo.Supplier;
import com.go2plus.core.userCenter.vo.User;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * 
 * @category 产品列表
 * @author duyu
 * 
 */
public class Product {
  private Integer          id;
  private Integer          userId;                // 商家用户ID(关联user表)
  private Integer          categoryId;            // 产品分类ID(关联category表)
  private String           articleNumber;         // 产品货号（同一商家货号不能相同）
  private String           title;                 // 标题（未启用）
  private String           characters;            // 产品描述
  private String           summary;               // 简介（未启用）
  private Integer          labelId;               // 产品首图标签ID(关联product_label表)
  private String           color;                 // 产品颜色，多个颜色用逗号分隔
  private String           size;                  // 产品尺码，多个尺码用逗号分隔
  private String           indexImage;            // 产品首图地址, 客服产品发布时指定的产品首图
  private String           supplierIndexImage;    // 商家指定的产品首图地址（优先index_image）
  private String           sellerIndexImage;      // 卖家指定的产品首图地址（未启用）
  private String           indexImages;           // 保存产品详情页五张首图的后四张图片地址(未启用)
  private Double           price;                 // 产品价格
  private Double           minSalePrice;          // 最低零售价，卖家发布到淘宝时，如果设置的零售价低于此价格，则无法发布
  private String           file;                  // 产品图片压缩包服务器保存地址
  private String           fileInfo;              // JSON格式的产品图片压缩包文件信息，包括所在服务器、md5码、大小、创建时间、检查时间
  private String           description;           // 产品详情信息（未启用）
  private String           props;                 // 产品属性(使用淘宝的产品属性代码)
  private String           keyword;
  private Integer          propsinit;             // 卖家发布到淘宝时，产品属性被使用的次数
  private Integer          lockProps;             // 锁定属性(未启用)
  private Date             checkPropsTime;        // 产品属性检查时间
  private Date             modifyTime;            // 商家修改产品表相关信息时的修改时间
  private Integer          referProductId;        // 被盗图仿款方的产品ID
  private Integer          cameramanUserId;       // 摄影商家用户ID(未启用)
  private String           cameramanTitle;        // 摄影商家名称(未启用)
  private Integer          isBlock;               // 是否锁定不显示，0为否，1为是(一般该产品为盗图仿款时会被锁定，前台不会显示该产品)
  private Date             blockTime;             // 锁定时间
  private Integer          isLightningConsignment; // 是否支持闪电发货(未启用)
  private Integer          isShowcase;            // 是否为橱窗推荐的产品，1为是，0为否
  private Integer          isUnique;              // 是否为独款，1为是，0为否，-1为由独款取消为未非独款的产品
  private Integer          isHighlight;           // 优先显示在产品下载页面下方产品展示位，最多只能设置5款产品，1为是，2为否
  private Integer          isHideStats;           // 是否隐藏人气信息，设置隐藏后，产品详情页将不显示下载和发布到淘宝的数量统计，1为是，0为否
  private Integer          isShowComment;         // 是否显示淘宝产品评论(未启用)
  private Integer          isDirectSale;          // 是否为厂家直销，1为是，0为否
  private Integer          weight;                // 产品权重，影响商家首页的产品排序
  private Integer          state;                 // 表示该记录的状态，1为启用，0为禁用，-1为已删除
  private Integer          uniqueState;           // 是否在前台显示独款产品，1为显示，0为隐藏
  private Date             uniqueStartTime;       // 产品设置为独款的时间
  private Date             uniqueEndTime;         // 产品取消独款的时间
  private Date             createTime;            // 记录创建时间
  private Date             updateTime;            // 记录最后修改时间

  // 自定义变量
  private Category         category;              // 关联不产品分类表
  private ProductStats     productStats;          // 关联产品统计表
  private Supplier         supplier;              // 关联厂家表
  private ProductMeta      productMeta;           // 记录产品的扩展信息
  private ProductLabel     productLabel;          // 记录产品的扩展信息
  private ProductComment   productComment;
  private ProductGuang     productGuang;
  private ProductIdEncode  productIdEncode;
  private ProductPunishLog productPunishLog;
  private ProductSearch2   productSearch2;
  private ProductTuan      productTuan;
  private int              categoryNum;           // 产品品类数
  private int              isTail;                // 是否是尾货
  private int              downCountAlltime;      // 下载次数
  private int              taobaoCountAlltime;    //
  private String           supplierTitle;

  private int              productSizeShow;       // 是否显示尺码,尺码为8,9,11,12,14,16,17的，不显示尺码

  public String getSupplierTitle() {
    return supplierTitle;
  }

  public void setSupplierTitle(String supplierTitle) {
    this.supplierTitle = supplierTitle;
  }

  public int getTaobaoCountAlltime() {
    return taobaoCountAlltime;
  }

  public void setTaobaoCountAlltime(int taobaoCountAlltime) {
    this.taobaoCountAlltime = taobaoCountAlltime;
  }

  public int getDownCountAlltime() {
    return downCountAlltime;
  }

  public void setDownCountAlltime(int downCountAlltime) {
    this.downCountAlltime = downCountAlltime;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public ProductStats getProductStats() {
    return productStats;
  }

  public void setProductStats(ProductStats productStats) {
    this.productStats = productStats;
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

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getArticleNumber() {
    return articleNumber;
  }

  public void setArticleNumber(String articleNumber) {
    this.articleNumber = articleNumber;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCharacters() {
    return characters;
  }

  public void setCharacters(String characters) {
    this.characters = characters;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Integer getLabelId() {
    return labelId;
  }

  public void setLabelId(Integer labelId) {
    this.labelId = labelId;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getIndexImage() {
    return indexImage;
  }

  public void setIndexImage(String indexImage) {
    this.indexImage = indexImage;
  }

  public String getSupplierIndexImage() {
    return supplierIndexImage;
  }

  public void setSupplierIndexImage(String supplierIndexImage) {
    this.supplierIndexImage = supplierIndexImage;
  }

  public String getSellerIndexImage() {
    return sellerIndexImage;
  }

  public void setSellerIndexImage(String sellerIndexImage) {
    this.sellerIndexImage = sellerIndexImage;
  }

  public String getIndexImages() {
    return indexImages;
  }

  public void setIndexImages(String indexImages) {
    this.indexImages = indexImages;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getMinSalePrice() {
    return minSalePrice;
  }

  public void setMinSalePrice(Double minSalePrice) {
    this.minSalePrice = minSalePrice;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getFileInfo() {
    return fileInfo;
  }

  public void setFileInfo(String fileInfo) {
    this.fileInfo = fileInfo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProps() {
    return props;
  }

  public void setProps(String props) {
    this.props = props;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public Integer getPropsinit() {
    return propsinit;
  }

  public void setPropsinit(Integer propsinit) {
    this.propsinit = propsinit;
  }

  public Integer getLockProps() {
    return lockProps;
  }

  public void setLockProps(Integer lockProps) {
    this.lockProps = lockProps;
  }

  public Date getCheckPropsTime() {
    return checkPropsTime;
  }

  public void setCheckPropsTime(Date checkPropsTime) {
    this.checkPropsTime = checkPropsTime;
  }

  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public Integer getReferProductId() {
    return referProductId;
  }

  public void setReferProductId(Integer referProductId) {
    this.referProductId = referProductId;
  }

  public Integer getCameramanUserId() {
    return cameramanUserId;
  }

  public void setCameramanUserId(Integer cameramanUserId) {
    this.cameramanUserId = cameramanUserId;
  }

  public String getCameramanTitle() {
    return cameramanTitle;
  }

  public void setCameramanTitle(String cameramanTitle) {
    this.cameramanTitle = cameramanTitle;
  }

  public Integer getIsBlock() {
    return isBlock;
  }

  public void setIsBlock(Integer isBlock) {
    this.isBlock = isBlock;
  }

  public Date getBlockTime() {
    return blockTime;
  }

  public void setBlockTime(Date blockTime) {
    this.blockTime = blockTime;
  }

  public Integer getIsLightningConsignment() {
    return isLightningConsignment;
  }

  public void setIsLightningConsignment(Integer isLightningConsignment) {
    this.isLightningConsignment = isLightningConsignment;
  }

  public Integer getIsShowcase() {
    return isShowcase;
  }

  public void setIsShowcase(Integer isShowcase) {
    this.isShowcase = isShowcase;
  }

  public Integer getIsUnique() {
    return isUnique;
  }

  public void setIsUnique(Integer isUnique) {
    this.isUnique = isUnique;
  }

  public Integer getIsHighlight() {
    return isHighlight;
  }

  public void setIsHighlight(Integer isHighlight) {
    this.isHighlight = isHighlight;
  }

  public Integer getIsHideStats() {
    return isHideStats;
  }

  public void setIsHideStats(Integer isHideStats) {
    this.isHideStats = isHideStats;
  }

  public Integer getIsShowComment() {
    return isShowComment;
  }

  public void setIsShowComment(Integer isShowComment) {
    this.isShowComment = isShowComment;
  }

  public Integer getIsDirectSale() {
    return isDirectSale;
  }

  public void setIsDirectSale(Integer isDirectSale) {
    this.isDirectSale = isDirectSale;
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

  public Integer getUniqueState() {
    return uniqueState;
  }

  public void setUniqueState(Integer uniqueState) {
    this.uniqueState = uniqueState;
  }

  public Date getUniqueStartTime() {
    return uniqueStartTime;
  }

  public void setUniqueStartTime(Date uniqueStartTime) {
    this.uniqueStartTime = uniqueStartTime;
  }

  public Date getUniqueEndTime() {
    return uniqueEndTime;
  }

  public void setUniqueEndTime(Date uniqueEndTime) {
    this.uniqueEndTime = uniqueEndTime;
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

  public int getCategoryNum() {
    return categoryNum;
  }

  public void setCategoryNum(int categoryNum) {
    this.categoryNum = categoryNum;
  }

  public int getIsTail() {
    return isTail;
  }

  public void setIsTail(int isTail) {
    this.isTail = isTail;
  }

  public ProductMeta getProductMeta() {
    return productMeta;
  }

  public void setProductMeta(ProductMeta productMeta) {
    this.productMeta = productMeta;
  }

  public ProductLabel getProductLabel() {
    return productLabel;
  }

  public void setProductLabel(ProductLabel productLabel) {
    this.productLabel = productLabel;
  }

  public ProductComment getProductComment() {
    return productComment;
  }

  public void setProductComment(ProductComment productComment) {
    this.productComment = productComment;
  }

  public int getProductSizeShow() {
    return productSizeShow;
  }

  public void setProductSizeShow(int productSizeShow) {
    this.productSizeShow = productSizeShow;
  }

  public ProductGuang getProductGuang() {
    return productGuang;
  }

  public void setProductGuang(ProductGuang productGuang) {
    this.productGuang = productGuang;
  }

  public ProductIdEncode getProductIdEncode() {
    return productIdEncode;
  }

  public void setProductIdEncode(ProductIdEncode productIdEncode) {
    this.productIdEncode = productIdEncode;
  }

  public ProductPunishLog getProductPunishLog() {
    return productPunishLog;
  }

  public void setProductPunishLog(ProductPunishLog productPunishLog) {
    this.productPunishLog = productPunishLog;
  }

  public ProductSearch2 getProductSearch2() {
    return productSearch2;
  }

  public void setProductSearch2(ProductSearch2 productSearch2) {
    this.productSearch2 = productSearch2;
  }

  public ProductTuan getProductTuan() {
    return productTuan;
  }

  public void setProductTuan(ProductTuan productTuan) {
    this.productTuan = productTuan;
  }

}
