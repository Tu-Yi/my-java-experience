package com.bjsxt.generic;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		//在创建集合对象时，明确集合中所存储的元素的类型
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("hello");
		//al.add(123);
		for (String str : al) {
			System.out.println(str);
		}
		
		int [] arr=new int[5];
	}
}
