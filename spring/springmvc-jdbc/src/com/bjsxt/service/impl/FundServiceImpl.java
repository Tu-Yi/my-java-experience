package com.bjsxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.dao.IAccountDao;
import com.bjsxt.dao.IFundDao;
import com.bjsxt.pojo.Account;
import com.bjsxt.pojo.Fund;
import com.bjsxt.service.FundService;

@Service
public class FundServiceImpl implements FundService {
	@Autowired
	private IAccountDao accountDao;
	@Autowired
	private IFundDao fundDao;
	
	public IAccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public IFundDao getFundDao() {
		return fundDao;
	}
	public void setFundDao(IFundDao fundDao) {
		this.fundDao = fundDao;
	}
	//新增银行账户
	@Override
	public void addAccount(Account account) {
		accountDao.insertAccount(account.getAname(), account.getMoney());
	}
	//新增基金账户
	@Override
	public void addFund(Fund fund) {
		fundDao.insertFund(fund.getFname(), fund.getCount());
	}
	//购买基金（更新）
	@Override
	public void modify(Account account, Fund fund) {
		accountDao.updateAccount(account);
		fundDao.updateFund(fund);
	}

}
