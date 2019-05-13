package com.bjsxt.autoboxing;

public class TestAutoBoxing {
	public static void main(String[] args) {
		//-128µ½127Ö®¼ä
		Integer a=128;
		Integer b=128;
		System.out.println(a==b);//true
		Integer aa=1000;
		Integer bb=1000;
		System.out.println("aa==bb"+(aa==bb));//false
	}
}
