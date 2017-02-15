package com.silen.dao.jdbcimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.silen.dao.IUserDao;
import com.silen.entity.po.User;

public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users = null;
		this.getConnection();
		String sql = "select * from test_user";
		this.doQuery(sql);
		if (rs != null) {
			users = new ArrayList<User>();
			try {
				while (rs.next()) {
					User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getDouble(10));
					users.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.closeAll();
		return users;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		User user = null;
		this.getConnection();
		String sql = "select * from test_user where id=?";
		this.doQuery(sql, id);
		try {
			if (rs != null && rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return user;
	}

	@Override
	public int insert(User entity) {
		// TODO Auto-generated method stub
		int res = 0;
		this.getConnection();
		String sql = "insert into test_user (usn,pwd,name, gender,cover, mobile, postCart, address,blance) values(?,?,?,?,?,?,?,?,?)";
		this.doUpdate(sql, entity.getUsn(), entity.getPwd(), entity.getName(), entity.getGender(), entity.getCover(),
				entity.getMobile(), entity.getPostCart(), entity.getAddress(), entity.getBlance());
		res = result;
		this.closeAll();
		return res;
	}

	@Override
	public int update(User entity) {
		// TODO Auto-generated method stub
		int res = 0;
		this.getConnection();
		String sql = "update test_user set usn=?,pwd=?,name=?, gender=?,cover=?, mobile=?, postCart=?, address=?,blance=? where id=?";
		this.doUpdate(sql, entity.getUsn(), entity.getPwd(), entity.getName(), entity.getGender(), entity.getCover(),
				entity.getMobile(), entity.getPostCart(), entity.getAddress(), entity.getBlance(), entity.getId());
		res = result;
		this.closeAll();
		return res;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		int res = 0;
		this.getConnection();
		String sql = "delete from test_user where id=?";
		this.doUpdate(sql, id);
		res = result;
		this.closeAll();
		return res;
	}

	@Override
	public User sellectUserByUsn(String usn) {
		// TODO Auto-generated method stub
		User user = null;
		this.getConnection();
		String sql = "select * from test_user where usn=?";
		this.doQuery(sql, usn);
		try {
			if (rs != null && rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return user;
	}

	@Override
	public User sellectUserByPwd(String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
