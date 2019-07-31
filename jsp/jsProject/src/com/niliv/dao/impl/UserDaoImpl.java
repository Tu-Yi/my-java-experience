package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niliv.dao.UserDao;
import com.niliv.pojo.User;
import com.niliv.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserInfoDao(String uname, String pwd) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user=null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_user where uname=? and pwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
			}
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return user;
	}

	@Override
	public int regUserInfoDao(String uname, String pwd) {
		
		String sql = "insert into t_user values(default,?,?)";
		System.out.println(uname+pwd);
		return DBUtil.executeDML(sql, uname,pwd);
	}

	@Override
	public List<User> selUserInfoDao() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<User> users = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_user";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			users = new ArrayList<>();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
				users.add(user);
			}
			System.out.println(users);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return users;
	}

	@Override
	public int delUserInfoDao(String id) {
		
		String sql = "delete from t_user where id=?";
		return DBUtil.executeDML(sql, id);
	}

	@Override
	public User valUserName(String name) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User user=null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_user where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
			}
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return user;
	}

}
