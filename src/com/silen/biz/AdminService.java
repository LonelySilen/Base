package com.silen.biz;

import com.silen.entity.po.Admin;

public interface AdminService {
	boolean isValidate(String usn, String pwd);

	int insertAdmin(Admin admin);

	int deleteAdminById(Integer id);

	int updateAdmin(Admin admin);
}
