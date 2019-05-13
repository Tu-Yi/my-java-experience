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
		ListIterator<String> ite	=al.listIterator();//ListIterator是Iterator接口的扩展
		while(ite.hasNext()){
			String str=ite.next();
			if ("world".equals(str)) {
				ite.add("sql");
			}
		}
		System.out.println(al);
		System.out.println("逆向遍历元素");
		while(ite.hasPrevious()){
			System.out.println(ite.previous());
		}
	}
}
