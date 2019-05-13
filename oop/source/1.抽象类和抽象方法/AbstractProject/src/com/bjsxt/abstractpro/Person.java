package com.bjsxt.abstractpro;

public abstract class Person {
	//(1)成员变量/实例变量/属性
	private String name;//姓名
	//(2)成员方法/实例方法
	public void info(){
		System.out.println("大家好，我叫"+name);
	}
	//(3)静态方法
	public static void show(){
		
	}
	//(4)构造方法
	public Person(){
		System.out.println("Person类中的无参构造方法");
	}
	//(5)final修饰的方法，只能被子类调用，不允许被子类重写
	public final void fun(){
		
	}
	public abstract void print();
}