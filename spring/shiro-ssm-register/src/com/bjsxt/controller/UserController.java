package com.bjsxt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.IUserService;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	/**
	 * 登录失败跳转的资源
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,Model model){
		//查看具体异常信息
		//获取异常信息名
		Object ex = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if(UnknownAccountException.class.getName().equals(ex)){
			model.addAttribute("msg", "账户不正确");
		}else if(IncorrectCredentialsException.class.getName().equals(ex)){
			model.addAttribute("msg", "凭证不正确");
		}else{
			model.addAttribute("msg", "未知验证异常");
		}
		return "/jsp/exception.jsp";
	}
	
	@RequestMapping(value="/register.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public String register(String username,String password){
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		userService.insertUser(user);
		return "注册成功！";
	}
}
