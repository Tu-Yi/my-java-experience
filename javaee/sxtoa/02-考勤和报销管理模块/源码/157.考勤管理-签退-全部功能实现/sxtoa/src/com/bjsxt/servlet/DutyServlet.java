package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Employee;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DutyServiceImpl;

public class DutyServlet extends BaseServlet {

	public void signout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取当前用户的empId
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String empId = emp.getEmpId();
		//调用业务层完成签退操作
		DutyService dutyService = new DutyServiceImpl();
		int n = dutyService.signout(empId); //1  成功  0 失败   2 没有签到
		
		//不需要页面跳转，直接返回内容
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(n==1){
			out.println("签退成功");
		}else if(n==0){
			out.println("签退失败");
		}else{
			out.println("尚未签到");
		}
	}
	
	public void signin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String empId = emp.getEmpId();
		//调用业务层完成签到操作
		DutyService dutyService = new DutyServiceImpl();
		int n = dutyService.signin(empId); //1  成功  0 失败   2 已经签到
		
		//不需要页面跳转，直接返回内容
		response.getWriter().println(n);
	}

}
