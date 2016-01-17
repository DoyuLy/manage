package com.go2plus.core.product.dao;

import java.util.List;
import java.util.Map;

import com.go2plus.common.mvc.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.go2plus.core.product.vo.Site;

 /**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law. 
 * @Description: this is SiteDao
 * @author: liyang
 * @Date: 2015-12-9 17:46:37
 */
@Repository
public interface SiteDao  extends DAO{
	
	/**
	 * page query Site information
	 * @param queryMap
	 * @return ArrayList
	 */
    public List<Site> findPageList(Map<String,Object> queryMap);
    
    /**
	 * query Site information
	 * @param querySite
	 * @return ArrayList
	 */
    public List<Site> findList();
    
    /**
	 * query Site information Count
	 * @param querySite
	 * @return Integer
	 */
    public Integer findCount(Map<String,Object> queryMap);
    
    /**
	 * get one Site information
	 * @param id
	 * @return Site
	 */
    public Site findById(Integer id);
	
	/**
	 * insert one Site information
	 * @param id
	 */
	public int insert(Site site);
	
	/**
	 * update one Site information
	 * @param Site
	 */
    public void update(Site site);
    
    /**
	 * delete one Site information
	 * @param id
	 */
    public void delete(Integer id);
    
    /**
     * 查询url是否存在
     * @param url
     * @return
     */
    public String findSiteBySubdomain(@Param("url") String url);
    
   	
}
