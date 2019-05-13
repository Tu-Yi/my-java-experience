package com.bjsxt.array;

public class TestArray2 {
	public static void main(String[] args) {
		//二维数组不是规则的矩阵
		int [] intA[] ={{1,2},{2,3,4},{3,4,5,6}};
		System.out.println(intA);
		
		//声明一一个二维数组，用于存储3个一维数组，每一个一维数据存多少个数组，不知道 ，null
		int [][]intB=new int[3][];
		intB[0]=new int[3];  //3
		intB[1]=new int[]{1,2,3,4};  //3
		intB[2]=new int[2];  //2
		System.out.println(intB);
		
		//声明一个二维数组，同时创建出一维数组，每个一维数组的长度均相同
		//存储三个一维数组，每个一维数组的长度为4
		int []intC[]=new int[3][4];
		System.out.println(intC);
		
	}
}
