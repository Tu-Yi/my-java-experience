package com.bjsxt.array;

public class TestArray {
	public static void main(String[] args) {
		//(1)数组可以存储基本数据类型和引用数据类型
		int [] arrA={11,22,33,44}; //一维数组，引用数据类型
		/**数据类型  [] 数组名=new 数据类型[长度]*/
		System.out.println(arrA);
		//(2)二维数组存储一维数组的数组
		int [] [] arrB=new int[3][];
		//使用二维数组去存储一维数组
		arrB[0]=arrA;  //引用
		System.out.println(arrB);
		
		
		
	}
}
