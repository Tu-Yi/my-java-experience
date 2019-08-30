package com.bjsxt.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.bjsxt.dao.IAccountDao;
import com.bjsxt.pojo.Account;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
	//新增
	@Override
	public void insertAccount(String aname, double balance) {
		String sql="insert into account(aname,balance) values(?,?)";
		this.getJdbcTemplate().update(sql, aname,balance);
	}
	//更新
	@Override
	public void updateAccount(Account account) {
		String sql="update account set balance=balance-? where aname=?";
		this.getJdbcTemplate().update(sql, account.getMoney(),account.getAname());
	}

}
