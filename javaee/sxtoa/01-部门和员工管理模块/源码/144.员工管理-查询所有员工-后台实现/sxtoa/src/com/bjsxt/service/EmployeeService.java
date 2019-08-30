package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Employee;

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
	
	/**
	 * 查询所有员工
	 * @param i
	 * @return
	 */
	public List<Employee> findAll();
}
