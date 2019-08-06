package com.niliv.dao;

import java.util.Date;
import java.util.List;

import com.niliv.entity.Employee;

public interface EmployeeDao {
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	public int save(Employee emp);
	/**
	 * 查询指定类型的员工
	 * @param i
	 * @return
	 */
	public List<Employee> findByType(int type);
	public List<Employee> findAll();
	public List<Employee> findEmp(String empId, int deptno, int onDuty, Date hireDate);
	public void delete(String empId);
	public Employee findById(String empId);
	public int update(Employee emp);
	
	
}
