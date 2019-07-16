package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
