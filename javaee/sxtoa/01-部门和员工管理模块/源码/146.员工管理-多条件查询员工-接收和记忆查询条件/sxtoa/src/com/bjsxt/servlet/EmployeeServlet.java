package com.bjsxt.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Department;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Position;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.bjsxt.service.impl.EmployeeServiceImpl;

public class EmployeeServlet extends BaseServlet {
	
	public void findEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收查询条件
		String empId = request.getParameter("empId");
		
		int deptno = 0;
		String sdeptno = request.getParameter("deptno"); //null
		try{
			deptno = Integer.parseInt(sdeptno);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		int onDuty = 1;
		String sonDuty = request.getParameter("onDuty");//null		
		try{
			onDuty = Integer.parseInt(sonDuty);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		String shireDate = request.getParameter("hireDate");//null
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hireDate = null;
		if(shireDate != null){
			try {
				hireDate = sdf.parse(shireDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//调用业务层获取所有的员工信息
		EmployeeService  empService = new EmployeeServiceImpl();
		//List<Employee> empList = empService.findAll();
		//条件如果多，可以封装到一个对象中，使用一个对象做参数
		List<Employee> empList = empService.findEmp(empId,deptno,onDuty,hireDate);
		//获取所有部门的信息
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAll();
		request.setAttribute("deptList", deptList);
		
		//跳转到system/empList.jsp
		request.setAttribute("empId", empId);
		request.setAttribute("deptno", deptno);
		request.setAttribute("onDuty", onDuty);
		request.setAttribute("hireDate", shireDate);
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("/system/empList.jsp").forward(request, response);
		
	}
	
	
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用业务层获取所有的员工信息
		EmployeeService  empService = new EmployeeServiceImpl();
		List<Employee> empList = empService.findAll();
		//获取所有部门的信息
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAll();
		request.setAttribute("deptList", deptList);
		
		//跳转到system/empList.jsp
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("/system/empList.jsp").forward(request, response);
		
	}
	
	public void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取所有的部门信息
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAll();
		request.setAttribute("deptList", deptList);
		//获取所有的岗位信息
		
		
		//获取上级员工
		EmployeeService empService = new EmployeeServiceImpl();
		List<Employee> mgrList = empService.findEmpByType(2);//1  基层员工  2 各级管理人员
		request.setAttribute("mgrList",mgrList);
		//跳转到system/empAdd.jsp
		request.getRequestDispatcher("/system/empAdd.jsp").forward(request, response);
	}
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取员工的信息
		String empId = request.getParameter("empId");
		String password ="123456";
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		//日期类型的处理
		String sbirthDate = request.getParameter("birthDate");
		String shireDate = request.getParameter("hireDate");
		String sleaveDate = request.getParameter("leaveDate");
		
		Date birthDate= null,hireDate = null,leaveDate = null;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			birthDate = sdf.parse(sbirthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			hireDate = sdf.parse(shireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			leaveDate = sdf.parse(sleaveDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//整数的处理
		int onDuty = Integer.parseInt(request.getParameter("onDuty"));
		int empType = Integer.parseInt(request.getParameter("empType"));
		
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String emerContactPerson = request.getParameter("emerContactPerson");
		String idCard = request.getParameter("idCard");
		
		//对象的处理
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Department dept = new Department();
		dept.setDeptno(deptno);
		
		int posId = Integer.parseInt(request.getParameter("posId"));
		Position position = new Position();
		position.setPosId(posId);
		String mgrId = request.getParameter("mgrId");
		Employee mgr = new Employee();
		mgr.setEmpId(mgrId);//!!!
		
		//调用业务层完成添加操作
		Employee emp = new Employee(empId, password, realName, sex, birthDate, hireDate, leaveDate, onDuty, empType, phone, qq, emerContactPerson, idCard, dept, position, mgr);
		EmployeeService  empService = new EmployeeServiceImpl();
		int n = empService.add(emp);
		
		//根据结果进行页面跳转
		if(n>0){
			response.sendRedirect(request.getContextPath()+"/empList.html");
		}else{
			request.setAttribute("error", "添加员工失败");
			request.getRequestDispatcher("/system/empAdd.jsp").forward(request, response);
		}
		
	}

	

}
