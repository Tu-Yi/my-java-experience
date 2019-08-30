package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Department;
import com.bjsxt.entity.Duty;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.bjsxt.service.impl.DutyServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DutyServlet extends BaseServlet {

	public void findDuty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取三个查询条件
		String empId = request.getParameter("empId");
		String sdeptno = request.getParameter("deptno");//null  ""
		int deptno = 0;
		try{
			deptno = Integer.parseInt(sdeptno);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		String sdtDate = request.getParameter("dtDate");//234r1324  null
		java.sql.Date dtDate = null;
		try{
			dtDate = java.sql.Date.valueOf(sdtDate);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		
		//调用业务层完成查询操作
		DutyService dutyService = new DutyServiceImpl();
		List<Duty> dutyList = dutyService.findDuty(empId,deptno,dtDate);
		
		//返回json字符串
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String jsonStr = gson.toJson(dutyList);
		out.println(jsonStr);
		
		
	}
	
	public void findAllDept(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//调用业务层获取所有的部门
		DepartmentService  deptService = new DepartmentServiceImpl();		
		List<Department> deptList = deptService.findAll();
		
		//不需要页面跳转，直接返回内容
		//request.setAttribute("deptList", deptList);
		//request.getRequestDispatcher("/system/deptList.jsp").forward(request, response);
		
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		Gson gson = new Gson();
//		String jsonStr = gson.toJson(deptList);
//		out.println(jsonStr);
		response.getWriter().println(new Gson().toJson(deptList));
		
	}
	
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
