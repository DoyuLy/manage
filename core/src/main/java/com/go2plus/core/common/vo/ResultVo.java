package com.go2plus.core.common.vo;

import java.util.List;

public class ResultVo {
	private Integer totalCount;
	private Integer pageSize;
	private Integer pageIndex;
	private String  key;
	private List<?> result;
	private String searchType;
	
	public ResultVo(int totalCount, int pageSize, int pageIndex, String key, String searchType, List<?> result){
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.result = result;
		this.key = key;
		this.searchType = searchType;
	}
	
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<?> getResult() {
		return result;
	}
	public void setResult(List<?> result) {
		this.result = result;
	}
}
