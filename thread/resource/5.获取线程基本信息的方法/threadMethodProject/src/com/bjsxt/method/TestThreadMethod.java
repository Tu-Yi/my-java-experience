package com.bjsxt.method;

public class TestThreadMethod {
	//主方法，主线程
	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		//toString()方法得到的内容 为 [线程名称,线程的优先级,线程组的名称]
		System.out.println(t.toString());
		
		//线程线程类的对象
		MyRunnable my=new MyRunnable();
		Thread t1=new Thread(my);
		Thread t2=new Thread(my);
		Thread t3=new Thread(my);
		
		//启动线程
		t1.start();
		t2.start();
		t3.start();
		/**在Thread类中一定有一个静态变量int，用于统计创建线程的个数 */
		//线程的默认的命名规则  Thread - int类型的变量的值
	}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		Thread t=Thread.currentThread();
		System.out.println("线程的名称"+t.getName());
	}
	
}
