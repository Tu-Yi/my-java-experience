package com.bjsxt.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.exception.UsersException;
import com.bjsxt.pojo.Funs;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/userLogin")
	public String userLogin(Users users,Model model,HttpServletRequest request){
		try{
			Users u = this.userService.userLogin(users.getUsername(), users.getUserpwd());
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
		}catch(UsersException e){
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "/login";
		}
		return "redirect:/index";
	}
}
