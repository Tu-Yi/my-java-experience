package com.bjsxt.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//自定义拦截器
public class FirstInterceptor implements HandlerInterceptor {
	//该方法执行时机：处理器方法执行之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("First拦截器preHandle（）执行！");
		return true;
	}

	//该方法执行时机：处理器方法执行之后执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("First拦截器postHandle()执行！");

	}
	
	//该方法执行时机：所有工作处理完成之后，响应给浏览器客户端之前执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("First拦截器afterCompletion()执行！");

	}

}
