package com.bjsxt.trycatch;

import java.util.Scanner;

public class TestTryCatchFinally {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		try{
			
			System.out.println("�����뱻����:");
			int numA=input.nextInt();
			System.out.println("���������:");
			int numB=input.nextInt();
			int result=numA/numB;
			System.out.println(numA+"/"+numB+"="+result);
		}catch(ArithmeticException e){
			System.err.println("��������Ϊ0");
			System.out.println("��ȡ�쳣���ַ�������"+e.getMessage());
			return ;
			//e.printStackTrace();//��ӡ��ջ��Ϣ
		}finally{
			System.out.println("finally�еĴ���");
		}
	}
}
