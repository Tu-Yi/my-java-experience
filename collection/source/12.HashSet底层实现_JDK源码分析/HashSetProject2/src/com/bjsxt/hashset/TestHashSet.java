package com.bjsxt.hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
	/***
	 * HashSet�ײ�Դ�����
	 *  private transient HashMap<E,Object> map;
	 *   private static final Object PRESENT = new Object();
	 *  public HashSet() {
             map = new HashMap<>();//����HashSetʱ���ײ㴴������һ��HashMap����
     }
     public boolean add(E e) {
                     key-->e ,value-->PRESENT ,��һ��Object���͵Ķ���
                     map�����е�����value����ͳһ��Object���Ͷ���
        return map.put(e, PRESENT)==null;
        
     }
     public int size() {
        return map.size();
    }
    
     public boolean contains(Object o) {
        return map.containsKey(o);  //��map�������ж�key�Ƿ����
    }
    public Iterator<E> iterator() {
          //��ȡmap���������е�key�ļ��ϣ��ٵõ�����������
        return map.keySet().iterator();
    }
    HashSetʹ����HashMap�����ݽṹ��
         �ײ㶼�ǹ�ϣ�� (˳���+����)
	 * @param args
	 */
	public static void main(String[] args) {
		//HashSet�ײ�����ṹʹ�õ���hash��  ,���ṹ����, +����
		//�������϶���
		HashSet hs=new HashSet();
		hs.add("hello");
		hs.add("world");
		hs.add("java");
		System.out.println(hs.add("world"));
		System.out.println("������Ԫ�صĸ���:"+hs.size());
		System.out.println(hs);
		System.out.println(hs.contains("java")+"\t"+hs.contains("sql"));
		//ʹ�õ���������Ԫ��
		Iterator ite=hs.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		
	}
}
