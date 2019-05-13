package com.bjsxt.treeset;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeSet;

/** 
 * TreeSet�ĵײ���ʹ�õ���TreeMap   -->�����
 * TreeSet JDKԴ�����
 *  private transient NavigableMap<E,Object> m;  //һ���ӿ�,��Ӽ̳���Map
 *    private static final Object PRESENT = new Object();
 *  public TreeSet() {
        this(new TreeMap<E,Object>());  //������һ��TreeMap�Ķ���
    }
    //���õı����еĴ��ι��췽��
    TreeSet(NavigableMap<E,Object> m) {
        this.m = m;   //�ӿ�new ʵ����
    }
     public TreeSet(Comparator<? super E> comparator) {
        this(new TreeMap<>(comparator));  //�����˱����еĴ��ι��췽��
    }
    ��ӷ���
     public boolean add(E e) {
        return m.put(e, PRESENT)==null;  //�����Ԫ����ΪMap�е�key��ͳһ��ֵΪObject���͵Ķ���
    }
    public int size() {
        return m.size();
    }
    
    
 * @author Administrator
 *
 */
public class TestTreeSet {
	public static void main(String[] args) {
	
		//�������϶���
		//TreeSet ts=new TreeSet();
		//Comparator comc=new ComCharactor();//�����ⲿ�Ƚ�������
		Comparator com=new ComCharactorAndAge();
		TreeSet ts=new TreeSet(com);
		//����Person����
		Person p1=new Person("marry", 20);
		Person p2=new Person("lili", 19);
		Person p3=new Person("jack", 20);
		Person p4=new Person("marry", 18);
		//��ӵ�������
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		System.out.println("������Ԫ�صĸ���:"+ts.size());
		System.out.println(ts);
	}
}
