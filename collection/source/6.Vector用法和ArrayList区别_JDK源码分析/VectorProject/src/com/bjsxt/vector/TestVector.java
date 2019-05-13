package com.bjsxt.vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class TestVector {
	/**
	 * Vector的JDK源码分析
	 * (1)构造方法
	 * public Vector() {
        this(10);
      } 
        public Vector(int initialCapacity) {//10
        this(initialCapacity, 0);
     }
                        10            ,0
     public Vector(int initialCapacity, int capacityIncrement) {
       
        this.elementData = new Object[initialCapacity]; //相当于this.elementData=new Object[10];
        this.capacityIncrement = capacityIncrement;  //this.capacityIncrement=0;
    }
    (2)调用add方法添加元素
    
     public synchronized boolean add(E e) {
      
        ensureCapacityHelper(elementCount + 1); //检测容量是否够 用
        elementData[elementCount++] = e;  //添加元素，同时元素个数加1
        return true;
    }
	 * */
	public static void main(String[] args) {
		//创建了集合对象
		Vector vector=new Vector();
		System.out.println(vector.capacity()+"\t集合中元素的个数:"+vector.size());
		//ArrayList al=new ArrayList();
		//al.add("hello");
		//添加
		vector.add("hello");
		vector.add(0, "world");
		vector.addElement("java"); //添加元素
		vector.add("hello");
		vector.add(0, "world");
		vector.add("hello");
		vector.add(0, "world");
		vector.add("hello");
		vector.add(0, "world");
		
		vector.add(0, "world");
		vector.add("hello");//添加第十一个元素
		System.out.println(vector.capacity()+"\t集合中元素的个数:"+vector.size());
		System.out.println("集合中元素的个数:"+vector.size());
		System.out.println(vector);
		//删除
		//vector.remove(1);
		//vector.remove("java");
		//vector.clear();
		//vector.removeElement("java");
		//获取元素的方法
		System.out.println(vector.get(1));
		
		System.out.println(vector);
		System.out.println("加强for循环");
		for(Object obj:vector){
			System.out.println(obj);
		}
		System.out.println("使用迭代器遍历集合:");
		for(Iterator ite=vector.iterator();ite.hasNext();){
			System.out.println(ite.next());
		}
		
		Iterator ite=vector.iterator(); 
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}
}
