package com.go2plus.core.product.vo;

import java.util.Date;

/**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * 
 * @category 产品分类
 * @author duyu
 *
 */
public class Category {
	private Integer id;
	private Integer taobaoCid;          //淘宝类目ID
	private String title;               //分类名称
	private String taobaoProps;         //淘宝分类属性ID
	private Integer taobaoParentCid;    //产品分类ID的父ID
	private Integer hits;               //分类点击量
	private Integer weight;             //产品分类权重，决定分类在页面的显示先后顺序
	private Integer state;              //表示该记录的状态，1为启用，0为禁用，-1为已删除
	private Date createTime;            //记录创建时间
	private Date updateTime;            //记录最后修改时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTaobaoCid() {
		return taobaoCid;
	}
	public void setTaobaoCid(Integer taobaoCid) {
		this.taobaoCid = taobaoCid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTaobaoProps() {
		return taobaoProps;
	}
	public void setTaobaoProps(String taobaoProps) {
		this.taobaoProps = taobaoProps;
	}
	public Integer getTaobaoParentCid() {
		return taobaoParentCid;
	}
	public void setTaobaoParentCid(Integer taobaoParentCid) {
		this.taobaoParentCid = taobaoParentCid;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
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
}
