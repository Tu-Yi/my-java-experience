package com.bjsxt.abstractdemo;

public class TestAnimal {
	public static void main(String[] args) {
		//父类引用指向子类对象
		Animal dog=new Dog();
		Animal cat=new Cat();
		//调用相同的方法
		dog.shout();
		cat.shout();
		//运行的结果，各不相同(每个子类实现之后的结果)
	}
}
