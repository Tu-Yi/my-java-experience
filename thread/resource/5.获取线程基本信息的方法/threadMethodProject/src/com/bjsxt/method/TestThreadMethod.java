package com.bjsxt.method;

public class TestThreadMethod {
	//�����������߳�
	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		//toString()�����õ������� Ϊ [�߳�����,�̵߳����ȼ�,�߳��������]
		System.out.println(t.toString());
		
		//�߳��߳���Ķ���
		MyRunnable my=new MyRunnable();
		Thread t1=new Thread(my);
		Thread t2=new Thread(my);
		Thread t3=new Thread(my);
		
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
		/**��Thread����һ����һ����̬����int������ͳ�ƴ����̵߳ĸ��� */
		//�̵߳�Ĭ�ϵ���������  Thread - int���͵ı�����ֵ
	}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		Thread t=Thread.currentThread();
		System.out.println("�̵߳�����"+t.getName());
	}
	
}
