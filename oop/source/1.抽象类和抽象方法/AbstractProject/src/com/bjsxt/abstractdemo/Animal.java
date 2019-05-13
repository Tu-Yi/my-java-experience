package com.bjsxt.abstractdemo;

public abstract class Animal {//动物
	public abstract void shout();//抽象方法
}
class Dog extends Animal{

	@Override
	public void shout() {
		System.out.println("小狗,汪汪叫..........");
	}
	
}
class Cat extends Animal{

	@Override
	public void shout() {
		System.out.println("小猫，喵喵叫................");
		
	}
	
}