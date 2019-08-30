package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentService {

	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> findAll();
	

}
