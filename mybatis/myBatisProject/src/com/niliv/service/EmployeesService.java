package com.niliv.service;

import java.util.List;

import com.niliv.pojo.Employees;

public interface EmployeesService {
	
	int insertBatch(List<Employees> list);
	
	int delEmployees(int id);
	
	int updateSalaryById(int id,int salary);
	
	int updateDidByid(Employees employees);
	
	List<Employees> queryBySalary(int sSalary,int eSalary);
	
	List<Employees> queryByDid(int did);
	
	List<Employees> queryThanAvgSalary();
}
