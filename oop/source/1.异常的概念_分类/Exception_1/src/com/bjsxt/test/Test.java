package com.bjsxt.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("�����뱻����:");
		int numA=input.nextInt();
		System.out.println("���������:");
		int numB=input.nextInt();
		int result=numA/numB;
		System.out.println(numA+"/"+numB+"="+result);
	}
}
