package com.niliv.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.niliv.pojo.Data;
import com.niliv.service.SearchService;
import com.niliv.service.impl.SearchServiceImpl;

/**
 * Servlet implementation class Search
 */
@WebServlet({ "/Search", "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		
		String sdata = request.getParameter("sdata");
		SearchService ss = new SearchServiceImpl();
		List<Data> list = ss.getSearchInfoService(sdata);
		response.getWriter().write(new Gson().toJson(list));
	}

}
