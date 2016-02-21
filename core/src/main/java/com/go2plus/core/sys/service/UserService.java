package com.go2plus.core.sys.service;

import com.go2plus.core.common.exception.SystemException;
import com.go2plus.core.sys.vo.User;

public interface UserService {
	/**
	 * get a User information
	 * 
	 * @param id
	 * @return User
	 * @throws SystemException
	 */
	public User findById(Long id) throws SystemException;
}
