package com.bjsxt.abstractpro;

public abstract class Student extends Person {
	public Student(){
		super();//调用直接父类的无参构造方法
		System.out.println("Student类的无参构造方法");
	}

}
