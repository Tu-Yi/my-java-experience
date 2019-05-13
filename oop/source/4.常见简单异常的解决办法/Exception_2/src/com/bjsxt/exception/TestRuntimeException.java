package com.bjsxt.exception;

import java.util.Scanner;

public class TestRuntimeException {
	public static void main(String[] args) {
		//(1)算术异常
		int b=0;
		if(b!=0){
			int result=1/b;
		}else{
			System.out.println("对不起除数不能为0");
		}
		
		//(2)空指针异常,没有创建对象(new)而调用了对象的属性或方法 NullPointerException
		String str=null;
		if(str!=null){
			System.out.println(str.length());
		}
		//(3)类型转换异常ClassCastException
		Animal dog=new Dog(); //向上类型转换
		if(dog instanceof Cat){  //boolean
			Cat c=(Cat)dog; //向下类型转换,转换成真实的子类对象
		}
		//(4)数组下标越界ArrayIndexOutOfBoundsException
		int []arr={11,22,33};//长度3
		int index=3;
		if(index<arr.length-1){
			System.out.println(arr[index]);
		}else{
			System.out.println("数组下标越出了边界");
		}
		//(5)期望的数据类型与输入的数据类型不相匹配InputMismatchException
		Scanner input=new Scanner(System.in);
		if(input.hasNextInt()){  //boolean  -->true,  false
			int a=input.nextInt();
			System.out.println(a);
		}else{
			System.out.println("对不起，输入的类型与期望的类型不匹配");
		}
		
	}
}
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}
