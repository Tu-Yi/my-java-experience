package com.bjsxt.dao;

import com.bjsxt.pojo.Account;

public interface IAccountDao {
	//新增
	void insertAccount(String aname,double balance);
	//更新
	void updateAccount(Account account);
}
