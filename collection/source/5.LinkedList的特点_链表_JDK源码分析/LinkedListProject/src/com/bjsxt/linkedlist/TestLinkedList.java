package com.bjsxt.linkedlist;

import java.util.LinkedList;

public class TestLinkedList {
	/**
	 * LinkedList�ײ����ݽṹ������,ɾ�������Ԫ�ص�Ч�ʱȽϸߣ����ݽṹ����
	 * ArrayList�ײ����ݽṹ�����飬 ɾ�������Ԫ��Ч�ʱȽϵ�
	 * LinkedList�ײ�Դ�����
	 * (1)���췽��
	 * public LinkedList() {
       }
       (2)��ӷ���
      public boolean add(E e) {
        linkLast(e);
        return true;
    }
      
	 * */
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		//���Ԫ��
		list.add("hello");
		list.addFirst("java");
		list.addLast("world");
		//ɾͷ��ɾβ
		//list.removeLast();
		//list.removeFirst();
		System.out.println(list);
		//����
		for(Object obj:list){
			System.out.println(obj);
		}
		}
		
	
}
