package com.bjsxt.autoboxing;

public class TestUnBoxing {
	public static void main(String[] args) {
		
		int a=new Integer(100);
		//�൱��new Integer(100).intValue();
		
		Integer b=null;
		int c=b;//�Զ�����  
		//�൱��
		int cc=b.intValue();
		System.out.println(c);
	}
}
