package com.bjsxt.stringbuilder;

public class TestStringBuilder2 {
	public static void main(String[] args) {
		
		StringBuilder sb=new StringBuilder();//ʵ���ϴ�����һ������Ϊ16��char���͵�����
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
		System.out.println("����"+sb2.capacity()+"\tsb2�ĳ���"+sb2.length());
	}
}
