package com.bjsxt.hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
	/***
	 * HashSet底层源码分析
	 *  private transient HashMap<E,Object> map;
	 *   private static final Object PRESENT = new Object();
	 *  public HashSet() {
             map = new HashMap<>();//创建HashSet时，底层创建的是一个HashMap对象
     }
     public boolean add(E e) {
                     key-->e ,value-->PRESENT ,是一个Object类型的对象
                     map集合中的所有value都是统一的Object类型对象
        return map.put(e, PRESENT)==null;
        
     }
     public int size() {
        return map.size();
    }
    
     public boolean contains(Object o) {
        return map.containsKey(o);  //在map集合中判断key是否存在
    }
    public Iterator<E> iterator() {
          //获取map集合中所有的key的集合，再得到迭代器对象
        return map.keySet().iterator();
    }
    HashSet使用了HashMap的数据结构，
         底层都是哈希表 (顺序表+链表)
	 * @param args
	 */
	public static void main(String[] args) {
		//HashSet底层数组结构使用的是hash表  ,主结构数组, +链表
		//创建集合对象
		HashSet hs=new HashSet();
		hs.add("hello");
		hs.add("world");
		hs.add("java");
		System.out.println(hs.add("world"));
		System.out.println("集合中元素的个数:"+hs.size());
		System.out.println(hs);
		System.out.println(hs.contains("java")+"\t"+hs.contains("sql"));
		//使用迭代器遍历元素
		Iterator ite=hs.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
		
	}
}
