package com.bjsxt.math;

public class TestMath {
	public static void main(String[] args) {
		System.out.println("绝对值:"+Math.abs(23)+"\t"+Math.abs(-23)+"\t"+Math.abs(0));
		System.out.println("向上取整再转double:"+Math.ceil(23.00001)+"\t"+Math.ceil(-9.999999));
		System.out.println("向下取整数再转double:"+Math.floor(23.99999)+"\t"+Math.floor(-23.00001));
		System.out.println("最值:"+Math.max(20, 10)+"\t"+Math.min(3, 40));
		System.out.println("5的2次方:"+Math.pow(5, 2)+"5的立方"+Math.pow(5, 3));
		System.out.println("随机数[0,1):"+Math.random());
		int ran=(int)(Math.random()*9000)+1000;
		System.out.println("1000-9999之间的随机数:"+ran);
		System.out.println("四舍五入:"+Math.round(34.567)+"\t"+Math.round(34.345));
		System.out.println("开方:"+Math.sqrt(4));
		
		
	}
}
