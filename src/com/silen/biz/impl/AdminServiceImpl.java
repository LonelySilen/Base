package com.silen.biz.impl;

import com.silen.biz.AdminService;
import com.silen.dao.IAdminDao;
import com.silen.dao.jdbcimpl.AdminDaoImpl;
import com.silen.entity.po.Admin;

public class AdminServiceImpl implements AdminService {

	IAdminDao adminDao = new AdminDaoImpl();

	@Override
	public boolean isValidate(String usn, String pwd) {
		// TODO Auto-generated method stub
		boolean res = false;
		Admin admin = adminDao.sellectAdminByUsn(usn);
		if (admin != null && pwd.equals(admin.getPwd())) {
			res = true;
		}
		return res;
	}

	@Override
	public int insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.insert(admin);
	}

	@Override
	public int deleteAdminById(Integer id) {
		// TODO Auto-generated method stub
		return adminDao.delete(id);
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.update(admin);
	}

}
