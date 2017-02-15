package com.silen.biz.impl;

import java.util.List;

import com.silen.biz.UserService;
import com.silen.dao.IUserDao;
import com.silen.dao.jdbcimpl.UserDaoImpl;
import com.silen.entity.po.User;

public class UserServiceImpl implements UserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public boolean isValidate(String usn, String pwd) {
		// TODO Auto-generated method stub
		boolean res = false;
		User user = userDao.sellectUserByUsn(usn);
		if (user != null && pwd.equals(user.getPwd())) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isValidate(String usn) {
		// TODO Auto-generated method stub
		boolean res = false;
		User user = userDao.sellectUserByUsn(usn);
		if (user != null) {
			res = true;
		}
		return res;
	}

	@Override
	public User selectUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

	@Override
	public int removeUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User selectUserByUsn(String usn) {
		// TODO Auto-generated method stub
		return userDao.sellectUserByUsn(usn);
	}

}
