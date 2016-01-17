package com.go2plus.core.common.dao;

import java.util.List;
import java.util.Map;

import com.go2plus.common.mvc.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.go2plus.core.common.vo.Setting;

/**
* Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
* treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
* penalties, and will be prosecuted to the maximum extent under the law.
* @author liyang
*/

@Repository
public interface SettingDao  extends DAO{
	
	/**
	 * page query Setting information
	 * @param queryMap
	 * @return ArrayList
	 */
    public List<Setting> findPageList(Map<String,Object> queryMap);
    
    /**
	 * query Setting information
	 * @param querySetting
	 * @return ArrayList
	 */
    public List<Setting> findList();
    
    /**
	 * query Setting information Count
	 * @param querySetting
	 * @return Integer
	 */
    public Integer findCount(Map<String,Object> queryMap);
    
    /**
	 * get one Setting information
	 * @param id
	 * @return Setting
	 */
    public Setting findById(Integer id);
	
	/**
	 * insert one Setting information
	 * @param id
	 */
	public void insert(Setting setting);
	
	/**
	 * update one Setting information
	 * @param Setting
	 */
    public void update(Setting setting);
    
    /**
	 * delete one Setting information
	 * @param id
	 */
    public void delete(Integer id);
    
    
    public List<String> findValueByName();
    
   	
}
