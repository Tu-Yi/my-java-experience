package com.bjsxt.hashmap;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashtable {
	public static void main(String[] args) {
		//创建集合对象
		Hashtable ht=new Hashtable();
		//ht.put(null, null);
		System.out.println(ht);//NullPointerException
		HashMap hm=new HashMap();
		hm.put(null, null);
		hm.put(null, "hello");
		System.out.println(hm);
	}
}
