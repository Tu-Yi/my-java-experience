package com.bjsxt.priority;

public class Test {
	public static void main(String[] args) {
		System.out.println("������ȼ�:"+Thread.MAX_PRIORITY);
		System.out.println("������ȼ�:"+Thread.MIN_PRIORITY);
		System.out.println("Ĭ�����ȼ�:"+Thread.NORM_PRIORITY);
		//���̵߳����ȼ�
		Thread t=Thread.currentThread();
		System.out.println("��ȡ���̵߳����ȼ�:"+t.getPriority());
		
		Thread t2=new Thread(new MyThread());
		System.out.println("�½����߳����ȼ�Ϊ:"+t2.getPriority());
		/**
		 * ���ȼ�����Խ�п����ȱ�����ִ�У����ǲ�һ��
		 * 
		 */
		 t2.setPriority(6);
		 System.out.println("t2�̵߳����ȼ�:"+t2.getPriority());
	 // t2.setPriority(100);  �Ƿ���������Ϊ���ȼ�ֻ����1-10֮�������
		 
	}
}
class MyThread implements Runnable{
	@Override
	public void run() {
	
	}
}
