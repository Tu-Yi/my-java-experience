package com.bjsxt.treemap;

import java.util.Comparator;
import java.util.TreeMap;


public class TestTreeMap {
	/***
	 * TreeMap的底层实现
	 * 
	 *  private final Comparator<? super K> comparator;  外部比较器，用于比较大小的
	 *  private transient Entry<K,V> root;   //代表的是树根
	 * public TreeMap() {
        comparator = null;
       }
       public V put(K key, V value) {
        Entry<K,V> t = root;   //指向树根
        if (t == null) {
              //比较大小
            compare(key, key); // type (and possibly null) check
            //创建一个根节点
            root = new Entry<>(key, value, null);
            
            size = 1;   //个数++
            modCount++;
            return null;
        }
        int cmp;
        Entry<K,V> parent;   //父节点
        // split comparator and comparable paths
         * 
        Comparator<? super K> cpr = comparator;   //null
         //如果外部比较器不等于null,说明外部比较器存在
        if (cpr != null) {
            do {
                parent = t;   //把root赋给父节点
                
                cmp = cpr.compare(key, t.key);  //调用外部比较器的比较方法开始比大小,结果是一个int类型的值
                
                if (cmp < 0)
                    t = t.left;   //在左子树上查找
                else if (cmp > 0)   //在右子树上查找
                    t = t.right;
                else
                    return t.setValue(value);   //找到了，值进行覆盖
            } while (t != null);
        }
        else {  //外部比较器不存在，使用内部比较器进行比较
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;    //root赋给父节点
                cmp = k.compareTo(t.key);  //调用内部比较器的比较大小的方法，比较结果为int类型
                if (cmp < 0)   
                    t = t.left;     //在左子树上查找
                else if (cmp > 0)   //在右子树上查找
                    t = t.right;
                else
                    return t.setValue(value);   找到了值的覆盖
            } while (t != null);
        }
         //创建一个节点
        Entry<K,V> e = new Entry<>(key, value, parent);
        
        if (cmp < 0)
            parent.left = e;   //添加到左子树
        else
            parent.right = e;    //添加到右子树
        fixAfterInsertion(e);
        size++;      
        modCount++;
        return null;
    }
	 */
	public static void main(String[] args) {
		//创建集合对象
		//TreeMap treeMap=new TreeMap();
		//创建外部比较器对象,定义比较规则
		Comparator comLength=new CompareLength();
		TreeMap treeMap=new TreeMap(comLength);
		//添加数据
		treeMap.put("hello", 123);
		treeMap.put("world1", 456);
		treeMap.put("hello11", 789);
		treeMap.put("java", 1000);
		System.out.println("集合中元素的个数:"+treeMap.size());
		System.out.println(treeMap);
		System.out.println(treeMap.containsKey("hello")+"\t"+treeMap.containsKey("sql"));
		System.out.println(treeMap.containsValue(789)+"\t"+treeMap.containsValue(1002));
		System.out.println(treeMap.get("java"));
		
		
	}
}
