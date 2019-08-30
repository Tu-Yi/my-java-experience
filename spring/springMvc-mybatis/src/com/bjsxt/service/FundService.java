package com.bjsxt.service;

import com.bjsxt.pojo.Account;
import com.bjsxt.pojo.Fund;

public interface FundService {
	//新增银行账户
	void addAccount(Account account);
	//新增基金账户
	void addFund(Fund fund);
	//更新（购买基金）
	void modify(Account account,Fund fund);
}
