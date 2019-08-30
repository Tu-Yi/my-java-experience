package com.bjsxt.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.bjsxt.entity.Department;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.impl.DepartmentServiceImpl;
/**
 * @Test 进行测试
 * @Ignore 忽略该测试
 * 
 * 测试方法的命名 ： testMethod() 是建议不是必须
 * @author Administrator
 *
 */
public class TestDepartService {
	@Test
	public void testDelete(){
		DepartmentService  deptService = new DepartmentServiceImpl();
		deptService.delete(4);
	}
	
	
	@Ignore
	@Test
	public void testAdd(){
		DepartmentService  deptService = new DepartmentServiceImpl();
		
		Department dept = new Department(1, "总裁办", "502");
		
		int n = deptService.add(dept);
		System.out.println(n);
	}
	
	@Test
	public void testFindAll(){
		DepartmentService  deptService = new DepartmentServiceImpl();
		List<Department> list = deptService.findAll();
		System.out.println(list.size());
		
	}
}
