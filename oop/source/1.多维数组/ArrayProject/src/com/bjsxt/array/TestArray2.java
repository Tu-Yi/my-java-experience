package com.bjsxt.array;

public class TestArray2 {
	public static void main(String[] args) {
		//��ά���鲻�ǹ���ľ���
		int [] intA[] ={{1,2},{2,3,4},{3,4,5,6}};
		System.out.println(intA);
		
		//����һһ����ά���飬���ڴ洢3��һά���飬ÿһ��һά���ݴ���ٸ����飬��֪�� ��null
		int [][]intB=new int[3][];
		intB[0]=new int[3];  //3
		intB[1]=new int[]{1,2,3,4};  //3
		intB[2]=new int[2];  //2
		System.out.println(intB);
		
		//����һ����ά���飬ͬʱ������һά���飬ÿ��һά����ĳ��Ⱦ���ͬ
		//�洢����һά���飬ÿ��һά����ĳ���Ϊ4
		int []intC[]=new int[3][4];
		System.out.println(intC);
		
	}
}
