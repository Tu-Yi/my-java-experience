package com.bjsxt.dead;

public class Test {
	public static void main(String[] args) {
		//����������Դ�Ķ���
		Object money=new Object();
		Object water=new Object();
		//�����߳���Ķ���
		DeadLock d1=new DeadLock(money, water);
		DeadLock d2=new DeadLock(money, water);
		d1.flag=true;
		d2.flag=false;
		//�����߳�
		d1.start();
		d2.start();
	}
}
