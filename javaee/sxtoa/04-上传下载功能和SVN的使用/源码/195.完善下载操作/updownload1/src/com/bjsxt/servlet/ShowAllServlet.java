package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;

public class ShowAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  	//���ղ�ѯ�������в�ѯ
	  	StudentService stuBiz = new StudentServiceImpl();
	  	List<Student> stuList = stuBiz.findAll();
	  	request.setAttribute("stuList2", stuList);	  
		//ҳ����ת
	  	request.getRequestDispatcher("/showAll.jsp").forward(request, response);
	}

}