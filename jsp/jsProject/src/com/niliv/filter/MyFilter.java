package com.niliv.filter;

import java.io.IOException;
import java.util.Calendar;
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

import com.niliv.pojo.Url;
/**
 * Filter案例之统一编码格式:
 * 		在doFilter中使用
 * 				//设置请求编码格式
					request.setCharacterEncoding("utf-8");
				//设置响应编码格式
					response.setContentType("text/html;charset=utf-8");
	Filter案例之session管理
			在过滤器中获取session对象，然后查看session中的数据是否还在
			如果数据没了，则因为session失效则重定向到登录页面。如果数据还在
			session没有失效，则放行
			
			问题1：
				在过滤器中使用session校验后发现登录页面的访问成了死循环，因为登录页面的
				请求也就是login.jsp的请求也会被过滤器拦截，而此时session中没有相关数据的
				造成又重定向到登录页面......
			解决1：
				对login.jsp和登录请求进行放行
			问题2：
				过滤器会拦截所有的请求，包括静态资源（css文件\js文件\image图片）请求也会拦截。
				造成页面中的样式和动态效果等出不来
			解决2：
				对静态资源放行
	Filter案例之权限管理
			需求：
				不同的用户在对同一功能使用时，有的用户可以直接使用，有的用户会被提示权限不足。
			思路：
				1、在数据库中创建一个URL权限表，该表存储了该系统需要被管理的URL。
				2、在数据库中创建用户权限中间表，用来进行权限分配
				3、在数据库中将权限给用户分配好
				4、在用户登录成功后查询该用户具备的URL权限，存储到该用户的session中
				5、在过滤器中对当前发起请求的用户的请求地址进行校验，校验该用户是否具备该请求地址的
				权限，如果具备则放行执行，如果不具备则提示权限不足。
			数据库设计：
				URL权限表：t_url
					编号:  urlid
					url地址 :location
					描述：remark
				用户权限中间表：t_user_url
					uid
					urlid
			SQL语句的设计:查询当前登录用户的url信息
				子查询:
					select * from t_url where urlid in (select urlid from t_user_url where uid=8)
				联合查询:
					select * from t_url tu,t_user_url tul where tu.urlid=tul.urlid and tul.uid=8
 * @author MyPC
 *
 */
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//设置请求编码格式
		request.setCharacterEncoding("utf-8");
		//设置响应编码格式
		response.setContentType("text/html;charset=utf-8");
		//强转request对象
		HttpServletRequest req=((HttpServletRequest)request);
		//强转response对象
		HttpServletResponse resp=((HttpServletResponse)response);
		//获取此次请求uri
		String uri=req.getRequestURI();
		//获取此次请求的method
		String method=req.getParameter("method");
		System.out.println("当前请求的uri为:"+uri);
		Calendar c = Calendar.getInstance();
        // 获取当前时间的小时
        int hour = c.get(Calendar.HOUR_OF_DAY);
		//放行登录页面  放行登录请求 放行静态资源
		if("/jsProject/login.jsp".equals(uri) || ("/jsProject/data".equals(uri)&& "userLogin".equals(method)) || uri.startsWith("/jsProject/css/") || uri.startsWith("/jsProject/js/")|| uri.startsWith("/jsProject/images/")){
			//放行
			chain.doFilter(request, response);
		}else{
			if(hour >= 6 && hour < 20) {
				HttpSession session = req.getSession();
				Object obj=session.getAttribute("user");
				if(obj!=null){
					List<Url> lu=(List<Url>) session.getAttribute("lu");
					for(Url url:lu){
						if(url.getLocation().equals(method) || url.getLocation().equals(uri)){
							//放行
							chain.doFilter(request, response);
							return;
						}
					}
					resp.getWriter().write("power");
					return;
				}else{
					resp.sendRedirect("/jsProject/login.jsp");
				}
			}else {
				String str = hour < 6 ? "6点后再来！" : "明天6点再来！";
	            response.getWriter().write("<h3>本时间段禁止登陆操作，请" + str + "</h3>");
			}
			
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
