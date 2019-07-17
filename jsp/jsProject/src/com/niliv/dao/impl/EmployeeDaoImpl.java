package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niliv.dao.EmployeeDao;
import com.niliv.pojo.Employee;
import com.niliv.pojo.User;
import com.niliv.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> selEmployeeInfoDao() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Employee> employees = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_employee";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			employees = new ArrayList<>();
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setPost(rs.getString("post"));
				employee.setSalary(rs.getInt("salary"));
				employee.setAssistance(rs.getInt("assistance"));
				employees.add(employee);
			}
			System.out.println(employees);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return employees;
	}

}
