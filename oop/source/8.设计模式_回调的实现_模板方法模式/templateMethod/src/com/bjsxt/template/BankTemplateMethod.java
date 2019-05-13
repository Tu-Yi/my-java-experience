package com.bjsxt.template;

public abstract class BankTemplateMethod {
	public void takeNumber(){
		System.out.println("排队取号");
	}
	public abstract void transant();//具体办理的业力
	
	public void evaluate(){
		System.out.println("给操作员评分");
	}
	//办理业务的流程
	public void process(){
		//(1)取号
		this.takeNumber();
		//(2)办理业务
		this.transant();
		//(3)评分
		this.evaluate();
	}
}
