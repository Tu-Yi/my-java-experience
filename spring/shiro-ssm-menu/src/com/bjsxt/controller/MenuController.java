package com.bjsxt.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Users;

@Controller
@RequestMapping("/menu")
public class MenuController {
	//显示菜单
	@RequestMapping("/showMenu.do")
	@ResponseBody
	public List<Menu> showMenu(){
		Users user = (Users) SecurityUtils.getSubject().getPrincipal();
		return user.getMenus();
	}
}
