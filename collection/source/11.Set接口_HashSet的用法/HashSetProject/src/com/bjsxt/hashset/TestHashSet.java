package com.bjsxt.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
	public static void main(String[] args) {
		//HashSet�ײ�����ṹʹ�õ���hash��  ,���ṹ����, +����
		//�������϶���
		HashSet hs=new HashSet();
		hs.add("hello");
		System.out.println(	hs.add("world"));
		hs.add("java");
		System.out.println(hs.add("world"));
		System.out.println("������Ԫ�صĸ���:"+hs.size());
		System.out.println(hs);
		System.out.println(hs.contains("java")+"\t"+hs.contains("sql"));
		//ʹ�õ���������Ԫ��
		Iterator ite=hs.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		
	}
}
