package com.go2plus.core.common.vo;


import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.Date;


 /**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
 * treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
 * penalties, and will be prosecuted to the maximum extent under the law.
 * @author liyang
 */

public class Setting{

    private Integer id;
					//
    private String itemName;
    			//
    private String itemValue;
    			//
    private String catalog;
    			//
    private Integer state;
    			//
    private Date createTime;
    			//
    private Date updateTime;
    	
					
	public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

  public String getItemName() {
		return this.itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
				
	public String getItemValue() {
		return this.itemValue;
	}
	
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	
				
	public String getCatalog() {
		return this.catalog;
	}
	
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
				
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
				
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
				
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
			@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
