package com.bjsxt.trycatch;

import java.util.Scanner;

public class TestTryCatch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try{
			System.out.println("�����뱻����:");
			int numA = input.nextInt();
			System.out.println("���������:");
			int numB = input.nextInt();
			int result = numA / numB;
			System.out.println(numA + "/" + numB + "=" + result);
			
		}catch(ArithmeticException e){//ArithmeticException e=new InputMismatchException();���ɹ�
		//catch(Exception e){//�൱��Exception e=new ArithmeticException()��̬�ı�ʾ��ʽ����������ָ�����������
			e.printStackTrace();
		}

		System.out.println("���������лл����ʹ��!");
	}
}
