package com.niliv.servlet;

import java.io.IOException;
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
 * Servlet implementation class RegServlet
 */
@WebServlet({ "/RegServlet", "/reg" })
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
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

}
