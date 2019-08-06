package com.niliv.service;

import java.util.List;

import com.niliv.entity.Department;

public interface DepartmentService {
	public int add(Department dept);

	public List<Department> findAll();

	public int delete(int deptNo);

	public Department findById(int deptNo);

	public int update(Department dept);
}
