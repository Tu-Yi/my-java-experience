package com.bjsxt.bubble;

import java.util.Arrays;

public class TestBubble {
	public static void main(String[] args) {
		//数组
		//int [] array={75,87,56,45,49};
		int [] array={1,2,3,4,5,6};
		System.out.println("排序之前"+Arrays.toString(array));
		/**冒泡排序的优化算法*/
		boolean flag;
		int count=0;
		int temp;
		for(int i=0;i<array.length-1;i++){  //5个数，比4次  N-1
			flag=true;//默认有序
			count++;//统计比较的轮数
			//每轮比较的次数
			for(int j=0;j<array.length-1-i;j++){  //无需比较到数组的最后，只需要比较无序数列部分即可
				//两两相比
				if(array[j]>array[j+1]){
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=false;//数据中的元素无序，发生了交换
				}
			}
			if(flag){
				break;//退出循环，证明数组有序
			}
		}
		//排序之后的数组
		System.out.println("\n排序之后:"+Arrays.toString(array));
		System.out.println("一共比较了"+count+"轮");
	}
}
