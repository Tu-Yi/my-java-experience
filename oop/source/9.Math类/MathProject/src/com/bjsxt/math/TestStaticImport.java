package com.bjsxt.math;
import static java.lang.Math.*;
public class TestStaticImport {
	public static void main(String[] args) {
		System.out.println(abs(-20));  //���õ��Ǳ����е�abs����
		System.out.println(Math.abs(-20));
		System.out.println(random());
	}
	public static int abs(int number){
		return number;
	}
}
