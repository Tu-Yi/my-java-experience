package com.niliv.service.impl;

import java.util.List;

import com.niliv.dao.DepartmentsDao;
import com.niliv.dao.impl.DepartmentsDaoImpl;
import com.niliv.pojo.Departments;
import com.niliv.service.DepartmentsService;

public class DepartmentsServiceImpl implements DepartmentsService {

	@Override
	public void addDepartments(Departments departments) {
		
		DepartmentsDao departmentsDao = new DepartmentsDaoImpl();
		departmentsDao.insertDepartments(departments);
		
	}

	@Override
	public int modifyDepartments(Departments departments) {
		DepartmentsDao departmentsDao = new DepartmentsDaoImpl();
		return departmentsDao.updateDepartments(departments);
	}

	@Override
	public int dropDepartments(int departments_id) {
		
		DepartmentsDao departmentsDao = new DepartmentsDaoImpl();
		return departmentsDao.deleteDepartmentsById(departments_id);
	}

	@Override
	public List<Departments> findDepartments(String department_name) {
		
		DepartmentsDao departmentsDao = new DepartmentsDaoImpl();
		return departmentsDao.selectDeptByName(department_name);
	}
	
}
