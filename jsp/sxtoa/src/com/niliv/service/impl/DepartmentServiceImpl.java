package com.niliv.service.impl;

import java.util.List;

import com.niliv.dao.DepartmentDao;
import com.niliv.dao.impl.DepartmentDaoImpl;
import com.niliv.entity.Department;
import com.niliv.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao deptDao = new DepartmentDaoImpl();
	
	@Override
	public int add(Department dept) {

		return this.deptDao.save(dept);
	}

	@Override
	public List<Department> findAll() {
		
		return this.deptDao.findAll();
	}

	@Override
	public int delete(int deptNo) {
		
		return this.deptDao.delete(deptNo);
	}

	@Override
	public Department findById(int deptNo) {
		
		return this.deptDao.findById(deptNo);
	}

	@Override
	public int update(Department dept) {
		
		return this.deptDao.update(dept);
	}

}
