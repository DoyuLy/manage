package com.go2plus.core.common.service;

import java.util.List;
import java.util.Map;

import com.go2plus.core.common.vo.Setting;

/**
* Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
* treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
* penalties, and will be prosecuted to the maximum extent under the law.
* @author liyang
*/

 
public interface SettingService {

	/**
	 * page query Setting information
	 * @param querySetting
	 * @return ArrayList
	 * @throws SystemException
	 */
    public List<Setting> findPageList(Map<String,Object> queryMap);
    
    /**
	 * query Setting information
	 * @return ArrayList
	 * @throws SystemException
	 
    public List<Setting> findList() throws SystemException;
    */
    
    /**
	 * get a Setting information
	 * @param id
	 * @return Setting
	 * @throws SystemException
	 */
    public Setting findById(Integer id);
    
	/**
	 * add one Setting information
	 * @param Setting
	 * @throws SystemException
	 */
	public void add(Setting setting);
	
	/**
	 *  update one Setting information
	 * @param Setting
	 * @throws SystemException
	 */
	public void update(Setting setting);
	
	/**
	 * add or update one Setting information
	 * @param Setting
	 * @throws SystemException
	 */
	public boolean save(Setting setting);
	
	/**
	 * delete one or more Setting information
	 * @param ids by "," split
	 * @throws SystemException
	 */
    public void delete(String[] selectedIds );
    
    /**
	 * delete one Setting information
	 * @param id
	 * @throws SystemException
	 */
    public void delete(Integer id);
    
}


