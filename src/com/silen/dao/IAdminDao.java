package com.silen.dao;

import com.silen.entity.po.Admin;

public interface IAdminDao extends IGenericDao<Admin, Integer> {
	Admin sellectAdminByUsn(String usn);

	Admin sellectAdminByPwd(String pwd);
}
