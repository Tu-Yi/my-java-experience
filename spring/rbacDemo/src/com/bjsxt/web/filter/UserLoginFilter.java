package com.bjsxt.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Users;
/**
 * 判断用户是否登录
 * @author Administrator
 *
 */
public class UserLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		//获取用户访问的URI
		HttpServletRequest req = (HttpServletRequest)arg0;
		String uri = req.getRequestURI();
		
		//判断当前访问的URI是否是用户登录资源，如果是则放行
		if(uri.indexOf("login") != -1 || uri.indexOf("userLogin") != -1){
			chain.doFilter(arg0, arg1);
		}else{
			//用户是否登录的判断
			HttpSession session = req.getSession();
			Users user = (Users)session.getAttribute("user");
			if(user != null && user.getUsername().length() > 0){
				chain.doFilter(arg0, arg1);
			}else{
				req.setAttribute("msg", "请登录");
				req.getRequestDispatcher("/login").forward(arg0, arg1);
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
