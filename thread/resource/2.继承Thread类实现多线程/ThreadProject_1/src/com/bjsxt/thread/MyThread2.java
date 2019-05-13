package com.bjsxt.thread;

public class MyThread2 extends Thread {//(1)ผฬณะ
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("MyThread2---------"+i);
		}
	}
}
