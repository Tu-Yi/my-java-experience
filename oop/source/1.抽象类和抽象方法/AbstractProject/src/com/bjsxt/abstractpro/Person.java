package com.bjsxt.abstractpro;

public abstract class Person {
	//(1)��Ա����/ʵ������/����
	private String name;//����
	//(2)��Ա����/ʵ������
	public void info(){
		System.out.println("��Һã��ҽ�"+name);
	}
	//(3)��̬����
	public static void show(){
		
	}
	//(4)���췽��
	public Person(){
		System.out.println("Person���е��޲ι��췽��");
	}
	//(5)final���εķ�����ֻ�ܱ�������ã�������������д
	public final void fun(){
		
	}
	public abstract void print();
}