package com.niliv.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet({ "/BaseServlet", "/base" })
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
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
		
		String methodName = request.getParameter("method");
		Class cla = this.getClass();
		try {
			Method m = cla.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}	}

}
