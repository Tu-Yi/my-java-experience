package com.bjsxt.mapper;

import com.bjsxt.pojo.Account;

public interface IAccountMapper {
	//新增
	void insertAccount(String aname,double balance);
	//更新
	void updateAccount(Account account);
}
