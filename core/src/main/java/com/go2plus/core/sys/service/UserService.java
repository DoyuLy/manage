package com.go2plus.core.sys.service;

import java.util.List;

import com.go2plus.core.common.exception.SystemException;
import com.go2plus.core.sys.vo.User;

public interface UserService {
	
	public User findById(Long id);

	public boolean save(User user);

	public boolean update(User user);

	public boolean delete(Long id);

	public User findUserByUserNameAndPassword(User user);

	public List<User> findAll();
}
