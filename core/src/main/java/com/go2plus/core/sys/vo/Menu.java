package com.go2plus.core.sys.vo;

import java.io.Serializable;

import com.go2plus.core.common.entity.BaseEntity;

public class Menu extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int      resourceGrade;
	private String   accessPath;
	private boolean  checked;
	private int      delFlag;
	private int      parentID;
	private String   resourceCode;
	private String   resourceDesc;
	private String   resourceName;
	private String   resourceOrder;
	private String   resourceType;
	
	public int getResourceGrade() {
		return resourceGrade;
	}
	public void setResourceGrade(int resourceGrade) {
		this.resourceGrade = resourceGrade;
	}
	public String getAccessPath() {
		return accessPath;
	}
	public void setAccessPath(String accessPath) {
		this.accessPath = accessPath;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public String getResourceDesc() {
		return resourceDesc;
	}
	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceOrder() {
		return resourceOrder;
	}
	public void setResourceOrder(String resourceOrder) {
		this.resourceOrder = resourceOrder;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
}
