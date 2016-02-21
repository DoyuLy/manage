package com.go2plus.core.sys.dao;

import java.util.List;

import com.go2plus.common.mvc.DAO;
import com.go2plus.core.sys.vo.User;

public interface UserDao extends DAO {

	public User findById(Long id);

	public void save(User user);

	public boolean update(User user);

	public boolean delete(Long id);

	public User findUserByUserNameAndPassword(User user);

	public List<User> findAll();
}
