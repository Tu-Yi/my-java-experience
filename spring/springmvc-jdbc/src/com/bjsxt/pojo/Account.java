package com.bjsxt.pojo;

public class Account {
	private String aname;
	private double money;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String aname, double money) {
		super();
		this.aname = aname;
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [aname=" + aname + ", money=" + money + "]";
	}
	
	
}
