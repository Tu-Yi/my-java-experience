package com.niliv.dao;

import java.util.List;

import com.niliv.entity.Department;

public interface DepartmentDao {
	
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	public int save(Department dept);

	public List<Department> findAll();

	public int delete(int deptNo);

	public Department findById(int deptNo);

	public int update(Department dept);
}
