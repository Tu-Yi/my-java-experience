package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niliv.commons.JdbcUtil;
import com.niliv.dao.DepartmentsDao;
import com.niliv.pojo.Departments;
import com.niliv.pojo.Users;
/**
 * DepartmentsDao实现类
 * @author Administrator
 * @Date 2019-05-31 10:59:44
 * @Description 
 *
 */
public class DepartmentsDaoImpl extends BaseDaoImpl implements DepartmentsDao {

	@Override
	public List<Departments> selectDepartmentsByName(String departments_name) {

		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs = null;
		Departments dept = null;
		List<Departments> deptList = new ArrayList<Departments>();
		try {
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM departments where DEPARTMENT_NAME like ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+departments_name+"%");
			rs = statement.executeQuery();
			while(rs.next()) {
				dept = new Departments();
				dept.setDEPARTMENT_ID(rs.getInt("department_id"));
				dept.setDEPARTMENT_NAME(rs.getString("department_name"));
				dept.setMANAGER_ID(rs.getInt("MANAGER_ID"));
				dept.setLOCATION_ID(rs.getInt("LOCATION_ID"));
				deptList.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeResource(statement, conn ,null);
		}
		return deptList;
	}

	@Override
	public void insertDepartments(Departments departments) {
		Connection conn=null;
		PreparedStatement statement=null;
		
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO departments values(?,?,null,?)";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, departments.getDEPARTMENT_ID());
			statement.setString(2, departments.getDEPARTMENT_NAME());
			statement.setInt(3, departments.getLOCATION_ID());
			
			statement.execute();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		}finally {
			JdbcUtil.closeResource(statement, conn ,null);
		}
	}

	@Override
	public int updateDepartments(Departments departments) {
		String sqlString = "update departments set DEPARTMENT_NAME = ? where department_id = ?";
		Object[] paramObjects = new Object[] {departments.getDEPARTMENT_NAME(),departments.getDEPARTMENT_ID()};
		
		return this.executeUpdate(sqlString, paramObjects);
	}

	@Override
	public int deleteDepartmentsById(int department_id) {
		String sqlString = "delete from departments where department_id = ?";
		Object[] paramObjects = new Object[] {department_id};
		
		return this.executeUpdate(sqlString, paramObjects);
	}

	@Override
	public List<Departments> selectDeptByName(String department_name) {
		String sqlString = "select * from departments where department_name like ?";
		Object[] obj = new Object[] {"%"+department_name+"%"};
		
		return this.find(sqlString, obj, Departments.class);
	}

}









