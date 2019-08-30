package com.bjsxt.service.impl;

import java.util.Date;
import java.util.List;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.dao.impl.EmployeeDaoImpl;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao empDao = new EmployeeDaoImpl();
	
	@Override
	public int add(Employee emp) {
		return this.empDao.save(emp);
	}

	@Override
	public List<Employee> findEmpByType(int i) {
		
		return this.empDao.findByType(i);
	}

	@Override
	public List<Employee> findAll() {
		return this.empDao.findAll();
	}

	@Override
	public List<Employee> findEmp(String empId, int deptno, int onDuty,
			Date hireDate) {
		
		return this.empDao.find(empId, deptno, onDuty, hireDate); 
	}

}
