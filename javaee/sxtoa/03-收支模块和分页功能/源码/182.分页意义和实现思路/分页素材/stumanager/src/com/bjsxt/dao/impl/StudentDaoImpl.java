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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, stmt, conn);
		}
		return stuList;
	}
}
