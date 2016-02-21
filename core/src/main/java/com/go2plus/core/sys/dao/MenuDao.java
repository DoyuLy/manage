package com.go2plus.core.sys.dao;

import java.util.List;
import com.go2plus.common.mvc.DAO;
import com.go2plus.core.sys.vo.Menu;

public interface MenuDao extends DAO {

	boolean save(Menu menu);

	boolean update(Menu menu);

	boolean delete(Long id);

	Menu findById(Long id);

	List<Menu> findAll();

	List<Menu> findByResourceType(String resourceType);
}
