package com.bjsxt.proxy;

public class MarryCompany implements Marry{
	//�� �칫˾��׼�������ˣ�׼���� ��....
	private Marry m;
	 public MarryCompany(Marry m) {
		this.m=m;
	}
	
	 public void after(){
		 System.out.println("��ʰ����............");
	 }
	 public void before(){
		 System.out.println("����ǰ��һЩ׼������...........");
	 }
	@Override
	public void marry() {
		this.before();
		m.marry();//������ʵ��ɫ�Ľ��ķ���
		this.after();
	}

}
