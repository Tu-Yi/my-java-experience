package com.bjsxt.vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class TestVector {
	/**
	 * Vector��JDKԴ�����
	 * (1)���췽��
	 * public Vector() {
        this(10);
      } 
        public Vector(int initialCapacity) {//10
        this(initialCapacity, 0);
     }
                        10            ,0
     public Vector(int initialCapacity, int capacityIncrement) {
       
        this.elementData = new Object[initialCapacity]; //�൱��this.elementData=new Object[10];
        this.capacityIncrement = capacityIncrement;  //this.capacityIncrement=0;
    }
    (2)����add�������Ԫ��
    
     public synchronized boolean add(E e) {
      
        ensureCapacityHelper(elementCount + 1); //��������Ƿ� ��
        elementData[elementCount++] = e;  //���Ԫ�أ�ͬʱԪ�ظ�����1
        return true;
    }
	 * */
	public static void main(String[] args) {
		//�����˼��϶���
		Vector vector=new Vector();
		System.out.println(vector.capacity()+"\t������Ԫ�صĸ���:"+vector.size());
		//ArrayList al=new ArrayList();
		//al.add("hello");
		//���
		vector.add("hello");
		vector.add(0, "world");
		vector.addElement("java"); //���Ԫ��
		vector.add("hello");
		vector.add(0, "world");
		vector.add("hello");
		vector.add(0, "world");
		vector.add("hello");
		vector.add(0, "world");
		
		vector.add(0, "world");
		vector.add("hello");//��ӵ�ʮһ��Ԫ��
		System.out.println(vector.capacity()+"\t������Ԫ�صĸ���:"+vector.size());
		System.out.println("������Ԫ�صĸ���:"+vector.size());
		System.out.println(vector);
		//ɾ��
		//vector.remove(1);
		//vector.remove("java");
		//vector.clear();
		//vector.removeElement("java");
		//��ȡԪ�صķ���
		System.out.println(vector.get(1));
		
		System.out.println(vector);
		System.out.println("��ǿforѭ��");
		for(Object obj:vector){
			System.out.println(obj);
		}
		System.out.println("ʹ�õ�������������:");
		for(Iterator ite=vector.iterator();ite.hasNext();){
			System.out.println(ite.next());
		}
		
		Iterator ite=vector.iterator(); 
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}
}
