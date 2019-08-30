package com.bjsxt.handlers;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.Star;

//后端控制器
@Controller 
@Scope("prototype")
@RequestMapping("/springmvc")  
public class MyController{
	@RequestMapping("/hello")
	public void  hello(@RequestBody Star star){
		System.out.println(star);
	}
}
