package com.bjsxt.listiterator;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {
	public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("hello", 123);
		hm.put("world", 345);
		hm.put("java", 567);
		//��һ��
		Set<String> set=hm.keySet();
		for (String str : set) {
			System.out.println(str+"\t"+hm.get(str));
		}
		//�ڶ��ֱ���  Entry<String, Integer>��ֵ��ϵ������
		Set<Entry<String, Integer>> entry=hm.entrySet();
		for (Entry<String, Integer> ent : entry) {
			System.out.println(ent.getKey()+"\t"+ent.getValue());
		}
	}
}
