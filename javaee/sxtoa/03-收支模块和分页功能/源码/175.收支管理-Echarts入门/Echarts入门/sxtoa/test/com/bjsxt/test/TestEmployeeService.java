package com.bjsxt.test;

import java.util.List;

import org.junit.Test;

import com.bjsxt.entity.Employee;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.impl.EmployeeServiceImpl;

public class TestEmployeeService {
	
	@Test
	public void testFindAll(){
		EmployeeService  empService = new EmployeeServiceImpl();
		List<Employee> empList = empService.findAll();
		System.out.println(empList);
	}
}
