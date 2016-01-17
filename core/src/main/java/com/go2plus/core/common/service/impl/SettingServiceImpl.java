package com.go2plus.core.common.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2plus.core.common.vo.Setting;
import com.go2plus.core.common.dao.SettingDao;
import com.go2plus.core.common.service.SettingService;

/**
* Copyright (C) 2015 GO2.CN. All rights reserved. This computer program source code file is protected by copyright law and international
* treaties. Unauthorized distribution of source code files, programs, or portion of the package, may result in severe civil and criminal
* penalties, and will be prosecuted to the maximum extent under the law.
* @author liyang
*/
@Service
public class SettingServiceImpl implements SettingService{
	@Autowired
	private SettingDao settingDao;
	
	public List<Setting> findPageList(Map<String,Object> queryMap){
		Integer counter = settingDao.findCount(queryMap);
		queryMap.put("totalRow", counter);
		List<Setting> list =settingDao.findPageList(queryMap);
		return list;
	}
    /*
    public List<Setting> findList() throws SystemException {
    	List<Setting> list =settingDao.findList();
		return list;
	}
    */
    public Setting findById(Integer id){
    	Setting setting=settingDao.findById(id);
		return setting;
	}
	
	public void add(Setting setting){
		settingDao.insert(setting);
	}
	
	public void update(Setting setting){
		settingDao.update(setting);
	}
	
	public boolean save(Setting settingForm){
		Setting setting = null;
    	if ( settingForm.getId() == null ) {
    		setting = new Setting();
    	} else {
    		setting =findById(settingForm.getId());
    	}
    	if(setting!=null){
																		setting.setItemName(settingForm.getItemName());
					    												setting.setItemValue(settingForm.getItemValue());
					    												setting.setCatalog(settingForm.getCatalog());
					    												setting.setState(settingForm.getState());
					    												setting.setCreateTime(settingForm.getCreateTime());
					    												setting.setUpdateTime(settingForm.getUpdateTime());
					    						
			if ( setting.getId() != null && setting.getId() > 0 ) {
				update(setting);
			} else {
				add(setting);
			}
			return true;
		}
		return false;
	}
	
    public void delete(String[] selectedIds){
    	Integer len = selectedIds.length;
    	for ( int i = 0; i < len; i++ ) {
    		String id=selectedIds[i];
    		if(StringUtils.isNotBlank(id)){
    			delete(Integer.parseInt(id));
    		}
    	}
	}
    public void delete(Integer id){
    	settingDao.delete(id);
	}
	
	
	
}
