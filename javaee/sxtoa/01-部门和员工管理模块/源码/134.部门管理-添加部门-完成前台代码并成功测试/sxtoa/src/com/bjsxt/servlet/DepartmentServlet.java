package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Department;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.impl.DepartmentServiceImpl;

public class DepartmentServlet extends BaseServlet {
	
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String deptName = request.getParameter("deptName");
		String location = request.getParameter("location");
		
		//调用业务层完成添加操作
		DepartmentService  deptService = new DepartmentServiceImpl();
		Department dept = new Department(deptno, deptName, location);	
		int n = deptService.add(dept);
		
		//根据结果跳转到不同的页面
		if(n>0){
			//如果是表单的提交，成功之后建议使用重定向，避免表单的重复提交
			//request.getRequestDispatcher("/deptList.html").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/deptList.html");
		}else{
			request.setAttribute("error", "添加失败");
			//此时必须使用转发，因为要复用保存在request中的数据
			request.getRequestDispatcher("/system/deptAdd.jsp").forward(request, response);
			
		}
	}

	

}
