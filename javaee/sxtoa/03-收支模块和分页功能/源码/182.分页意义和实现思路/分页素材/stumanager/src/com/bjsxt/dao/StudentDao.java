package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {
	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	public List<Student> findAll();
	
}
