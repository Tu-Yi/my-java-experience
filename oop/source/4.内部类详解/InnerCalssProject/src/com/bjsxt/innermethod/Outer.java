package com.bjsxt.innermethod;

public class Outer {
	//Outer�ĳ�Ա����
	public void show(){
		int a=10;//�����еľֲ�����
		//�ڲ����൱��show�����еľֲ�������ʹ�÷�Χֻ����show������
		class Inner{
			public void fun(){
				System.out.println("a="+a);
			}
		}
		//�����ڲ���Ķ���
		new Inner().fun();
	}
}
