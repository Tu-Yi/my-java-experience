package com.bjsxt.treeset;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeSet;

/** 
 * TreeSet的底层所使用的是TreeMap   -->红黑树
 * TreeSet JDK源码分析
 *  private transient NavigableMap<E,Object> m;  //一个接口,间接继承了Map
 *    private static final Object PRESENT = new Object();
 *  public TreeSet() {
        this(new TreeMap<E,Object>());  //创建了一个TreeMap的对象
    }
    //调用的本类中的带参构造方法
    TreeSet(NavigableMap<E,Object> m) {
        this.m = m;   //接口new 实现类
    }
     public TreeSet(Comparator<? super E> comparator) {
        this(new TreeMap<>(comparator));  //调用了本类中的带参构造方法
    }
    添加方法
     public boolean add(E e) {
        return m.put(e, PRESENT)==null;  //传入的元素作为Map中的key，统一的值为Object类型的对象
    }
    public int size() {
        return m.size();
    }
    
    
 * @author Administrator
 *
 */
public class TestTreeSet {
	public static void main(String[] args) {
	
		//创建集合对象
		//TreeSet ts=new TreeSet();
		//Comparator comc=new ComCharactor();//创建外部比较器对象
		Comparator com=new ComCharactorAndAge();
		TreeSet ts=new TreeSet(com);
		//创建Person对象
		Person p1=new Person("marry", 20);
		Person p2=new Person("lili", 19);
		Person p3=new Person("jack", 20);
		Person p4=new Person("marry", 18);
		//添加到集合中
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		System.out.println("集合中元素的个数:"+ts.size());
		System.out.println(ts);
	}
}
