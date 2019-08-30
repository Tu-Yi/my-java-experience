package com.bjsxt.dao;

import java.util.Date;
import java.util.List;

import com.bjsxt.entity.Employee;

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
	
	/**
	 * 查询所有员工
	 * @param i
	 * @return
	 */
	public List<Employee> findAll();
	/**
	 * 多条件查询员工信息，不带分页
	 * @param empId
	 * @param deptno
	 * @param onDuty
	 * @param hireDate
	 * @return
	 */
	public List<Employee> find(String empId, int deptno, int onDuty,
			Date hireDate);
}
