package com.bjsxt.exception;

import java.util.Scanner;

public class TestSexException {
	public static void main(String[] args)   {
		Scanner input=new Scanner(System.in);
		System.out.println("�����������Ա�:");
		String gender=input.next();
		if("��".equals(gender)||"Ů".equals(gender)){
			System.out.println("�Ա�¼����ȷ");
		}else{
			try {
				throw new SexException("�Ա�ֻ�����л���Ů");
			} catch (SexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		
	}
}
