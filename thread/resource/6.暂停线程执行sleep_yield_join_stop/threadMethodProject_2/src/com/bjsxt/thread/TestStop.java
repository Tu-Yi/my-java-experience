package com.bjsxt.thread;

public class TestStop {
	public static void main(String[] args) {
		MyThread4 my=new MyThread4();
		Thread t=new Thread(my);
		t.start();//�����߳�
		//���߳��е�ѭ��
		for(int i=0;i<10;i++){
			if(i==3){
				t.stop();  //�ѹ�ʱ��������ʹ��
			}
			System.out.println(Thread.currentThread().getName()+"--->"+i);
		}
		
	}
}
