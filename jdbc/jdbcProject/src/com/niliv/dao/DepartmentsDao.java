package com.niliv.dao;

import java.util.List;

import com.niliv.pojo.Departments;
import com.niliv.pojo.Users;

public interface DepartmentsDao extends BaseDao {
	public List<Departments> selectDepartmentsByName(String departments_name);
	public void insertDepartments(Departments departments);
	public int updateDepartments(Departments departments);
	public int deleteDepartmentsById(int department_id);
	public List<Departments> selectDeptByName(String department_name);
}
