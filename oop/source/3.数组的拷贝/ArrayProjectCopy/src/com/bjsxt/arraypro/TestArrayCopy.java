package com.bjsxt.arraypro;

public class TestArrayCopy {
	public static void main(String[] args) {
		int []arrA={11,22,33,44};
		//����һ������
		int [] arrB=new int[5];
		System.out.println("������ַ�����ã�֮ǰ");
		System.out.println("arrA="+arrA);
		System.out.println("arrB="+arrB);
		
		
		//���õĿ���
		arrB=arrA;
		System.out.println("������ַ�����ã�֮�� ");
		System.out.println("arrA="+arrA);
		System.out.println("arrB="+arrB);
	}
}
