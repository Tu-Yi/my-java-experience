package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {

	/**
	 * ��������ѧ����Ϣ
	 * @return
	 */
	public List<Student> findAll();	
	/**
	 * ����id��ѯѧ����Ϣ
	 * @param id
	 * @return
	 */
	public Student findById(int id);
	/**
	 * ���ѧ����Ϣ
	 * @param stu
	 * @return
	 */
	public int save(Student stu);
	/**
	 * ����ѧ����Ϣ
	 * @param stu
	 * @return
	 */
}
