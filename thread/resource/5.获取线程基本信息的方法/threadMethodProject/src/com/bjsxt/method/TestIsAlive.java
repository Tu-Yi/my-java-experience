package com.bjsxt.method;

public class TestIsAlive {
	public static void main(String[] args) {
		//主线程
		MyThread my=new MyThread();
		System.out.println("线程my处于新生状态的是否处于活动状态:"+my.isAlive());
		my.start();//启动线程
		System.out.println("线程my处于就绪状态的线程是否处于活动状态:"+my.isAlive());
		//主线程中的循环
		for(int i=0;i<10;i++){
			System.out.println("----------"+Thread.currentThread().getName()+"--------->"+i);
		}
		//主线程中的最后一句代码
		System.out.println("my线程是否处于活动状态:"+my.isAlive());
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