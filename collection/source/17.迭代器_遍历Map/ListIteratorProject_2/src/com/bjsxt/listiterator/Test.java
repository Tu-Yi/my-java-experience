package com.bjsxt.listiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *  public ListIterator<E> listIterator() {
        return new ListItr(0);
    }*/
public class Test {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		al.add("hello");
		al.add("world");
		al.add("java");
		ListIterator<String> ite	=al.listIterator();//ListIterator��Iterator�ӿڵ���չ
		while(ite.hasNext()){
			String str=ite.next();
			if ("world".equals(str)) {
				ite.add("sql");
			}
		}
		System.out.println(al);
		System.out.println("�������Ԫ��");
		while(ite.hasPrevious()){
			System.out.println(ite.previous());
		}
	}
}
