package com.bjsxt.thread;

public class TestSleep2 {
	/**
	 * sleep方法会导致线程进入阻塞，写 哪个线程体中就会导致哪个线程进入阻塞状态*/
	public static void main(String[] args) throws InterruptedException {
		MyThread2 my=new MyThread2();
		Thread t=new Thread(my);
		//启动线程
		t.start();
		//以下代码为主线程中的代码
		System.out.println("主线程开始休眠");
		Thread.sleep(2000);
		System.out.println("主线程休眠结束");
	}
}
