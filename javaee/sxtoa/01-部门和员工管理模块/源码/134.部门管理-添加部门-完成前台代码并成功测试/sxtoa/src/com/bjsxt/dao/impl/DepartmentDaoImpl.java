package com.bjsxt.dao.impl;

import com.bjsxt.dao.DepartmentDao;
import com.bjsxt.entity.Department;
import com.bjsxt.util.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public int save(Department dept) {
		String sql = "insert into dept values(?,?,?)";
		Object [] params = {dept.getDeptno(),dept.getDeptName(),dept.getLocation()};
		
		return DBUtil.executeUpdate(sql, params);
	}

}
