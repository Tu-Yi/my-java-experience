package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Student;
import com.bjsxt.util.PageBean;

public interface StudentService {

	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	public List<Student> findAll();
	/**
	 * ��ɻ����ķ�ҳ������������ѯ������
	 * @param pageBean
	 */
	public void findStu(PageBean<Student> pageBean);
	/**
	 * ��ɷ�ҳ����������ѯ������
	 * @param pageBean
	 */
	public void findStu(PageBean<Student> pageBean, String name, double minScore);
	

}
