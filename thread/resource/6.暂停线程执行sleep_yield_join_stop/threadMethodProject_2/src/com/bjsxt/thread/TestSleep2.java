package com.bjsxt.thread;

public class TestSleep2 {
	/**
	 * sleep�����ᵼ���߳̽���������д �ĸ��߳����оͻᵼ���ĸ��߳̽�������״̬*/
	public static void main(String[] args) throws InterruptedException {
		MyThread2 my=new MyThread2();
		Thread t=new Thread(my);
		//�����߳�
		t.start();
		//���´���Ϊ���߳��еĴ���
		System.out.println("���߳̿�ʼ����");
		Thread.sleep(2000);
		System.out.println("���߳����߽���");
	}
}
