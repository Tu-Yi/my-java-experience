package com.bjsxt.abstractdemo;

public abstract class Animal {//����
	public abstract void shout();//���󷽷�
}
class Dog extends Animal{

	@Override
	public void shout() {
		System.out.println("С��,������..........");
	}
	
}
class Cat extends Animal{

	@Override
	public void shout() {
		System.out.println("Сè��������................");
		
	}
	
}