package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.util.PageBean;

public class StudentServiceImpl implements StudentService {

	private StudentDao stuDao = new StudentDaoImpl();	

	public List<Student> findAll() {		
		return this.stuDao.findAll();
	}

	public void findStu(PageBean<Student> pageBean) {
		//��ѯ���ݿ���ȡ��¼����
		//int totalCount = this.stuDao.findAll().size();//????
		int totalCount = this.stuDao.findCount();
		System.out.println("count="+totalCount);
		//ʹ�ü�¼��������PageBean�е���������(totalCount,totalPageCount,numbers)���Ͳ�list����
		pageBean.setTotalCount(totalCount);
		
		
		//����DAO���ȡָ��ҳ��ѧ�����ݣ�������pageBean��list����
		/*
		 *ÿҳsize = 5����¼ 
		 *  �ڼ�ҳ    ��ʼ��¼��>=    ������¼��<=    <
		 *  1      0            4             5
		 *  2      5           9             10
		 *  3      10           14            15
		 *  
		 *  index    (index-1)*size                          index*size
		 *  
		 */
		//int start = (pageBean.getIndex()-1)*pageBean.getSize();
		//int end=  pageBean.getIndex()*pageBean.getSize();
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();
		List<Student> list = this.stuDao.findStu(start,end);
		pageBean.setList(list);
		
	}

	public void findStu(PageBean<Student> pageBean, String name, double minScore) {
		//��ѯ���ݿ���ȡ���ϲ�ѯ�����ļ�¼����
		int totalCount = this.stuDao.findCount(name,minScore);
		System.out.println("count="+totalCount);
		
		//ʹ�ü�¼��������PageBean�е���������(totalCount,totalPageCount,numbers)���Ͳ�list����
		pageBean.setTotalCount(totalCount);
		
		
		//����DAO���ȡָ��ҳ��ѧ�����ݣ�������pageBean��list����				
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();
		List<Student> list = this.stuDao.findStu(start,end,name,minScore);
		pageBean.setList(list);
		
	}

}
