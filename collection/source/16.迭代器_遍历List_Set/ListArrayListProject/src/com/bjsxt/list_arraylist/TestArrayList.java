package com.bjsxt.list_arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class TestArrayList {
	public static void main(String[] args) {
		//�������϶���, �ӿ� new ʵ����
		List list=new ArrayList();
		//(1)���add (Object obj)
		list.add("hello");
		list.add(123);//�Զ�װ��
		list.add(new Scanner(System.in));
		//(2)������Ԫ�صĸ��� size()
		System.out.println(list.size());
		System.out.println("�����Ƿ�Ϊ��:"+list.isEmpty());
		//(3)addAll(Collection c)
		List list2=new ArrayList();
		list2.add("hello");
		list2.add(123);
		list.addAll(list2);
		System.out.println("list������Ԫ�صĸ���:"+list.size());
		System.out.println(list);
		//(4)ɾ��
		System.out.println("���ݶ���ȥɾ��:");
		list.remove("hello");
		System.out.println(list);
		//list.remove(123);//��Ϊ123������
		list.remove(new Integer(123));
		System.out.println(list);
		list.remove(0);//��������ȥɾ��
		System.out.println(list);
		list.add("world");  //list [hello,123,world] list2[hello,123]
		//list.removeAll(list2);
		//list.retainAll(list2);
		System.out.println(list);
		
		//(5)�ж�
		System.out.println("hello�ڼ������Ƿ����:"+list.contains("hello"));
		System.out.println("java�ڼ������Ƿ����:"+list.contains("java"));
		//(6)��ռ��������е�Ԫ�ض���
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list.containsAll(list2));
		//list.clear();
		//System.out.println(list);
		//(7)��ȡָ������λ���ϵ�Ԫ�ض���
		System.out.println(list.get(1));
		//(8)����
		list.set(1, "java");
		System.out.println(list);
		//(9)��ָ��������λ�������Ԫ�ض���
		list.add(1, "html");
		System.out.println(list);
		
		//(10)����Ԫ���ڼ����е�λ��
		System.out.println(list.indexOf("java")+"\t"+list.indexOf("sql"));
		//(11)����������Ԫ�ص�����
		/**(1)ʹ�ü�ǿforѭ�����������е�Ԫ��*/
		System.out.println("\nʹ�ü�ǿforѭ�����������е�Ԫ��\n");
		for(Object obj:list){
			System.out.println(obj);
		
		}
		/**(2)ʹ����ͨforѭ�����������е�Ԫ�ض���*/
		System.out.println("\nʹ����ͨforѭ�����������е�Ԫ�ض���\n");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		/**(3)ʹ�õ�����*/
		System.out.println("\nʹ�õ��������������е�Ԫ��\n");
		Iterator ite=list.iterator();  //�������
		while(ite.hasNext()){//�жϼ������Ƿ���Ԫ�ض���
			Object obj=ite.next();
			System.out.println(obj);
		}
		System.out.println("ʹ��listIterator()����");
		ListIterator listIte=list.listIterator();
		System.out.println("�������");
		System.out.println("�ڼ��ϵĿ�ͷ�����滹��Ԫ�ض�����?"+listIte.hasNext());
		System.out.println("�ڼ��ϵĿ�ͷ��ǰ����Ԫ�ض�����?"+listIte.hasPrevious());
		while(listIte.hasNext()){
			System.out.println(listIte.next());
		}
		System.out.println("���Ｏ�ϵ�ĩβ�����滹��Ԫ�ض�����?"+listIte.hasNext());
		System.out.println("���Ｏ�ϵ�ĩβ��ǰ����Ԫ�ض�����?"+listIte.hasPrevious());
		System.out.println("\n������������е�Ԫ��\n");
		while(listIte.hasPrevious()){
			System.out.println(listIte.previous());
		}
		
	}
}
