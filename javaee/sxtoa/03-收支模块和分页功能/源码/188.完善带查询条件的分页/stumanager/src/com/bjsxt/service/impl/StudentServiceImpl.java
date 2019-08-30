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
		//查询数据库表获取记录总数
		//int totalCount = this.stuDao.findAll().size();//????
		int totalCount = this.stuDao.findCount();
		System.out.println("count="+totalCount);
		//使用记录总数计算PageBean中的其他属性(totalCount,totalPageCount,numbers)，就差list属性
		pageBean.setTotalCount(totalCount);
		
		
		//调用DAO层获取指定页的学生数据，并放入pageBean的list属性
		/*
		 *每页size = 5条记录 
		 *  第几页    起始记录号>=    结束记录号<=    <
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
		//查询数据库表获取符合查询条件的记录总数
		int totalCount = this.stuDao.findCount(name,minScore);
		System.out.println("count="+totalCount);
		
		//使用记录总数计算PageBean中的其他属性(totalCount,totalPageCount,numbers)，就差list属性
		pageBean.setTotalCount(totalCount);
		
		
		//调用DAO层获取指定页的学生数据，并放入pageBean的list属性				
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();
		List<Student> list = this.stuDao.findStu(start,end,name,minScore);
		pageBean.setList(list);
		
	}

}
