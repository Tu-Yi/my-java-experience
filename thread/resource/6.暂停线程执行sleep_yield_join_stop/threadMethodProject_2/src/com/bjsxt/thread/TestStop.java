package com.bjsxt.thread;

public class TestStop {
	public static void main(String[] args) {
		MyThread4 my=new MyThread4();
		Thread t=new Thread(my);
		t.start();//启动线程
		//主线程中的循环
		for(int i=0;i<10;i++){
			if(i==3){
				t.stop();  //已过时，不建议使用
			}
			System.out.println(Thread.currentThread().getName()+"--->"+i);
		}
		
	}
}
