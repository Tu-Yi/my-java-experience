package com.niliv.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niliv.pojo.User;
import com.niliv.service.UserService;
import com.niliv.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet({ "/DataServlet", "/data" })
public class DataServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		String methodName = request.getParameter("method");
		Class cla = this.getClass();
		try {
			Method m = cla.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		UserService uService = new UserServiceImpl();
		User user = uService.getUserInfoService(uname,pwd);
		System.out.println(user);
		HttpSession hs = request.getSession();
		if(user!=null) {
			hs.setAttribute("user", user);
			response.sendRedirect("/jsProject/main.jsp");
		}else {
			
			hs.setAttribute("flag", "loginFalse");
			response.sendRedirect("/jsProject/login.jsp");
		}
	}

	public void userOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession hs = request.getSession();
		hs.invalidate();
		response.sendRedirect("/jsProject/login.jsp");
	}

	public void userReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		UserService uService = new UserServiceImpl();
		int i = uService.regUserInfoService(uname,pwd);
		HttpSession hs = request.getSession();
		if(i>0) {
			hs.setAttribute("flag", "regSuccess");
			response.sendRedirect("/jsProject/login.jsp");
		}else {
			response.sendRedirect("/jsProject/login.jsp");

		}
	}
	
	public void selUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserService uService = new UserServiceImpl();
		List<User> users = uService.selUserInfoService();
		request.setAttribute("users", users);
		try {
			request.getRequestDispatcher("userList.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
		return;
	}

}
