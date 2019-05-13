package com.bjsxt.autoboxing;

public class TestUnBoxing {
	public static void main(String[] args) {
		
		int a=new Integer(100);
		//相当于new Integer(100).intValue();
		
		Integer b=null;
		int c=b;//自动拆箱  
		//相当于
		int cc=b.intValue();
		System.out.println(c);
	}
}
