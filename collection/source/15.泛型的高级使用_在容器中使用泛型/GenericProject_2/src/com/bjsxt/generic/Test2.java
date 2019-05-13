package com.bjsxt.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test2 {
	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("hello");
		
		LinkedList<Integer> linkedList=new LinkedList<Integer>();
		linkedList.add(123);//123进行了自动装箱
		
		//存储自定时对象时，要求Person类重写hashCode()及equals()方法
		HashSet<Person> hs=new HashSet<Person>();
		
		//Person 对象具备比较规则 ，可以是内部比较器，也可以外部比较器
		TreeSet<Person> treeSet=new TreeSet<Person>();
		
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("hello", 123);
		
		HashMap<Person,String> hm2=new HashMap<Person,String>();
		Person p1=new Person("marry",20);
		hm2.put(p1, p1.getName());
		
		TreeMap<Person,Integer> tm=new TreeMap<Person,Integer>();
		tm.put(p1, p1.getAge());
		
		//泛型只在编译期间起作用
	}
}
