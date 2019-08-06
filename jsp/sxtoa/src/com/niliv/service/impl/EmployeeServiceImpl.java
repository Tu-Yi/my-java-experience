package com.niliv.service.impl;

import java.util.Date;
import java.util.List;

import com.niliv.dao.EmployeeDao;
import com.niliv.dao.impl.EmployeeDaoImpl;
import com.niliv.entity.Employee;
import com.niliv.service.EmployeeService;

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
	public List<Employee> findEmp(String empId, int deptno, int onDuty, Date hireDate) {
		
		return this.empDao.findEmp(empId,deptno,onDuty,hireDate);
	}

	@Override
	public void delete(String empId) {
		this.empDao.delete(empId);
	}

	@Override
	public Employee findById(String empId) {
		
		return this.empDao.findById(empId);
	}

	@Override
	public int update(Employee emp) {
		
		return this.empDao.update(emp);
	}


}
