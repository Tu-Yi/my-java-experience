package com.bjsxt.trycatch;

import java.util.Scanner;

public class TestTryFinally {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		try{
			System.out.println("请输入被除数:");
			int numA=input.nextInt();
			System.out.println("请输入除数:");
			int numB=input.nextInt();
			int result=numA/numB;
			System.out.println(numA+"/"+numB+"="+result);
			//退出java虚拟机
			System.exit(0);
		}finally{
			System.out.println("finally中的代码");
		}
	}
}
