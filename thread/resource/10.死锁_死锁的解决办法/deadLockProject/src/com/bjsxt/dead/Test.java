package com.bjsxt.dead;

public class Test {
	public static void main(String[] args) {
		//创建共享资源的对象
		Object money=new Object();
		Object water=new Object();
		//创建线程类的对象
		DeadLock d1=new DeadLock(money, water);
		DeadLock d2=new DeadLock(money, water);
		d1.flag=true;
		d2.flag=false;
		//启动线程
		d1.start();
		d2.start();
	}
}
