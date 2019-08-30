package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.bjsxt.util.PageBean;

public class ShowAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1.1 接收从页面传入的当前页码index
		String sindex = request.getParameter("index"); // null ""
		int index = 1;// 默认当前页码数是1
		try {
			index = Integer.parseInt(sindex);//"5"
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		// 1.2 接收从页面传入的每页的记录数
		String ssize = request.getParameter("size"); // null ""
		int size = 5;// 默认当前页码数是1
		try {
			size = Integer.parseInt(ssize);//"5"
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		//1.3查询条件：接收学生姓名
		String name = request.getParameter("name");
		//1.4查询条件：接收最低分数
		String sminScore = request.getParameter("minScore"); //null "" "abc"
		if(sminScore ==null){
			sminScore = "";
		}
		double minScore =0;
		try{
			minScore = Double.parseDouble(sminScore);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
		// 2
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setIndex(index);
		pageBean.setSize(size);
		StudentService stuService = new StudentServiceImpl();
		//List<Student> stuList = stuBiz.findAll();
		//stuService.findStu(pageBean);//不需要返回stuList，因为经过业务层处理，所有的数据都在PageBean中
		stuService.findStu(pageBean,name,minScore);
		request.setAttribute("pageBean", pageBean);// !!!!!!!
		request.setAttribute("name", name);
		request.setAttribute("minScore", sminScore);
		// 3com.bjsxt

		request.getRequestDispatcher("/jsp/showAll.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
