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
	
	
}
