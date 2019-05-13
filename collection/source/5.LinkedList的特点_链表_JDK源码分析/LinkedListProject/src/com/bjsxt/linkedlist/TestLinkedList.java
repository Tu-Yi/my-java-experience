package com.bjsxt.linkedlist;

import java.util.LinkedList;

public class TestLinkedList {
	/**
	 * LinkedList底层数据结构是链表,删除和添加元素的效率比较高，数据结构复杂
	 * ArrayList底层数据结构是数组， 删除和添加元素效率比较低
	 * LinkedList底层源码分析
	 * (1)构造方法
	 * public LinkedList() {
       }
       (2)添加方法
      public boolean add(E e) {
        linkLast(e);
        return true;
    }
      
	 * */
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		//添加元素
		list.add("hello");
		list.addFirst("java");
		list.addLast("world");
		//删头，删尾
		//list.removeLast();
		//list.removeFirst();
		System.out.println(list);
		//遍历
		for(Object obj:list){
			System.out.println(obj);
		}
		}
		
	
}
