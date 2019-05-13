package com.bjsxt.arraylist.source;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
	/**
	 * ArrayListԴ�����_2
	 * (1)add(int index,Object obj)
	 *  public void add(int index, E element) {
	       
	                        //Դ����              ,Դ���鿪ʼλ��  ,������            ,�����鿪ʼλ��
	        System.arraycopy(elementData, index,  elementData, index + 1,
	                         size - index);  //size-index ��������Ԫ�صĸ���
	                         
	        elementData[index] = element;//��Ԫ����ӵ�����Ϊ index��λ����
	        size++;            //Ԫ�صĸ���+1
    }
     (2)get(int index)����������ȡԪ�ض���
        public E get(int index) {
        
            return elementData(index);  //������elementData()�ķ���
       }
         //elementData�����Ķ���
        E elementData(int index) {
        
        return (E) elementData[index];   //��Object���͵������и�������ȡ��Ԫ�ض���
    }
    (3)size()
       public int size() {
        return size;   //���ڼ�¼������Ԫ�صĸ���
      }
    (4)isEmpty()
       public boolean isEmpty() {
        return size == 0;  //������һ��Ԫ�ض�û�е�ʱ�򣬼��Ͼ��ǿյ�
       }
    (5)set(int index, Object obj)
	    public E set(int index, E element) {
	        
	        E oldValue = elementData(index);   //���������������л�ȡԪ��
	        
	        elementData[index] = element;  //����Ԫ�����õ�����������Ϊindex��λ����
	        
	        return oldValue;        //����ԭʼԪ�ض���
	    }
	  (6)remove(int index)
	  
		  public E remove(int index) {
	         
	        E oldValue = elementData(index);//����������ȡԭʼԪ�ض���
	
	        int numMoved = size - index - 1;   //������Ԫ�صĸ���
	        
	        if (numMoved > 0)
	            System.arraycopy(elementData, index+1, elementData, index,
	                             numMoved);
	                             
	        elementData[--size] = null; //   �����һ��λ������Ϊnull
	
	        return oldValue;        //����ԭʼԪ�ض���
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
		//����ArrayList���϶���
		ArrayList list=new ArrayList();
		list.add("hello");
		list.add("world");
		list.add(0, "java");//������Ϊ0��λ�������"java"
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
