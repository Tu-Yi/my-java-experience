package com.bjsxt.hashset;

import java.util.HashSet;

public class TestPerson {
	public static void main(String[] args) {
		HashSet hs=new HashSet();
		//����4��Person���͵Ķ���
		Person p1=new Person("marry", 20);
		Person p2=new Person("lili", 23);
		Person p3=new Person("marry", 20);
		Person p4=new Person("jack", 30);
		//��Ӽ�����
		hs.add(p1);
		hs.add(p2);
		hs.add(p3);
		hs.add(p4);
		System.out.println(hs);
	}
}
