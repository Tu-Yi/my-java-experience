package com.bjsxt.thread;

public class TestJoin {
	public static void main(String[] args) throws InterruptedException {
		//���߳�
		MyThread my=new MyThread();
		Thread t=new Thread(my);
		Thread t2=new Thread(my);
		//�����߳�
		t.start();
		t2.start();
		//���´���Ϊ���߳��е�ѭ��
		for(int i=0;i<10;i++){
			if(i==3){
				t.join();  //t�߳�ǿ��ִ��
			}
			System.out.println("------------"+Thread.currentThread().getName()+"-------->"+i);
		}
	}
	/**
	 * ���µ��������߳̽�������״̬�������ᵼ���������߳�
	 * 
	 * */
}
