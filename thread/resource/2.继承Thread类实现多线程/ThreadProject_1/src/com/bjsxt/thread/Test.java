package com.bjsxt.thread;

public class Test {
	public static void main(String[] args) {
		//创建线程类的对象
		MyThread my=new MyThread();
		my.start();//启动线程
		//my.run(); //先执行run方法中代码，run()执行结束，再去执行下面的打印输出
		System.out.println("---------main");
	}
}
