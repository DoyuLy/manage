package com.go2plus.core.product.service;

import java.util.List;
import java.util.Map;

import com.go2plus.core.product.vo.Site;


 /**
 * Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source
 * code file is protected by copyright law and international treaties.
 * Unauthorized distribution of source code files, programs, or portion of the
 * package, may result in severe civil and criminal penalties, and will be
 * prosecuted to the maximum extent under the law.
 * @Description: this is Site Service
 * @author: liyang
 * @Date: 2015-12-9 17:46:37
 */
public interface SiteService {

	/**
	 * page query Site information
	 * @param querySite
	 * @return ArrayList
	 * @throws SystemException
	 */
    public List<Site> findPageList(Map<String,Object> queryMap);
    
    /**
	 * query Site information
	 * @return ArrayList
	 * @throws SystemException
	 
    public List<Site> findList() throws SystemException;
    */
    
    /**
	 * get a Site information
	 * @param id
	 * @return Site
	 * @throws SystemException
	 */
    public Site findById(Integer id);
    
	/**
	 * add one Site information
	 * @param Site
	 * @throws SystemException
	 */
	public void add(Site site);
	
	/**
	 *  update one Site information
	 * @param Site
	 * @throws SystemException
	 */
	public void update(Site site);
	
	/**
	 * add or update one Site information
	 * @param Site
	 * @throws SystemException
	 */
	public boolean save(Site site);
	
	/**
	 * delete one or more Site information
	 * @param ids by "," split
	 * @throws SystemException
	 */
    public void delete(String[] selectedIds );
    
    /**
	 * delete one Site information
	 * @param id
	 * @throws SystemException
	 */
    public void delete(Integer id);
    
}


