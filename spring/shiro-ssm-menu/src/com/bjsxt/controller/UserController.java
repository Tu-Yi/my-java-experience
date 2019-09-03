package com.bjsxt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.IUserService;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	/**
	 * 设定登录失败跳转的资源以及获取异常信息
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,Model model){
		//查看具体异常信息，获取异常信息名
		Object ex = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if(UnknownAccountException.class.getName().equals(ex)){
			model.addAttribute("msg", "账户不正确");
		}else if(IncorrectCredentialsException.class.getName().equals(ex)){
			model.addAttribute("msg", "凭证不正确");
		}else{
			System.out.println(ex);
			model.addAttribute("msg", "未知验证异常");
		}
		return "/jsp/exception.jsp";
	}	
	
	//登录成功之后访问的处理器方法
	@RequestMapping("/loginSuccess.do")
	public String loginSuccess(){
		return "/jsp/main.jsp";
	}
	
}
