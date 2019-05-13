package com.bjsxt.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		//Map接口的特点,key不允许重复，值可以重复，而且key是无序的
		//创建集合对象
		HashMap hm=new HashMap();
		//(1)添加元素
		hm.put("hello", 123);//123自动装箱，Integer类型
		hm.put("world",456);
		hm.put("hello", 1000); //集合中的key不能重复，如果重复，将进行值的覆盖
		hm.put("java", 1000);
		System.out.println("集合中元素的个数:"+hm.size());
		System.out.println("集合是否为空:"+hm.isEmpty());
		System.out.println(hm);
		System.out.println(hm.remove("world"));//先输出后移除
		System.out.println(hm);
		//判断
		System.out.println(hm.containsKey("java")+"\t"+hm.containsKey("world"));
		System.out.println(hm.containsValue(1000)+"\t"+hm.containsValue(2000));
		//获取元素
		System.out.println(hm.get("java")+"\t"+hm.get("world"));
		//获取所有key的集合
		Set set=hm.keySet();
		for(Object obj:set){
			System.out.println(obj);
		}
		//获取所有的value的集合
		System.out.println("\n--------------------------");
		Collection coll=hm.values();
		for(Object obj:coll){
			System.out.println(obj);
		}
		//获取所有key-value关系的集合
		Set entrySet=hm.entrySet();
		for(Object obj:entrySet){
			System.out.println(obj);
		}
		
		/**
		 * HashMap与Hashtable的区别
		 * (1)版本不同 HashMap JDK1.2  Hashtable 1.0
		 * (2)HashMap继承了AbstractMap，实现了Map接口，Hashtable继承了Dictionary实现Map接口
		 * (3)HashMap允许null值和null键, 但是null作为key只允一个, Hashtable非null的键和值
		 * (4)HashMap是线程不同步的 (效率高，安全性低),Hashtable(效率低，安全性高)线程同步
		 * 
		 * 
		 * */
	}
}
