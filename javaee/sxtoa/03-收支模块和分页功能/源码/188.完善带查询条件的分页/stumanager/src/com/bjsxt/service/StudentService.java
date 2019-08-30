package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Student;
import com.bjsxt.util.PageBean;

public interface StudentService {

	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> findAll();
	/**
	 * 完成基本的分页操作（不带查询条件）
	 * @param pageBean
	 */
	public void findStu(PageBean<Student> pageBean);
	/**
	 * 完成分页操作（带查询条件）
	 * @param pageBean
	 */
	public void findStu(PageBean<Student> pageBean, String name, double minScore);
	

}
