package com.bjsxt.runnable;

public class Test1 {
	public static void main(String[] args) {
		//�����߳���Ķ���
		MyRunnable my=new MyRunnable();
		//start()������Thread���еķ���
		Thread t=new Thread(my);
		t.start();//�����߳�
		
		//���߳��е�ѭ��
		for(int i=0;i<10;i++){
			System.out.println("Test1.main()---------->"+i);
		}
	}
}
