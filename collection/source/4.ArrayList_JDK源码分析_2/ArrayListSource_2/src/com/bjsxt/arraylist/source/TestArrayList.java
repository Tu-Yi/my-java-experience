package com.bjsxt.arraylist.source;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
	/**
	 * ArrayList源码分析_2
	 * (1)add(int index,Object obj)
	 *  public void add(int index, E element) {
	       
	                        //源数组              ,源数组开始位置  ,新数组            ,新数组开始位置
	        System.arraycopy(elementData, index,  elementData, index + 1,
	                         size - index);  //size-index ，拷贝的元素的个数
	                         
	        elementData[index] = element;//将元素添加到索引为 index的位置上
	        size++;            //元素的个数+1
    }
     (2)get(int index)根据索引获取元素对象
        public E get(int index) {
        
            return elementData(index);  //调用了elementData()的方法
       }
         //elementData方法的定义
        E elementData(int index) {
        
        return (E) elementData[index];   //在Object类型的数组中根据索引取出元素对象
    }
    (3)size()
       public int size() {
        return size;   //用于记录集合中元素的个数
      }
    (4)isEmpty()
       public boolean isEmpty() {
        return size == 0;  //集合中一个元素都没有的时候，集合就是空的
       }
    (5)set(int index, Object obj)
	    public E set(int index, E element) {
	        
	        E oldValue = elementData(index);   //根据索引在数组中获取元素
	        
	        elementData[index] = element;  //将新元素设置到数组中索引为index的位置上
	        
	        return oldValue;        //返回原始元素对象
	    }
	  (6)remove(int index)
	  
		  public E remove(int index) {
	         
	        E oldValue = elementData(index);//根据索引获取原始元素对象
	
	        int numMoved = size - index - 1;   //拷贝的元素的个数
	        
	        if (numMoved > 0)
	            System.arraycopy(elementData, index+1, elementData, index,
	                             numMoved);
	                             
	        elementData[--size] = null; //   将最后一个位置设置为null
	
	        return oldValue;        //返回原始元素对象
     }
      (7)clear()
        public void clear() {
        
        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
     }
      (8)iterator()
	 * */
	public static void main(String[] args) {
		//创建ArrayList集合对象
		ArrayList list=new ArrayList();
		list.add("hello");
		list.add("world");
		list.add(0, "java");//在索引为0的位置上添加"java"
		System.out.println(list);
		System.out.println(list.get(1));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.set(2, "sql"));
		System.out.println(list);
		list.remove(1);
		list.clear();
		Iterator ite= list.iterator();
		while(ite.hasNext()){
			Object obj=ite.next();
			System.out.println(obj);
		}
		
	}
}
