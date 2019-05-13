package com.bjsxt.test;

public class Test {
	public static void main(String[] args) {
		String str1="abc"+"dbc";
		String str4="abcdbc";
		//在运行时会在堆中创建对象
		/**
		 * StringBuilder sb=new StringBuilder();
		 * sb.append("abcdbc");
		 * sb.append("cde");
		 * String str2=sb.toString();
		 * 
		 * */
		String str2=str1+"cde";
		
		String str3=new String("hello");
		System.out.println(str1==str4);
		/**在等号的右侧有变量参与运行或new关键字，将在堆内存开辟空间*/
		
		String str6="";
		for(int i=0;i<10;i++){
			StringBuilder sb2=new StringBuilder();
			sb2.append(str6);
			sb2.append(i);
			str6=sb2.toString();
			//str6=str6+i;
		}
		System.out.println(str6);
		/**只创建了一个对象,sb对象*/
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<10;i++){
			sb.append(i);
		}
		System.out.println(sb);
		
	}
}
