package com.bjsxt.thread;

public class MyThread2 implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("MyThread2.run(),�߳̿�ʼ����");
			Thread.sleep(3000);
			System.out.println("MyThread2.run(),���߽���");
		} catch (InterruptedException e) {
			System.out.println("MyThread2.run(),�����쳣");
		}
	}
}
