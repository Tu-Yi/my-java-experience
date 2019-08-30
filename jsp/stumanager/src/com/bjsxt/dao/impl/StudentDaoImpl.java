package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.entity.Student;
import com.bjsxt.util.DBUtil;

public class StudentDaoImpl   implements StudentDao {
	public List<Student> findAll() {
		Connection conn =DBUtil.getConnection();
		Statement stmt =null;
		ResultSet rs =null;
		List <Student> stuList = new ArrayList<Student>();
		try {
			stmt =conn.createStatement();
			rs = stmt.executeQuery("select * from student");
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setScore(rs.getDouble("score"));
				stuList.add(stu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, stmt, conn);
		}
		return stuList;
	}

	public List<Student> findStu(int start, int end) {
		Connection conn =DBUtil.getConnection();
		Statement stmt =null;
		ResultSet rs =null;
		List <Student> stuList = new ArrayList<Student>();
		try {
			stmt =conn.createStatement();
			String sql = "select  * from (select rownum rn,stu2.* "
					+ "from (select  stu.* from student stu order by score desc ) stu2 "
					+ "where rownum <="+end+" ) "
					+ "where rn >"+start;
			
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setScore(rs.getDouble("score"));
				stuList.add(stu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, stmt, conn);
		}
		return stuList;
	}

	public int findCount() {
		Connection conn =DBUtil.getConnection();
		Statement stmt =null;
		ResultSet rs =null;
		List <Student> stuList = new ArrayList<Student>();
		int count = 0;
		try {
			stmt =conn.createStatement();
			rs = stmt.executeQuery("select count(*) from student");
			rs.next();
			count = rs.getInt(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, stmt, conn);
		}
		
		return count;
	}

	public int findCount(String name, double minScore) {
		Connection conn =DBUtil.getConnection();
		Statement stmt =null;
		ResultSet rs =null;
		List <Student> stuList = new ArrayList<Student>();
		int count = 0;
		try {
			StringBuilder sql = new StringBuilder("select count(*) from student where 1=1 ");
			if(name != null && !"".equals(name)){
				sql.append(" and name like '%"+name+"%'");
			}
			if(minScore >0){
				sql.append(" and score >= "+minScore);
			}
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			rs.next();
			count = rs.getInt(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, stmt, conn);
		}
		
		return count;
	}

	public List<Student> findStu(int start, int end, String name,
			double minScore) {
		Connection conn =DBUtil.getConnection();
		Statement stmt =null;
		ResultSet rs =null;
		List <Student> stuList = new ArrayList<Student>();
		try {
			stmt =conn.createStatement();
			StringBuilder sql = new StringBuilder("select  stu.* from student stu where 1=1 ");
			if(name != null && !"".equals(name)){
				sql.append(" and name like '%"+name+"%'");
			}
			if(minScore >0){
				sql.append(" and score >= "+minScore);
			}
			sql.append(" order by score desc");
			
			String sql2 = "select  * from (select rownum rn,stu2.* "
					+ "from ("+sql.toString()+") stu2 "
					+ "where rownum <="+end+" ) "
					+ "where rn >"+start;
			
			rs = stmt.executeQuery(sql2);
			while(rs.next()){
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
				stu.setScore(rs.getDouble("score"));
				stuList.add(stu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, stmt, conn);
		}
		return stuList;
	}
}
