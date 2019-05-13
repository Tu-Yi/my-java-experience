package com.bjsxt.thread;

public class MyThread2 implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("MyThread2.run(),线程开始休眠");
			Thread.sleep(3000);
			System.out.println("MyThread2.run(),休眠结束");
		} catch (InterruptedException e) {
			System.out.println("MyThread2.run(),产生异常");
		}
	}
}
