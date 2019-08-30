package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {

	/**
	 * 查找所有学生信息
	 * @return
	 */
	public List<Student> findAll();	
	/**
	 * 按照id查询学生信息
	 * @param id
	 * @return
	 */
	public Student findById(int id);
	/**
	 * 添加学生信息
	 * @param stu
	 * @return
	 */
	public int save(Student stu);
	/**
	 * 更新学生信息
	 * @param stu
	 * @return
	 */
}
