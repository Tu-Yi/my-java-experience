package com.bjsxt.exception;

import java.util.Scanner;

public class TestRuntimeException {
	public static void main(String[] args) {
		//(1)�����쳣
		int b=0;
		if(b!=0){
			int result=1/b;
		}else{
			System.out.println("�Բ����������Ϊ0");
		}
		
		//(2)��ָ���쳣,û�д�������(new)�������˶�������Ի򷽷� NullPointerException
		String str=null;
		if(str!=null){
			System.out.println(str.length());
		}
		//(3)����ת���쳣ClassCastException
		Animal dog=new Dog(); //��������ת��
		if(dog instanceof Cat){  //boolean
			Cat c=(Cat)dog; //��������ת��,ת������ʵ���������
		}
		//(4)�����±�Խ��ArrayIndexOutOfBoundsException
		int []arr={11,22,33};//����3
		int index=3;
		if(index<arr.length-1){
			System.out.println(arr[index]);
		}else{
			System.out.println("�����±�Խ���˱߽�");
		}
		//(5)����������������������������Ͳ���ƥ��InputMismatchException
		Scanner input=new Scanner(System.in);
		if(input.hasNextInt()){  //boolean  -->true,  false
			int a=input.nextInt();
			System.out.println(a);
		}else{
			System.out.println("�Բ�����������������������Ͳ�ƥ��");
		}
		
	}
}
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}
