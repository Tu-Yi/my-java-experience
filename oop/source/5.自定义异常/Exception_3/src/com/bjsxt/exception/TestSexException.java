package com.bjsxt.exception;

import java.util.Scanner;

public class TestSexException {
	public static void main(String[] args)   {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入您的性别:");
		String gender=input.next();
		if("男".equals(gender)||"女".equals(gender)){
			System.out.println("性别录入正确");
		}else{
			try {
				throw new SexException("性别只能是男或者女");
			} catch (SexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		
	}
}
