package com.bjsxt.arraylist;

import java.util.ArrayList;
import java.util.Arrays;


public class TestArrayList {
	/**ArrayList源码分析
	 * (1)无参构造方法
	 *       this.elementData 是一个Object类型的数组
	 *       DEFAULTCAPACITY_EMPTY_ELEMENTDATA;也是一个Object类型的数组
	 *       DEFAULTCAPACITY_EMPTY_ELEMENTDATA={};默认长度为0
	 *     public ArrayList() {
               this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
               //相当于this.elementData={};
          }
        (2)带参构造方法
            
         public ArrayList(int initialCapacity) {
	        if (initialCapacity > 0) {
	            this.elementData = new Object[initialCapacity];
	            //this.elementData=new Object[20];
	        } 
    	}
    	(3)添加方法 add(Object obj)
    	 public boolean add(E e) {
    	        //检测空间容量是否够用
		        ensureCapacityInternal(size + 1);  // Increments modCount!!
		        //添加元素    elementData[size]=e; size++;
		        elementData[size++] = e;
		        return true;
    	}
    	(4)检测空间容量是否够用
    	private void ensureCapacityInternal(int minCapacity) {
        	ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    	}
    	首先调用执行 ,计算容量
         calculateCapacity(elementData, minCapacity)
         
         //calculateCapacity方法定义
         private static int calculateCapacity(Object[] elementData, int minCapacity) {
		            //以下代码相当于elementData=={}
		        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {  //true
		                   //Math.max(10,1);
		            return Math.max(DEFAULT_CAPACITY, minCapacity);
		        }
        return minCapacity;  //执行完之后的结果为  10
       }
        //容量计算完毕后，执行ensureExplicitCapacity方法    ensureExplicitCapacity(10)
         ensureExplicitCapacity方法定义
         
         private void ensureExplicitCapacity(int minCapacity) {  //10
	        modCount++;
	
	        // overflow-conscious code
	         * 10-0 >0  true
	        if (minCapacity - elementData.length > 0)
	            grow(minCapacity);
	    }
	    (5)扩充容量
	      private void grow(int minCapacity) {    //10
	        // overflow-conscious code
	        int oldCapacity = elementData.length;        //int oldCapactiy=0;
	        
	        int newCapacity = oldCapacity + (oldCapacity >> 1);   //int newCapacity=0+0>>1  结果为0
	      
	        if (newCapacity - minCapacity < 0)       // 0-10<0    true
	        
	            newCapacity = minCapacity;           //newCapacity=10;
	            
	      
	        elementData = Arrays.copyOf(elementData, newCapacity); //数组拷贝 elementData的长度就是 10
    }
	 * */
       
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		//第一次调用添加方法时，完成Object类型数组的初始化容量 ，10
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");//10个元素对象
		/**当添加第11个元素时，所需容量为11，而数组的长度为10，已经无法容纳元素了，这个时候需要扩容，
		 * 原始容量+原始容量>>1   得到新容量
		 * 10+10>>1           15*/
		
		list.add("hello");//当添加第11个元素对象时 怎么办？
		
		Object [] obj={};
		
		
	}
}
