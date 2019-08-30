package com.bjsxt.service.impl;

import com.bjsxt.dao.DepartmentDao;
import com.bjsxt.dao.impl.DepartmentDaoImpl;
import com.bjsxt.entity.Department;
import com.bjsxt.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao deptDao = new DepartmentDaoImpl();
	
	@Override
	public int add(Department dept) {
		return this.deptDao.save(dept);
	}

}
