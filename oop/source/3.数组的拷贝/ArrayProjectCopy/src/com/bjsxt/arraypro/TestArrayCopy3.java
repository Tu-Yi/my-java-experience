package com.bjsxt.arraypro;

public class TestArrayCopy3 {
	public static void main(String[] args) {
		int [] arrA={11,22,33,44};//Դ����
		int [] arrB=new int[5];//Ŀ������
		
		System.out.println("���鿽��֮ǰ");
		for(int num:arrB){
			System.out.print(num+"\t");
		}
		//����
		System.arraycopy(arrA, 0, arrB, 1, 2);
		
		System.out.println("\n���鿽��֮��");
		for(int num:arrB){
			System.out.print(num+"\t");
		}
		
	}
}
