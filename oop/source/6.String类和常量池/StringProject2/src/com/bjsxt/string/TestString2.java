package com.bjsxt.string;

public class TestString2 {
	public static void main(String[] args) {
		String str1="abc";
		String str2="a"+"b"+"c";
		String str3=new String("abc");
		String str4=str3+"";
		String str5=new String("abc");
		System.out.println("str1==str2:"+(str1==str2));//true
		System.out.println("str1==str3:"+(str1==str3));//false
		System.out.println("str1==str4:"+(str1==str4));//false
		System.out.println("str3==str5:"+(str3==str5));//false
		
		
	}
}
