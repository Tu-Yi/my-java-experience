package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niliv.dao.DepartmentDao;
import com.niliv.entity.Department;
import com.niliv.util.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	
	public int save(Department dept) {
		String sql = "insert into dept values(?,?,?)";
		Object[] params = {dept.getDeptno(),dept.getDeptName(),dept.getLocation()};
		
		return DBUtil.executeUpdate(sql, params);
		
	}

	@Override
	public List<Department> findAll() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Department> depts = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from dept";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			depts = new ArrayList<>();
			while(rs.next()) {
				Department dept=new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDeptName(rs.getString("deptName"));
				dept.setLocation(rs.getString("location"));
				depts.add(dept);
			}
			System.out.println(depts);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return depts;
	}

	@Override
	public int delete(int deptNo) {
		
		String sql = "delete from dept where deptno=?";
		Object[] params = {deptNo};
		
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public Department findById(int deptNo) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Department dept=null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from dept where deptno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, deptNo);
			rs=ps.executeQuery();
			while(rs.next()) {
				dept=new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDeptName(rs.getString("deptName"));
				dept.setLocation(rs.getString("location"));
			}
			System.out.println(dept);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return dept;
	}

	@Override
	public int update(Department dept) {
		
		String sql = "update dept set deptname=?,location=? where deptno=?";
		Object[] params = {dept.getDeptName(),dept.getLocation(),dept.getDeptno()};
		
		return DBUtil.executeUpdate(sql, params);
	}
}
