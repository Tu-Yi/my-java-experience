package com.niliv.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
		
		session.close();
		return list;
	}

	@Override
	public int insStu(Student student) {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		
		int flag = sMapper.insStu(student);
		
		session.close();
		return flag;
	}

	@Override
	public int updStu(int id, int age) {
		
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		
		int flag = sMapper.updStu(id, age);
		
		session.close();
		return flag;
	}

	@Override
	public int delStu(int id) {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		
		int flag = sMapper.delStu(id);
		
		session.close();
		return flag;
	}

	@Override
	public List<Student> sel() {
		SqlSession session = MyBatisUtil.getSession();

		StudentMapper sMapper = session.getMapper(StudentMapper.class);
		List<Student> list = sMapper.sel();
		
		session.close();
		return list;
	}

}
