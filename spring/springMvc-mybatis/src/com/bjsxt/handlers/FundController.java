package com.bjsxt.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.Account;
import com.bjsxt.pojo.Fund;
import com.bjsxt.service.FundService;

//后端控制器
@Controller 
@Scope("prototype")
@RequestMapping("/springmvc")  
public class FundController{
	@Autowired
	private FundService fundService;
	
	public FundService getFundService() {
		return fundService;
	}

	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	@RequestMapping("/buyFund")
	public String  buyFund(Account account,Fund fund){
		fundService.modify(account, fund);
		return "welcome";
	}

}
