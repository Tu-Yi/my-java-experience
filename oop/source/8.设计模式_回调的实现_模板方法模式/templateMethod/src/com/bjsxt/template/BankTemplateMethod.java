package com.bjsxt.template;

public abstract class BankTemplateMethod {
	public void takeNumber(){
		System.out.println("�Ŷ�ȡ��");
	}
	public abstract void transant();//��������ҵ��
	
	public void evaluate(){
		System.out.println("������Ա����");
	}
	//����ҵ�������
	public void process(){
		//(1)ȡ��
		this.takeNumber();
		//(2)����ҵ��
		this.transant();
		//(3)����
		this.evaluate();
	}
}
