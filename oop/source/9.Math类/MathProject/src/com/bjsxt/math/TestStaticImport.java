package com.bjsxt.math;
import static java.lang.Math.*;
public class TestStaticImport {
	public static void main(String[] args) {
		System.out.println(abs(-20));  //调用的是本类中的abs方法
		System.out.println(Math.abs(-20));
		System.out.println(random());
	}
	public static int abs(int number){
		return number;
	}
}
