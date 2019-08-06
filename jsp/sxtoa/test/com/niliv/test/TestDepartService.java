package com.niliv.test;

import java.util.List;

import org.junit.Test;

import com.niliv.entity.Department;
import com.niliv.service.DepartmentService;
import com.niliv.service.impl.DepartmentServiceImpl;

public class TestDepartService {
	
	@Test
	public void testAdd() {
		DepartmentService deptService = new DepartmentServiceImpl();
		
		Department dept = new Department(1,"总裁办","502");
		
		int n = deptService.add(dept);
		System.out.println(n);
	}
	
	@Test
	public void testFindAll() {
		DepartmentService deptService = new DepartmentServiceImpl();
		
		List<Department> depts = deptService.findAll();
		System.out.println(depts);
	}
	
	@Test
	public void testDelete() {
		DepartmentService deptService = new DepartmentServiceImpl();
		
		int n = deptService.delete(3);
		System.out.println(n);
	}
	
	@Test
	public void testFindById() {
		DepartmentService deptService = new DepartmentServiceImpl();
		
		List<Department> depts = deptService.findAll();
		System.out.println(depts);
	}
}
