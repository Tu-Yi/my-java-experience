package com.niliv.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niliv.entity.Department;
import com.niliv.service.DepartmentService;
import com.niliv.service.impl.DepartmentServiceImpl;

import oracle.net.aso.l;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet({ "/DepartmentServlet", "/dept" })
public class DepartmentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptNo = Integer.parseInt(request.getParameter("deptno"));
		String deptName = request.getParameter("deptName");
		String location = request.getParameter("location");
		
		DepartmentService deptService = new DepartmentServiceImpl();
		Department dept = new Department(deptNo,deptName,location);
		int n = deptService.add(dept);
		
		if(n>0) {
			response.sendRedirect(request.getContextPath() + "/DepartmentServlet?method=findAll");
		}else {
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/system/deptAdd.jsp").forward(request, response);
		}
	}
	
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAll();
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/system/deptList.jsp").forward(request, response);
	}
	
	public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int deptNo = Integer.parseInt(request.getParameter("deptno"));
		DepartmentService deptService = new DepartmentServiceImpl();
		Department dept = deptService.findById(deptNo);
		
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("/system/deptUpdate.jsp").forward(request, response);
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptNo = Integer.parseInt(request.getParameter("deptno"));
		
		DepartmentService deptService = new DepartmentServiceImpl();
		int n = deptService.delete(deptNo);
		
		request.getRequestDispatcher("DepartmentServlet?method=findAll").forward(request, response);
		
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptNo = Integer.parseInt(request.getParameter("deptno"));
		String deptName = request.getParameter("deptname");
		String location = request.getParameter("location");
		
		DepartmentService deptService = new DepartmentServiceImpl();
		Department dept = new Department(deptNo,deptName,location);
		int n = deptService.update(dept);
		
		if(n>0) {
			response.sendRedirect(request.getContextPath() + "/DepartmentServlet?method=findAll");
		}else {
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/system/deptUpdate.jsp").forward(request, response);
		}
	}

}
