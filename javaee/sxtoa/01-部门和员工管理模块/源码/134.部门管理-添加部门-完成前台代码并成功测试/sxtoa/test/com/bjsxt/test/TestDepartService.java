package com.bjsxt.test;

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
	
	@Ignore
	@Test
	public void testAdd(){
		DepartmentService  deptService = new DepartmentServiceImpl();
		
		Department dept = new Department(1, "总裁办", "502");
		
		int n = deptService.add(dept);
		System.out.println(n);
	}
}
