package com.bjsxt.thread;

public class TestSleep {
	public static void main(String[] args) throws InterruptedException {
		Thread t=Thread.currentThread();//获取当前的线程对象,主线程
		System.out.println(t);
		//在哪个线程中就对哪个线程起作用
		Thread.sleep(2000);
		System.out.println(t);
	}
}
