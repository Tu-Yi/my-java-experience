package com.bjsxt.proxy;

public class Test {
	public static void main(String[] args) {
		//�������ɫ����
		Marry y=new You(); //�ӿ�new ʵ����
		//��������ǽ�ɫ
		Marry myc=new MarryCompany(y);
		myc.marry();
	}
}
