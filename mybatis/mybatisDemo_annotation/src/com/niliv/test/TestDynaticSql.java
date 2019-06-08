package com.niliv.test;

import java.util.List;

import org.junit.Test;

import com.niliv.pojo.Student;
import com.niliv.service.StudentService;
import com.niliv.service.impl.StudentServiceImpl;

public class TestDynaticSql {
	
	@Test
	public void testDynamicSql() {
		
		StudentService ssService = new StudentServiceImpl();
		List<Student> list = ssService.selAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testInsert() {
		
		Student student = new Student();
		student.setName("喵喵");
		student.setAge(3);
		student.setGender("女");
		student.setCid(2);
		
		StudentService ssService = new StudentServiceImpl();
		int flag = ssService.insStu(student);
		System.out.println(flag);
	}
	
	@Test
	public void testUpdate() {
		
		
		StudentService ssService = new StudentServiceImpl();
		int flag = ssService.updStu(6, 12);
		System.out.println(flag);
	}
	
	@Test
	public void testDelete() {
		
		
		StudentService ssService = new StudentServiceImpl();
		int flag = ssService.delStu(6);
		System.out.println(flag);
	}
	@Test
	public void testSel() {
		
		StudentService ssService = new StudentServiceImpl();
		List<Student> list = ssService.sel();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
