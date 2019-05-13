package com.bjsxt.proxy;

public class Test {
	public static void main(String[] args) {
		//创建真角色对象
		Marry y=new You(); //接口new 实现类
		//创建代理角角色
		Marry myc=new MarryCompany(y);
		myc.marry();
	}
}
