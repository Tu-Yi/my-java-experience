package com.bjsxt.method;

public class TestGetName {
	public static void main(String[] args) {
		//主线程的名称
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("主线程的名称:"+name);
		
		//创建MyRunnable类的对象
		MyRunnable my=new MyRunnable();
		Thread t1=new Thread(my,"自定义的线程1");
		Thread t2=new Thread(my,"线程2");
		Thread t3=new Thread(my,"线程3");
		System.out.println("修改之前:"+t3.getName());
		//修改线程的名称
		t3.setName("自定义的线程------------3");
		System.out.println("修改之后:"+t3.getName());
		
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}
