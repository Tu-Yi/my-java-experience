package com.niliv.service;

import java.util.List;

import com.niliv.pojo.Departments;

public interface DepartmentsService {
	public void addDepartments(Departments departments);
	public int modifyDepartments(Departments departments);
	public int dropDepartments(int departments_id);
	public List<Departments> findDepartments(String department_name);
}
