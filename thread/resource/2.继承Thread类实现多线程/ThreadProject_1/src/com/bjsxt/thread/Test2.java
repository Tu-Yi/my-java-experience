package com.bjsxt.thread;

public class Test2 {
	public static void main(String[] args) {//���߳�
		//�����߳���Ķ���
		MyThread2 my=new MyThread2();
		//�����߳�
		my.start();
		
		//���߳��е�forѭ��
		for(int i=0;i<10;i++){
			System.out.println("------main---"+i);
		}
	}
}
