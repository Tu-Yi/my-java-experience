package com.bjsxt.thread;

public class TestYield {
	public static void main(String[] args) {
		MyThread3 my=new MyThread3();
		new Thread(my).start();//�����߳�
		//���߳��е�ѭ��
		for(int i=0;i<10;i++){
			if(i==5){
				Thread.yield();//���߳�����һ��
				System.out.println(Thread.currentThread().getName()+"�߳�����һ��");
			}
			System.out.println(Thread.currentThread().getName()+"------------"+i);
		}
	}
}
