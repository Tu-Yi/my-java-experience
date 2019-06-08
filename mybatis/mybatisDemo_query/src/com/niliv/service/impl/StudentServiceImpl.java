package com.niliv.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.niliv.mapper.ClazzMapper;
import com.niliv.mapper.StudentMapper;
import com.niliv.pojo.Student;
import com.niliv.service.StudentService;
import com.niliv.test.MyBatisUtil;


public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> selAll() {
		
		SqlSession session = MyBatisUtil.getSession();

		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		List<Student> list = sMapper.selAll();
		
		ClazzMapper cMapper = session.getMapper(ClazzMapper.class);
		
		
		for (Student student : list) {
			student.setClazz(cMapper.selById(student.getCid()));
		}
		
		session.close();
		return list;
	}

}
