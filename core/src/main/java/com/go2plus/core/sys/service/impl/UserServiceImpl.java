package com.go2plus.core.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2plus.core.common.exception.SystemException;
import com.go2plus.core.sys.dao.UserDao;
import com.go2plus.core.sys.service.UserService;
import com.go2plus.core.sys.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findById(Long id) throws SystemException {
		User user = userDao.findById(id);
		return user;
	}

}
