package com.bjsxt.math;

public class TestMath {
	public static void main(String[] args) {
		System.out.println("����ֵ:"+Math.abs(23)+"\t"+Math.abs(-23)+"\t"+Math.abs(0));
		System.out.println("����ȡ����תdouble:"+Math.ceil(23.00001)+"\t"+Math.ceil(-9.999999));
		System.out.println("����ȡ������תdouble:"+Math.floor(23.99999)+"\t"+Math.floor(-23.00001));
		System.out.println("��ֵ:"+Math.max(20, 10)+"\t"+Math.min(3, 40));
		System.out.println("5��2�η�:"+Math.pow(5, 2)+"5������"+Math.pow(5, 3));
		System.out.println("�����[0,1):"+Math.random());
		int ran=(int)(Math.random()*9000)+1000;
		System.out.println("1000-9999֮��������:"+ran);
		System.out.println("��������:"+Math.round(34.567)+"\t"+Math.round(34.345));
		System.out.println("����:"+Math.sqrt(4));
		
		
	}
}
