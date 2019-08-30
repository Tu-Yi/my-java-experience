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
			//��ȡ����
			conn = DBUtil.getConnection();
			//����������ȡ���
			stmt = conn.createStatement();
			//������
			rs =stmt.executeQuery("select * from Student");
			while(rs.next()){
				//��ȡ�����ֶε�ֵ
				int id =rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double score = rs.getDouble("score");
				String realName = rs.getString("realName");
				String photoName = rs.getString("photoName");
				String photoType = rs.getString("phototype");
				//���ֶδ�������
				Student stu = new Student(id, name, age, score,realName,photoName,photoType);	
				//��������뼯��
				stuList.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBUtil.closeAll(rs, stmt, conn);
		}		
		//���ؽ��
		return stuList;
	}

	public Student findById(int idd) {
		Student stu = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//��ȡ����
			conn = DBUtil.getConnection();
			//����������ȡ���
			stmt = conn.createStatement();
			//������
			rs =stmt.executeQuery("select * from Student where id = "+idd);
			rs.next();
			//��ȡ�����ֶε�ֵ
			int id =rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			double score = rs.getDouble("score");
			String realName = rs.getString("realName");
			String photoName = rs.getString("photoName");
			String photoType = rs.getString("phototype");
			//���ֶδ�������
			stu = new Student(id, name, age, score,realName,photoName,photoType);				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBUtil.closeAll(rs, stmt, conn);
		}		
		//���ؽ��
		return stu;
	}

	public int save(Student stu) {	
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n=0;
		try{
		//��ȡ����
		conn = DBUtil.getConnection();
		//����������ȡ���
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
		//�ر���Դ
		DBUtil.closeAll(null, pstmt, conn);
	}		
		return n;
	}
}
