package com.bjsxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.IAccountMapper;
import com.bjsxt.mapper.IFundMapper;
import com.bjsxt.pojo.Account;
import com.bjsxt.pojo.Fund;
import com.bjsxt.service.FundService;

@Service
public class FundServiceImpl implements FundService {
	@Autowired
	private IAccountMapper accountDao;
	@Autowired
	private IFundMapper fundDao;
	
	public IAccountMapper getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(IAccountMapper accountDao) {
		this.accountDao = accountDao;
	}
	public IFundMapper getFundDao() {
		return fundDao;
	}
	public void setFundDao(IFundMapper fundDao) {
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
