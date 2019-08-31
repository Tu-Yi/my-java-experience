package com.bjsxt.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Funs;
import com.bjsxt.pojo.Users;
/**
 * 权限过滤器
 * @author Administrator
 *
 */
public class SafeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse res = (HttpServletResponse)arg1;
		String uri = req.getRequestURI();
		//对静态资源做放行处理
		if(uri.endsWith(".js") || uri.endsWith(".css")|| uri.endsWith(".gif")){
			chain.doFilter(arg0, arg1);
		}else{
			//对用户登录资源做放行
			if(uri.indexOf("login") != -1 || uri.indexOf("userLogin") != -1){
				chain.doFilter(arg0, arg1);
			}else{
				HttpSession session = req.getSession();
				Users user = (Users)session.getAttribute("user");
				List<Funs> funs = user.getFuns();
				//开关
				boolean flag = false;
				for(Funs f:funs){
					//判断当前访问的URI是否在功能数据中包含
					if(uri.indexOf(f.getFunurl()) != -1){
						flag = true;
						break;
					}
				}
				//根据开关的值来进行跳转
				if(flag){
					chain.doFilter(arg0, arg1);
				}else{
					res.sendRedirect("roleerror");
				}
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
