package com.bjsxt.treemap;

import java.util.Comparator;

public class CompareCharactor implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Person p1=(Person)o1;
		Person p2=(Person)o2;
		             //������String���а���Ӣ����ĸ����Ƚϴ�С�ķ���
		return p1.getName().compareTo(p2.getName());
	}
	
}
