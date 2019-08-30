package com.bjsxt.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.bjsxt.dao.IFundDao;
import com.bjsxt.pojo.Fund;

@Repository
public class FundDaoImpl extends JdbcDaoSupport implements IFundDao {
	//新增
	@Override
	public void insertFund(String fname, int amount) {
		String sql="insert into fund(fname,amount) values(?,?)";
		this.getJdbcTemplate().update(sql, fname,amount);
	}
	//更新
	@Override
	public void updateFund(Fund fund) {
		String sql = "update fund set amount=amount+? where fname=?";
		this.getJdbcTemplate().update(sql, fund.getCount(),fund.getFname());
	}

}
