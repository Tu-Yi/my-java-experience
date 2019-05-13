package com.bjsxt.dead;

public class Test2 {
	public static void main(String[] args) {
		//创建共享资源的对象
		Object money=new Object();
		Object water=new Object();
		//创建线程类的对象
		DeadLock2 d1=new DeadLock2(money, water);
		DeadLock2 d2=new DeadLock2(money, water);
		d1.flag=true;
		d2.flag=false;
		//启动线程
		d1.start();
		d2.start();
	}
}
