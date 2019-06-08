package com.niliv.test;

import java.util.List;

import org.junit.Test;

import com.niliv.pojo.Clazz;
import com.niliv.pojo.Student;
import com.niliv.service.ClazzService;
import com.niliv.service.impl.ClazzServiceImpl;

public class TestDynaticSql {
	
	@Test
	public void testDynamicSql() {
		
		ClazzService ssService = new ClazzServiceImpl();
		List<Clazz> list = ssService.selAll();
		for (Clazz clazz : list) {
			System.out.println(clazz);
		}
	}
	
	
}
