package com.go2plus.core.sys.dao;

import java.util.List;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.sys.vo.User;

public interface UserDao extends DAO{

	User findById(Long id);

	boolean save(User user);

	boolean update(User user);

	boolean delete(Long id);

	User findUserByUserNameAndPassword(User user);

	List<User> findAll();
}
