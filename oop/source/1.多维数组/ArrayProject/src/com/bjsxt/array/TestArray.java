package com.bjsxt.array;

public class TestArray {
	public static void main(String[] args) {
		//(1)������Դ洢�����������ͺ�������������
		int [] arrA={11,22,33,44}; //һά���飬������������
		/**��������  [] ������=new ��������[����]*/
		System.out.println(arrA);
		//(2)��ά����洢һά���������
		int [] [] arrB=new int[3][];
		//ʹ�ö�ά����ȥ�洢һά����
		arrB[0]=arrA;  //����
		System.out.println(arrB);
		
		
		
	}
}
