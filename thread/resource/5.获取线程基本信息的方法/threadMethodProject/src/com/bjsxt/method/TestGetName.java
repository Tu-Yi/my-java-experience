package com.bjsxt.method;

public class TestGetName {
	public static void main(String[] args) {
		//���̵߳�����
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("���̵߳�����:"+name);
		
		//����MyRunnable��Ķ���
		MyRunnable my=new MyRunnable();
		Thread t1=new Thread(my,"�Զ�����߳�1");
		Thread t2=new Thread(my,"�߳�2");
		Thread t3=new Thread(my,"�߳�3");
		System.out.println("�޸�֮ǰ:"+t3.getName());
		//�޸��̵߳�����
		t3.setName("�Զ�����߳�------------3");
		System.out.println("�޸�֮��:"+t3.getName());
		
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
	}
}
