package com.bjsxt.proxy;

public class MarryCompany implements Marry{
	//婚 庆公司给准备结婚的人，准备婚 礼....
	private Marry m;
	 public MarryCompany(Marry m) {
		this.m=m;
	}
	
	 public void after(){
		 System.out.println("收拾东西............");
	 }
	 public void before(){
		 System.out.println("婚礼前的一些准备工作...........");
	 }
	@Override
	public void marry() {
		this.before();
		m.marry();//调用真实角色的结婚的方法
		this.after();
	}

}
