package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> findAll();
	
}
