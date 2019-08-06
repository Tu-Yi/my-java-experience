package com.niliv.test;

import java.util.List;

import org.junit.Test;

import com.niliv.entity.Department;
import com.niliv.entity.Employee;
import com.niliv.service.DepartmentService;
import com.niliv.service.EmployeeService;
import com.niliv.service.impl.DepartmentServiceImpl;
import com.niliv.service.impl.EmployeeServiceImpl;

public class TestEmployeeService {
	@Test
	public void testFindAll() {
		EmployeeService deptService = new EmployeeServiceImpl();
		
		List<Employee> depts = deptService.findAll();
		System.out.println(depts);
	}
}
