package com.bjsxt.test;

public class Test {
	public static void main(String[] args) {
		String str1="abc"+"dbc";
		String str4="abcdbc";
		//������ʱ���ڶ��д�������
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
		/**�ڵȺŵ��Ҳ��б����������л�new�ؼ��֣����ڶ��ڴ濪�ٿռ�*/
		
		String str6="";
		for(int i=0;i<10;i++){
			StringBuilder sb2=new StringBuilder();
			sb2.append(str6);
			sb2.append(i);
			str6=sb2.toString();
			//str6=str6+i;
		}
		System.out.println(str6);
		/**ֻ������һ������,sb����*/
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<10;i++){
			sb.append(i);
		}
		System.out.println(sb);
		
	}
}
