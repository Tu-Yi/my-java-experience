package com.niliv.service;

import java.util.Date;
import java.util.List;

import com.niliv.entity.Employee;

public interface EmployeeService {
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	public int add(Employee emp);
	/**
	 * 查询指定类型的员工
	 * @param i
	 * @return
	 */
	public List<Employee> findEmpByType(int i);
	public List<Employee> findAll();
	public List<Employee> findEmp(String empId, int deptno, int onDuty, Date hireDate);
	public void delete(String empId);
	public Employee findById(String empId);
	public int update(Employee emp);
	public Employee login(String empId, String password);
	
	
}
