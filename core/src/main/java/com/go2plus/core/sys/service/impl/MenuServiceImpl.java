package com.go2plus.core.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2plus.core.sys.dao.MenuDao;
import com.go2plus.core.sys.service.MenuService;
import com.go2plus.core.sys.vo.Menu;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public boolean save(Menu menu) {
		return menuDao.save(menu);
	}

	@Override
	public boolean update(Menu menu) {
		return menuDao.update(menu);
	}

	@Override
	public boolean delete(Long id) {
		return menuDao.delete(id);
	}

	@Override
	public Menu findById(Long id) {
		return menuDao.findById(id);
	}

	@Override
	public List<Menu> findAll() {
		return menuDao.findAll();
	}

	@Override
	public List<Menu> findByResourceType(String resourceType) {
		return menuDao.findByResourceType(resourceType);
	}

	
}
