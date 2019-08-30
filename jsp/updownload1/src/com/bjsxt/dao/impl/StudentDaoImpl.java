package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.entity.Student;
import com.bjsxt.util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	public List<Student> findAll() {
		List<Student> stuList = new ArrayList<Student>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//获取连接
			conn = DBUtil.getConnection();
			//发送命令或获取结果
			stmt = conn.createStatement();
			//处理结果
			rs =stmt.executeQuery("select * from Student");
			while(rs.next()){
				//获取各个字段的值
				int id =rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				String realName = rs.getString("realName");
				String photoName = rs.getString("photoName");
				String photoType = rs.getString("phototype");
				//由字段创建对象
				Student stu = new Student(id, name, age, score,realName,photoName,photoType);	
				//将对象放入集合
				stuList.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			DBUtil.closeAll(rs, stmt, conn);
		}		
		//返回结果
		return stuList;
	}

	public Student findById(int idd) {
		Student stu = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//获取连接
			conn = DBUtil.getConnection();
			//发送命令或获取结果
			stmt = conn.createStatement();
			//处理结果
			rs =stmt.executeQuery("select * from Student where id = "+idd);
			rs.next();
			//获取各个字段的值
			int id =rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			double score = rs.getDouble("score");
			String realName = rs.getString("realName");
			String photoName = rs.getString("photoName");
			String photoType = rs.getString("phototype");
			//由字段创建对象
			stu = new Student(id, name, age, score,realName,photoName,photoType);				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			DBUtil.closeAll(rs, stmt, conn);
		}		
		//返回结果
		return stu;
	}

	public int save(Student stu) {	
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n=0;
		try{
		//获取连接
		conn = DBUtil.getConnection();
		//发送命令或获取结果
		pstmt = conn.prepareStatement("insert into student values(seq_stu.nextval,?,?,?,?,?,?)");
		pstmt.setString(1, stu.getName());
		pstmt.setInt(2, stu.getAge());
		pstmt.setDouble(3, stu.getScore());
		pstmt.setString(4, stu.getRealName());
		pstmt.setString(5, stu.getPhotoName());
		pstmt.setString(6, stu.getPhotoType());
		n = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		//关闭资源
		DBUtil.closeAll(null, pstmt, conn);
	}		
		return n;
	}
}
