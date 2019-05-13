package com.bjsxt.pro2;

public class Test {
	public static void main(String[] args) {
		//创建共享资源对象
		Goods g=new Goods();
		//创建生产者线程
		Producter p=new Producter(g);
		//创建生产者线程
		Customer c=new Customer(g);
		new Thread(p).start();
		new Thread(c).start();
	}
}
