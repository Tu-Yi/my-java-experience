package com.bjsxt.thread;

public class MyThread3 implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			if(i==3){
				Thread.yield();
				System.out.println("当前线程:"+Thread.currentThread().getName()+"线程礼让一次");
			}
			System.out.println("i="+i);
		}
	}
}
