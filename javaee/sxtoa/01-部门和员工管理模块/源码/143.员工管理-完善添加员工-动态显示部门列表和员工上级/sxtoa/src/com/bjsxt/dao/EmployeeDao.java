package com.bjsxt.dao;

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
	
	
}
