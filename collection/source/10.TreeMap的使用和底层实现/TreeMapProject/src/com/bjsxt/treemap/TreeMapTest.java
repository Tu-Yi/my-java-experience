package com.bjsxt.treemap;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		//����TreeMap���϶���
		//TreeMap tm=new TreeMap();//ʹ���ڲ��Ƚ���
		/**keyϣ������Ӣ����ĸ����������*/
		CompareCharactor cc=new CompareCharactor();
		TreeMap tm=new TreeMap(cc);
		Person p1=new Person("marry",20);
		Person p2=new Person("lili",19);
		Person p3=new Person("small-apple",23);
		tm.put(p1, p1.getName());
		tm.put(p2, p2.getName());
		tm.put(p3, p3.getName());
		System.out.println(tm);
	}
}

