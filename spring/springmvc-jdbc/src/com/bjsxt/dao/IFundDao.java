package com.bjsxt.dao;

import com.bjsxt.pojo.Fund;

public interface IFundDao {
	//新增
	void insertFund(String fname,int amount);
	//更新
	void updateFund(Fund fund);
}
