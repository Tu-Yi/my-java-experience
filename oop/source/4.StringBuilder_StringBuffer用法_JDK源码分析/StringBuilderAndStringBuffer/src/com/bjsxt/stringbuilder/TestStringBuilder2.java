package com.bjsxt.stringbuilder;

public class TestStringBuilder2 {
	public static void main(String[] args) {
		
		StringBuilder sb=new StringBuilder();//实际上创建了一个长度为16的char类型的数组
		StringBuilder sb2=new StringBuilder("hello");//5+16
		sb2.append("world");
		sb2.append("world");
		sb2.append("world");
		sb2.append("world");
		sb2.append("world");
		sb2.append("world");
		sb2.append("world");
		sb2.append("world");
		System.out.println(sb2);
		System.out.println("容量"+sb2.capacity()+"\tsb2的长度"+sb2.length());
	}
}
