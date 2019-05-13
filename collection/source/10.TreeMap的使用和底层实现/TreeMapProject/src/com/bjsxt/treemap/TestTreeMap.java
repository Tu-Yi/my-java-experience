package com.bjsxt.treemap;

import java.util.Comparator;
import java.util.TreeMap;


public class TestTreeMap {
	/***
	 * TreeMap�ĵײ�ʵ��
	 * 
	 *  private final Comparator<? super K> comparator;  �ⲿ�Ƚ��������ڱȽϴ�С��
	 *  private transient Entry<K,V> root;   //�����������
	 * public TreeMap() {
        comparator = null;
       }
       public V put(K key, V value) {
        Entry<K,V> t = root;   //ָ������
        if (t == null) {
              //�Ƚϴ�С
            compare(key, key); // type (and possibly null) check
            //����һ�����ڵ�
            root = new Entry<>(key, value, null);
            
            size = 1;   //����++
            modCount++;
            return null;
        }
        int cmp;
        Entry<K,V> parent;   //���ڵ�
        // split comparator and comparable paths
         * 
        Comparator<? super K> cpr = comparator;   //null
         //����ⲿ�Ƚ���������null,˵���ⲿ�Ƚ�������
        if (cpr != null) {
            do {
                parent = t;   //��root�������ڵ�
                
                cmp = cpr.compare(key, t.key);  //�����ⲿ�Ƚ����ıȽϷ�����ʼ�ȴ�С,�����һ��int���͵�ֵ
                
                if (cmp < 0)
                    t = t.left;   //���������ϲ���
                else if (cmp > 0)   //���������ϲ���
                    t = t.right;
                else
                    return t.setValue(value);   //�ҵ��ˣ�ֵ���и���
            } while (t != null);
        }
        else {  //�ⲿ�Ƚ��������ڣ�ʹ���ڲ��Ƚ������бȽ�
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;    //root�������ڵ�
                cmp = k.compareTo(t.key);  //�����ڲ��Ƚ����ıȽϴ�С�ķ������ȽϽ��Ϊint����
                if (cmp < 0)   
                    t = t.left;     //���������ϲ���
                else if (cmp > 0)   //���������ϲ���
                    t = t.right;
                else
                    return t.setValue(value);   �ҵ���ֵ�ĸ���
            } while (t != null);
        }
         //����һ���ڵ�
        Entry<K,V> e = new Entry<>(key, value, parent);
        
        if (cmp < 0)
            parent.left = e;   //��ӵ�������
        else
            parent.right = e;    //��ӵ�������
        fixAfterInsertion(e);
        size++;      
        modCount++;
        return null;
    }
	 */
	public static void main(String[] args) {
		//�������϶���
		//TreeMap treeMap=new TreeMap();
		//�����ⲿ�Ƚ�������,����ȽϹ���
		Comparator comLength=new CompareLength();
		TreeMap treeMap=new TreeMap(comLength);
		//�������
		treeMap.put("hello", 123);
		treeMap.put("world1", 456);
		treeMap.put("hello11", 789);
		treeMap.put("java", 1000);
		System.out.println("������Ԫ�صĸ���:"+treeMap.size());
		System.out.println(treeMap);
		System.out.println(treeMap.containsKey("hello")+"\t"+treeMap.containsKey("sql"));
		System.out.println(treeMap.containsValue(789)+"\t"+treeMap.containsValue(1002));
		System.out.println(treeMap.get("java"));
		
		
	}
}
