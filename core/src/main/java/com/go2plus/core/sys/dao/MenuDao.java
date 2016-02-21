package com.go2plus.core.sys.dao;

import java.util.List;
import com.go2plus.common.mvc.DAO;
import com.go2plus.core.sys.vo.Menu;

public interface MenuDao extends DAO {
	
	public void save(Menu menu);

	public boolean update(Menu menu);

	public boolean delete(Long id);

	public Menu findById(Long id);

	public List<Menu> findAll();

	public List<Menu> findByResourceType(String resourceType);
}
