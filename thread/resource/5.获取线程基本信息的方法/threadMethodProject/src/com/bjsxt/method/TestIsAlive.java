package com.bjsxt.method;

public class TestIsAlive {
	public static void main(String[] args) {
		//���߳�
		MyThread my=new MyThread();
		System.out.println("�߳�my��������״̬���Ƿ��ڻ״̬:"+my.isAlive());
		my.start();//�����߳�
		System.out.println("�߳�my���ھ���״̬���߳��Ƿ��ڻ״̬:"+my.isAlive());
		//���߳��е�ѭ��
		for(int i=0;i<10;i++){
			System.out.println("----------"+Thread.currentThread().getName()+"--------->"+i);
		}
		//���߳��е����һ�����
		System.out.println("my�߳��Ƿ��ڻ״̬:"+my.isAlive());
	}
}
class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"---------->"+i);
		}
	}
}