package com.bjsxt.trycatch;

import java.util.Scanner;

public class TestTryFinally {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		try{
			System.out.println("�����뱻����:");
			int numA=input.nextInt();
			System.out.println("���������:");
			int numB=input.nextInt();
			int result=numA/numB;
			System.out.println(numA+"/"+numB+"="+result);
			//�˳�java�����
			System.exit(0);
		}finally{
			System.out.println("finally�еĴ���");
		}
	}
}
