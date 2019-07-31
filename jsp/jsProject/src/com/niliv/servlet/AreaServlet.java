package com.niliv.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.niliv.pojo.Area;
import com.niliv.service.AreaService;
import com.niliv.service.impl.AreaServiceImpl;

/**
 * Servlet implementation class AreaServlet
 */
@WebServlet({ "/AreaServlet", "/area" })
public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaServlet() {
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
		
		String pid = request.getParameter("parentid");
		
		AreaService as = new AreaServiceImpl();
		List<Area> list = as.getAreaInfoService(pid);
		response.getWriter().write(new Gson().toJson(list));
		
	}

}
