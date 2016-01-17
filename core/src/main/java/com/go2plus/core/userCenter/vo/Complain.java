package com.go2plus.core.userCenter.vo;

import java.util.Date;

import com.go2plus.core.product.vo.Product;
import com.go2plus.core.product.vo.Site;

public class Complain {
	private Integer id;
	private Integer supplierUserId; // List<Supplier> supplierUsers
	private Integer userId; // User user
	private Integer productId;
	private Integer complainCategoryId;
	private String review;
	private String images;
	private String ip;
	private Integer isFixed;
	private Integer credit;
	private Integer weight;
	private String comment;
	private Integer state;
	private Date createTime;
	private Date updateTime;

	 private Site site;
	 private Product product;
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSupplierUserId() {
		return supplierUserId;
	}

	public void setSupplierUserId(Integer supplierUserId) {
		this.supplierUserId = supplierUserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getComplainCategoryId() {
		return complainCategoryId;
	}

	public void setComplainCategoryId(Integer complainCategoryId) {
		this.complainCategoryId = complainCategoryId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getIsFixed() {
		return isFixed;
	}

	public void setIsFixed(Integer isFixed) {
		this.isFixed = isFixed;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }
}
