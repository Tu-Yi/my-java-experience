package com.niliv.application;

import java.util.List;

import com.niliv.pojo.Departments;
import com.niliv.service.DepartmentsService;
import com.niliv.service.impl.DepartmentsServiceImpl;

public class DepartmentsApplication {
	public static void main(String[] args) {
		
//		Departments departments = new Departments();
//		departments.setDEPARTMENT_NAME("haha");
//		departments.setDEPARTMENT_ID(500);
//		departments.setLOCATION_ID(1000);
//		
//		DepartmentsService dsService = new DepartmentsServiceImpl();
//		dsService.addDepartments(departments);
		
//		Departments departments = new Departments();
//		departments.setDEPARTMENT_NAME("yuankun");
//		departments.setDEPARTMENT_ID(500);
//		
//		DepartmentsService dsService = new DepartmentsServiceImpl();
//		int flag = dsService.modifyDepartments(departments);
//		System.out.println(flag);
		
		
//		DepartmentsService dsService = new DepartmentsServiceImpl();
//		int flag = dsService.dropDepartments(500);
//		System.out.println(flag);
		
		Departments departments = new Departments();
		DepartmentsService dsService = new DepartmentsServiceImpl();
		List<Departments> list = dsService.findDepartments("readyea");
		for (Departments dept : list) {
			System.out.println(dept.getDEPARTMENT_ID()+" " + dept.getDEPARTMENT_NAME());
		}
	}
}
