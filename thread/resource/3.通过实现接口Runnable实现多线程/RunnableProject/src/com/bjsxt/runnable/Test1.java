package com.bjsxt.runnable;

public class Test1 {
	public static void main(String[] args) {
		//创建线程类的对象
		MyRunnable my=new MyRunnable();
		//start()方法是Thread类中的方法
		Thread t=new Thread(my);
		t.start();//启动线程
		
		//主线程中的循环
		for(int i=0;i<10;i++){
			System.out.println("Test1.main()---------->"+i);
		}
	}
}
