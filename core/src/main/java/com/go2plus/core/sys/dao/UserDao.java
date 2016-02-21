package com.go2plus.core.sys.dao;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.sys.vo.User;

public interface UserDao extends DAO {
	/**
	 * get one User information
	 * 
	 * @param id
	 * @return User
	 */
	public User findById(Long id);
}
