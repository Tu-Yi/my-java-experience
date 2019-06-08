package com.niliv.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.niliv.common.Tools;
import com.niliv.pojo.Employees;
import com.niliv.service.EmployeesService;
import com.niliv.service.impl.EmployeesServiceImpl;

public class TestMyBatis {
	
@Test
public void testInsertBatch() {
	
	List<Employees> list = new ArrayList<Employees>();
	Employees employees = null;
	for (int i = 0; i < 100; i++) {
		employees = new Employees();
		employees.setId(i+1);
		employees.setName(Tools.randomString(3));
		employees.setCreateDate(Tools.randomDate("2016-01-01 00:00:00","2018-12-31 23:59:59"));
		employees.setBirthday(Tools.randomDate("2000-01-01 00:00:00","2003-12-31 23:59:59"));
		employees.setSalary((int) ( 27000 * Math.random() + 3000));
		employees.setDid((int)(Math.round(Math.random()*2)+1)*10);
		list.add(employees);
	}
	EmployeesService es = new EmployeesServiceImpl();
	int flag = es.insertBatch(list);
	if(flag>0) {
		System.out.println("插入成功");
	}else {
		System.out.println("插入失败");
	}
}
	
@Test
public void testDel() {
	EmployeesService es = new EmployeesServiceImpl();
	int flag = es.delEmployees(100);
	if(flag>0) {
		System.out.println("删除成功");
	}else {
		System.out.println("删除失败");
	}
}
	
@Test
public void testUpdateSalaryById() {
	EmployeesService es = new EmployeesServiceImpl();
	int flag = es.updateSalaryById(2, 8888);
	if(flag>0) {
		System.out.println("更新成功");
	}else {
		System.out.println("更新失败");
	}
}
	
@Test
public void testUpdateDidById() {
	
	Employees employees = new Employees();
	employees.setId(3);
	employees.setDid(10);
	
	EmployeesService es = new EmployeesServiceImpl();
	int flag = es.updateDidByid(employees);
	if(flag>0) {
		System.out.println("更新成功");
	}else {
		System.out.println("更新失败");
	}
}
	
	
@Test
public void testQueryBySalary() {
	EmployeesService es = new EmployeesServiceImpl();
	List<Employees> list = es.queryBySalary(5000, 15000);
	System.out.println(list);
}
	
@Test
public void testQueryByDid() {
	EmployeesService es = new EmployeesServiceImpl();
	List<Employees> list = es.queryByDid(20);
	System.out.println(list);
}

@Test
public void testQueryThanAvgSalary() {
	EmployeesService es = new EmployeesServiceImpl();
	List<Employees> list = es.queryThanAvgSalary();
	System.out.println(list);
}
	
	
	
}
