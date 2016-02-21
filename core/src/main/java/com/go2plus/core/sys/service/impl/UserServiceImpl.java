package com.go2plus.core.sys.service.impl;

import java.util.List;

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
	public User findById(Long id){
		User user = userDao.findById(id);
		return user;
	}

	@Override
	public boolean save(User user) {
		return userDao.save(user);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public boolean delete(Long id) {
		return userDao.delete(id);
	}

	@Override
	public User findUserByUserNameAndPassword(User user) {
		return userDao.findUserByUserNameAndPassword(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
