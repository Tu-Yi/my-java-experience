package com.bjsxt.thread;

public class TestSleep {
	public static void main(String[] args) throws InterruptedException {
		Thread t=Thread.currentThread();//��ȡ��ǰ���̶߳���,���߳�
		System.out.println(t);
		//���ĸ��߳��оͶ��ĸ��߳�������
		Thread.sleep(2000);
		System.out.println(t);
	}
}
