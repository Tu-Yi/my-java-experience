package com.bjsxt.thread;

public class Test {
	public static void main(String[] args) {
		//�����߳���Ķ���
		MyThread my=new MyThread();
		my.start();//�����߳�
		//my.run(); //��ִ��run�����д��룬run()ִ�н�������ȥִ������Ĵ�ӡ���
		System.out.println("---------main");
	}
}
