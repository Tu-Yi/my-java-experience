package com.bjsxt.innermethod;

public class Outer {
	//Outer的成员方法
	public void show(){
		int a=10;//方法中的局部变量
		//内部类相当于show方法中的局部变量，使用范围只能在show方法中
		class Inner{
			public void fun(){
				System.out.println("a="+a);
			}
		}
		//创建内部类的对象
		new Inner().fun();
	}
}
