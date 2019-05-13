package com.bjsxt.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		//Map�ӿڵ��ص�,key�������ظ���ֵ�����ظ�������key�������
		//�������϶���
		HashMap hm=new HashMap();
		//(1)���Ԫ��
		hm.put("hello", 123);//123�Զ�װ�䣬Integer����
		hm.put("world",456);
		hm.put("hello", 1000); //�����е�key�����ظ�������ظ���������ֵ�ĸ���
		hm.put("java", 1000);
		System.out.println("������Ԫ�صĸ���:"+hm.size());
		System.out.println("�����Ƿ�Ϊ��:"+hm.isEmpty());
		System.out.println(hm);
		System.out.println(hm.remove("world"));//��������Ƴ�
		System.out.println(hm);
		//�ж�
		System.out.println(hm.containsKey("java")+"\t"+hm.containsKey("world"));
		System.out.println(hm.containsValue(1000)+"\t"+hm.containsValue(2000));
		//��ȡԪ��
		System.out.println(hm.get("java")+"\t"+hm.get("world"));
		//��ȡ����key�ļ���
		Set set=hm.keySet();
		for(Object obj:set){
			System.out.println(obj);
		}
		//��ȡ���е�value�ļ���
		System.out.println("\n--------------------------");
		Collection coll=hm.values();
		for(Object obj:coll){
			System.out.println(obj);
		}
		//��ȡ����key-value��ϵ�ļ���
		Set entrySet=hm.entrySet();
		for(Object obj:entrySet){
			System.out.println(obj);
		}
		
		/**
		 * HashMap��Hashtable������
		 * (1)�汾��ͬ HashMap JDK1.2  Hashtable 1.0
		 * (2)HashMap�̳���AbstractMap��ʵ����Map�ӿڣ�Hashtable�̳���Dictionaryʵ��Map�ӿ�
		 * (3)HashMap����nullֵ��null��, ����null��Ϊkeyֻ��һ��, Hashtable��null�ļ���ֵ
		 * (4)HashMap���̲߳�ͬ���� (Ч�ʸߣ���ȫ�Ե�),Hashtable(Ч�ʵͣ���ȫ�Ը�)�߳�ͬ��
		 * 
		 * 
		 * */
	}
}
