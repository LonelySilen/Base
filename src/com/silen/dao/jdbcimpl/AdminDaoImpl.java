package com.silen.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.silen.dao.IAdminDao;
import com.silen.entity.po.Admin;

public class AdminDaoImpl extends BaseDao implements IAdminDao {

	@Override
	public Admin findById(Integer id) {
		// TODO Auto-generated method stub
		Admin admin = null;
		this.getConnection();
		String sql = "select * from Admins where id = ?";
		this.doQuery(sql, id);
		try {
			if (rs != null && rs.next()) {
				admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return admin;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		List<Admin> admins = null;
		this.getConnection();
		String sql = "select * from Admins";
		this.doQuery(sql);
		if (rs != null) {
			admins = new ArrayList<Admin>();
			try {
				while (rs.next()) {
					Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6));
					admins.add(admin);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.closeAll();
		return admins;
	}

	@Override
	public int insert(Admin admin) {
		// TODO Auto-generated method stub
		int res = 0;
		this.getConnection();
		String sql = "insert into Admins (usn, pwd, name, mobile, cover) values(?,?,?,?,?)";
		this.doUpdate(sql, admin.getUsn(), admin.getPwd(), admin.getName(), admin.getMobile(), admin.getCover());
		res = result;
		this.closeAll();

		return res;
	}

	@Override
	public int update(Admin admin) {
		// TODO Auto-generated method stub
		int res = 0;
		this.getConnection();
		String sql = "update Admins set usn = ?, pwd = ?, name = ?, mobile = ?, cover = ? where id = ?";
		this.doUpdate(sql, admin.getUsn(), admin.getPwd(), admin.getName(), admin.getMobile(), admin.getCover(),
				admin.getId());
		res = result;
		this.closeAll();
		return res;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		int res = 0;
		this.getConnection();
		String sql = "delete from Admins where id = ?";
		this.doUpdate(sql, id);
		res = result;
		this.closeAll();
		return res;
	}

	@Override
	public Admin sellectAdminByUsn(String usn) {
		// TODO Auto-generated method stub
		Admin admin = null;
		this.getConnection();
		String sql = "select * from Admins where usn = ?";
		this.doQuery(sql, usn);
		try {
			if (rs != null && rs.next()) {
				admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return admin;
	}

	@Override
	public Admin sellectAdminByPwd(String pwd) {
		// TODO Auto-generated method stub
		Admin admin = null;
		this.getConnection();
		String sql = "select * from Admins where pwd = ?";
		this.doQuery(sql, pwd);
		try {
			if (rs != null && rs.next()) {
				admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return admin;
	}

}
