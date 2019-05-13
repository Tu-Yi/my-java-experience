package com.bjsxt.list_arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class TestArrayList {
	public static void main(String[] args) {
		//创建集合对象, 接口 new 实现类
		List list=new ArrayList();
		//(1)添加add (Object obj)
		list.add("hello");
		list.add(123);//自动装箱
		list.add(new Scanner(System.in));
		//(2)集合中元素的个数 size()
		System.out.println(list.size());
		System.out.println("集合是否为空:"+list.isEmpty());
		//(3)addAll(Collection c)
		List list2=new ArrayList();
		list2.add("hello");
		list2.add(123);
		list.addAll(list2);
		System.out.println("list集合中元素的个数:"+list.size());
		System.out.println(list);
		//(4)删除
		System.out.println("根据对象去删除:");
		list.remove("hello");
		System.out.println(list);
		//list.remove(123);//认为123是索引
		list.remove(new Integer(123));
		System.out.println(list);
		list.remove(0);//根据索引去删除
		System.out.println(list);
		list.add("world");  //list [hello,123,world] list2[hello,123]
		//list.removeAll(list2);
		//list.retainAll(list2);
		System.out.println(list);
		
		//(5)判断
		System.out.println("hello在集合中是否存在:"+list.contains("hello"));
		System.out.println("java在集合中是否存在:"+list.contains("java"));
		//(6)清空集合中所有的元素对象
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list.containsAll(list2));
		//list.clear();
		//System.out.println(list);
		//(7)获取指定索引位置上的元素对象
		System.out.println(list.get(1));
		//(8)设置
		list.set(1, "java");
		System.out.println(list);
		//(9)在指定的索引位置上添加元素对象
		list.add(1, "html");
		System.out.println(list);
		
		//(10)查找元素在集合中的位置
		System.out.println(list.indexOf("java")+"\t"+list.indexOf("sql"));
		//(11)遍历集合中元素的内容
		/**(1)使用加强for循环遍历集合中的元素*/
		System.out.println("\n使用加强for循环遍历集合中的元素\n");
		for(Object obj:list){
			System.out.println(obj);
		
		}
		/**(2)使用普通for循环遍历集合中的元素对象*/
		System.out.println("\n使用普通for循环遍历集合中的元素对象\n");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		/**(3)使用迭代器*/
		System.out.println("\n使用迭代器遍历集合中的元素\n");
		Iterator ite=list.iterator();  //正向遍历
		while(ite.hasNext()){//判断集合中是否有元素对象
			Object obj=ite.next();
			System.out.println(obj);
		}
		System.out.println("使用listIterator()遍历");
		ListIterator listIte=list.listIterator();
		System.out.println("正向遍历");
		System.out.println("在集合的开头，后面还有元素对象吗?"+listIte.hasNext());
		System.out.println("在集合的开头，前面有元素对象吗?"+listIte.hasPrevious());
		while(listIte.hasNext()){
			System.out.println(listIte.next());
		}
		System.out.println("到达集合的末尾，后面还有元素对象吗?"+listIte.hasNext());
		System.out.println("到达集合的末尾，前面有元素对象吗?"+listIte.hasPrevious());
		System.out.println("\n逆向遍历集合中的元素\n");
		while(listIte.hasPrevious()){
			System.out.println(listIte.previous());
		}
		
	}
}
