package com.bjsxt.thread;

public class TestJoin {
	public static void main(String[] args) throws InterruptedException {
		//主线程
		MyThread my=new MyThread();
		Thread t=new Thread(my);
		Thread t2=new Thread(my);
		//启动线程
		t.start();
		t2.start();
		//以下代码为主线程中的循环
		for(int i=0;i<10;i++){
			if(i==3){
				t.join();  //t线程强制执行
			}
			System.out.println("------------"+Thread.currentThread().getName()+"-------->"+i);
		}
	}
	/**
	 * 导致调用它的线程进入阻塞状态，而不会导致其它的线程
	 * 
	 * */
}
