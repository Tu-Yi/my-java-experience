package com.bjsxt.generic;

public class TestMyMethod {
	public static void main(String[] args) {
		MyMethod<String> my=new MyMethod<String>();
		my.show("hello");//�ڴ�����Ķ���ʱ��ȷ����������ΪString
		
		//���˷��ͷ���������˲���������ͬ������µķ�������
		my.method("hello");
		my.method(123);
		my.method('a');
		
		//�ɱ�����ķ��ͷ�������������ĸ�����ͬ�����Ͳ�ͬ�ķ�������
		my.fun("hello");
		my.fun("hello","world","java");
		my.fun(123,456);
	}
}	
