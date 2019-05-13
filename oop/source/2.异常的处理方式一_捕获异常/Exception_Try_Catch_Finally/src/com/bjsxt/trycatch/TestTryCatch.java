package com.bjsxt.trycatch;

import java.util.Scanner;

public class TestTryCatch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try{
			System.out.println("请输入被除数:");
			int numA = input.nextInt();
			System.out.println("请输入除数:");
			int numB = input.nextInt();
			int result = numA / numB;
			System.out.println(numA + "/" + numB + "=" + result);
			
		}catch(ArithmeticException e){//ArithmeticException e=new InputMismatchException();不成功
		//catch(Exception e){//相当于Exception e=new ArithmeticException()多态的表示形式，父类引用指向了子类对象
			e.printStackTrace();
		}

		System.out.println("程序结束，谢谢您的使用!");
	}
}
