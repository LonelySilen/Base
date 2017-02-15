package com.silen.biz;

import java.util.List;

import com.silen.entity.po.User;

public interface UserService {
	boolean isValidate(String usn, String pwd);

	boolean isValidate(String usn);

	User selectUserByUsn(String usn);

	User selectUserById(Integer id);

	int updateUser(User user);

	int insertUser(User user);

	int removeUserById(Integer id);

	List<User> selectAllUser();
}
