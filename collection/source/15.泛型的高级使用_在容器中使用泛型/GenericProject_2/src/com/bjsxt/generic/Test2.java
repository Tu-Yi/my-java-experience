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
		linkedList.add(123);//123�������Զ�װ��
		
		//�洢�Զ�ʱ����ʱ��Ҫ��Person����дhashCode()��equals()����
		HashSet<Person> hs=new HashSet<Person>();
		
		//Person ����߱��ȽϹ��� ���������ڲ��Ƚ�����Ҳ�����ⲿ�Ƚ���
		TreeSet<Person> treeSet=new TreeSet<Person>();
		
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("hello", 123);
		
		HashMap<Person,String> hm2=new HashMap<Person,String>();
		Person p1=new Person("marry",20);
		hm2.put(p1, p1.getName());
		
		TreeMap<Person,Integer> tm=new TreeMap<Person,Integer>();
		tm.put(p1, p1.getAge());
		
		//����ֻ�ڱ����ڼ�������
	}
}
