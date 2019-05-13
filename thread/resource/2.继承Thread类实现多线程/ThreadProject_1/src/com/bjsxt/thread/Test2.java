package com.bjsxt.thread;

public class Test2 {
	public static void main(String[] args) {//主线程
		//创建线程类的对象
		MyThread2 my=new MyThread2();
		//启动线程
		my.start();
		
		//主线程中的for循环
		for(int i=0;i<10;i++){
			System.out.println("------main---"+i);
		}
	}
}
