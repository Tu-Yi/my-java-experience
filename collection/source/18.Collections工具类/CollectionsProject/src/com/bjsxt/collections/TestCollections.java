package com.bjsxt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		//向集合中一次性添加N多个元素
		Collections.addAll(al, "hello","world","java");
		System.out.println(al);
		//排序
		Collections.sort(al);//为什么按照英文字母的升序排序？因为String类具备了比较大小的能力
		System.out.println(al);
		//二分搜索
		System.out.println(Collections.binarySearch(al, "java"));//1
		System.out.println(Collections.binarySearch(al, "html"));//-2 -2= -(插入点+1) 推理出来插入点 1
		ArrayList<String> al2=new ArrayList<String>();
		Collections.addAll(al2, "sql","sql","sql","sql4");
		//集合拷贝注意的地方:如果源集合.size()>目标集合的.size()   IndexOutOfBoundsException
		
		Collections.copy(al2, al); //将al中所有元素拷贝到al2中
		System.out.println(al2);
		//填 充
		Collections.fill(al2, "html");
		System.out.println(al2);
		//最大与最小
		System.out.println("最大:"+Collections.max(al));
		System.out.println("最小:"+Collections.min(al));
	//逆序
		Collections.reverse(al);
		System.out.println(al);
		//线程同步
		List<String> list=Collections.synchronizedList(al);
		
		
	}
}
