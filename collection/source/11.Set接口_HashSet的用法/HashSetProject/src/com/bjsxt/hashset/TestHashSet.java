package com.bjsxt.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
	public static void main(String[] args) {
		//HashSet底层数组结构使用的是hash表  ,主结构数组, +链表
		//创建集合对象
		HashSet hs=new HashSet();
		hs.add("hello");
		System.out.println(	hs.add("world"));
		hs.add("java");
		System.out.println(hs.add("world"));
		System.out.println("集合中元素的个数:"+hs.size());
		System.out.println(hs);
		System.out.println(hs.contains("java")+"\t"+hs.contains("sql"));
		//使用迭代器遍历元素
		Iterator ite=hs.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		
	}
}
