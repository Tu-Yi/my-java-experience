package com.bjsxt.thread;

public class TestYield {
	public static void main(String[] args) {
		MyThread3 my=new MyThread3();
		new Thread(my).start();//启动线程
		//主线程中的循环
		for(int i=0;i<10;i++){
			if(i==5){
				Thread.yield();//主线程礼让一次
				System.out.println(Thread.currentThread().getName()+"线程礼让一次");
			}
			System.out.println(Thread.currentThread().getName()+"------------"+i);
		}
	}
}
