package com.bjsxt.innerstatic;

public class TestStaticInner {
	public static void main(String[] args) {
		//�����ڲ���Ķ���   new �ⲿ������.�ڲ�������();
		Outer.Inner i=new Outer.Inner();
		i.show();
	
		//���ʵ��Ǿ�̬�ڲ����еľ�̬����
		Outer.Inner2.show();
	}
}
