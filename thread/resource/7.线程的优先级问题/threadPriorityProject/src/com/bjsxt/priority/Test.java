package com.bjsxt.priority;

public class Test {
	public static void main(String[] args) {
		System.out.println("最高优先级:"+Thread.MAX_PRIORITY);
		System.out.println("最低优先级:"+Thread.MIN_PRIORITY);
		System.out.println("默认优先级:"+Thread.NORM_PRIORITY);
		//主线程的优先级
		Thread t=Thread.currentThread();
		System.out.println("获取主线程的优先级:"+t.getPriority());
		
		Thread t2=new Thread(new MyThread());
		System.out.println("新建的线程优先级为:"+t2.getPriority());
		/**
		 * 优先级超高越有可能先被调用执行，但是不一定
		 * 
		 */
		 t2.setPriority(6);
		 System.out.println("t2线程的优先级:"+t2.getPriority());
	 // t2.setPriority(100);  非法参数，因为优先级只能是1-10之间的整数
		 
	}
}
class MyThread implements Runnable{
	@Override
	public void run() {
	
	}
}
