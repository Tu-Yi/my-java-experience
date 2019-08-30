package com.bjsxt.mapper;

import com.bjsxt.pojo.Fund;

public interface IFundMapper {
	//新增
	void insertFund(String fname,int amount);
	//更新
	void updateFund(Fund fund);
}
