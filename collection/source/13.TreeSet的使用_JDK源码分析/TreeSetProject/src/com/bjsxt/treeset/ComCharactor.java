package com.bjsxt.treeset;

import java.util.Comparator;

public class ComCharactor implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Person p1=(Person)o1;
		Person p2=(Person)o2;
		//compareTo��String����ָ���ıȽϴ�С�ķ���
		return p1.getName().compareTo(p2.getName());
	}

}
