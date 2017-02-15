package com.silen.dao;

import com.silen.entity.po.User;

public interface IUserDao extends IGenericDao<User, Integer> {
	User sellectUserByUsn(String usn);

	User sellectUserByPwd(String pwd);
	// User findByName(String name);
}
