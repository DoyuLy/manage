package com.go2plus.core.sys.service;

import java.util.List;

import com.go2plus.core.sys.vo.User;

public interface UserService {

	User findById(Long id);

	boolean save(User user);

	boolean update(User user);
	
	User findUser(User user);

	boolean delete(Long id);

	User findUserByUserNameAndPassword(User user);

	List<User> findAll();
}
