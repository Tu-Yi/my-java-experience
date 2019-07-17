package com.niliv.service.impl;

import java.util.List;

import com.niliv.dao.EmployeeDao;
import com.niliv.dao.impl.EmployeeDaoImpl;
import com.niliv.pojo.Employee;
import com.niliv.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao ed = new EmployeeDaoImpl();

	@Override
	public List<Employee> selEmployeeInfoService() {
		
		return ed.selEmployeeInfoDao();
	}

}
