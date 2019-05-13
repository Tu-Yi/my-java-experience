package com.bjsxt.arraylist;

import java.util.ArrayList;
import java.util.Arrays;


public class TestArrayList {
	/**ArrayListԴ�����
	 * (1)�޲ι��췽��
	 *       this.elementData ��һ��Object���͵�����
	 *       DEFAULTCAPACITY_EMPTY_ELEMENTDATA;Ҳ��һ��Object���͵�����
	 *       DEFAULTCAPACITY_EMPTY_ELEMENTDATA={};Ĭ�ϳ���Ϊ0
	 *     public ArrayList() {
               this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
               //�൱��this.elementData={};
          }
        (2)���ι��췽��
            
         public ArrayList(int initialCapacity) {
	        if (initialCapacity > 0) {
	            this.elementData = new Object[initialCapacity];
	            //this.elementData=new Object[20];
	        } 
    	}
    	(3)��ӷ��� add(Object obj)
    	 public boolean add(E e) {
    	        //���ռ������Ƿ���
		        ensureCapacityInternal(size + 1);  // Increments modCount!!
		        //���Ԫ��    elementData[size]=e; size++;
		        elementData[size++] = e;
		        return true;
    	}
    	(4)���ռ������Ƿ���
    	private void ensureCapacityInternal(int minCapacity) {
        	ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    	}
    	���ȵ���ִ�� ,��������
         calculateCapacity(elementData, minCapacity)
         
         //calculateCapacity��������
         private static int calculateCapacity(Object[] elementData, int minCapacity) {
		            //���´����൱��elementData=={}
		        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {  //true
		                   //Math.max(10,1);
		            return Math.max(DEFAULT_CAPACITY, minCapacity);
		        }
        return minCapacity;  //ִ����֮��Ľ��Ϊ  10
       }
        //����������Ϻ�ִ��ensureExplicitCapacity����    ensureExplicitCapacity(10)
         ensureExplicitCapacity��������
         
         private void ensureExplicitCapacity(int minCapacity) {  //10
	        modCount++;
	
	        // overflow-conscious code
	         * 10-0 >0  true
	        if (minCapacity - elementData.length > 0)
	            grow(minCapacity);
	    }
	    (5)��������
	      private void grow(int minCapacity) {    //10
	        // overflow-conscious code
	        int oldCapacity = elementData.length;        //int oldCapactiy=0;
	        
	        int newCapacity = oldCapacity + (oldCapacity >> 1);   //int newCapacity=0+0>>1  ���Ϊ0
	      
	        if (newCapacity - minCapacity < 0)       // 0-10<0    true
	        
	            newCapacity = minCapacity;           //newCapacity=10;
	            
	      
	        elementData = Arrays.copyOf(elementData, newCapacity); //���鿽�� elementData�ĳ��Ⱦ��� 10
    }
	 * */
       
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		//��һ�ε�����ӷ���ʱ�����Object��������ĳ�ʼ������ ��10
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("world");//10��Ԫ�ض���
		/**����ӵ�11��Ԫ��ʱ����������Ϊ11��������ĳ���Ϊ10���Ѿ��޷�����Ԫ���ˣ����ʱ����Ҫ���ݣ�
		 * ԭʼ����+ԭʼ����>>1   �õ�������
		 * 10+10>>1           15*/
		
		list.add("hello");//����ӵ�11��Ԫ�ض���ʱ ��ô�죿
		
		Object [] obj={};
		
		
	}
}
