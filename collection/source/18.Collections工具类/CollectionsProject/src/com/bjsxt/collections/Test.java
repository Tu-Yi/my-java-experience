package com.bjsxt.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		/*(1)集合转成数组*/
		ArrayList<String> al=new ArrayList<String>();
		al.add("hello");
		al.add("world");
		Object[] obj=al.toArray();
		for (Object object : obj) {
			System.out.println(object);
		}
		String []strArray=new String[1];//new String[5];
		strArray=al.toArray(strArray);
		for (String str : strArray) {
			System.out.println(str);
		}
		/**(2)数组转成集合*/
		int [] array={11,22,33};
		List list=Arrays.asList(array);
		System.out.println(list);
		
		Integer[] array2=new Integer[]{11,22,33};
		List<Integer> list2=Arrays.asList(array2);
		System.out.println(list2);
	}
}
