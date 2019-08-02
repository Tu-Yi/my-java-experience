package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niliv.dao.UserDao;
import com.niliv.pojo.Url;
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

	@Override
	public List<Url> getUserUrlInfoDao(int id) {
		
		//声明jdbc变量
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<Url> lu=null;
		try {
			//创建连接
			conn=DBUtil.getConnection();
			//创建SQL命令
			String sql="select * from t_url where urlid in (select urlid from t_user_url where uid=?)";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1, id);
			//执行SQL命令
			rs=ps.executeQuery();
			//给list集合赋值
			lu=new ArrayList<>();
			//遍历
			while(rs.next()){
				//给变量赋值
				Url u=new Url();
				u.setUrlid(rs.getInt("urlid"));
				u.setLocation(rs.getString("location"));
				u.setRemark(rs.getString("remark"));
				lu.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭资源
			DBUtil.closeAll(rs, ps, conn);
		}
		//返回结果
		return lu;
	}

}
