package com.bjsxt.generic;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		//创建集合对象，同时明确了集合中所存储的对象的类型只能是Person类型
		ArrayList<Person> al=new ArrayList<Person>();
		//创建Person类型的对象添加到集合中
		Person p1=new Person("marry", 20);
		Person p2=new Person("lili",29);
		Person p3=new Person("jack",18);
		//添加以集合中
		al.add(p1);
		al.add(p2);
		al.add(p3);
		//遍历集合
		print(al);
		
		
		
		//创建一个集合对象，用于存储Student类型的对象
		ArrayList<Student> al2=new ArrayList<Student>();
		Student stu1=new Student("sean", 20, "sxt1001");
		Student stu2=new Student("nico",19,"sxt1002");
		//添加到集合中
		al2.add(stu1);
		al2.add(stu2);
		//需要遍历集合
		print(al2);
		
		//调用show方法
		System.out.println("\n---------------------------\n");
		show(al);
		show(al2);
		ArrayList<Object> alObject=new ArrayList<Object>();
		Object ob1=new Object();
		Object obj2=new Object();
		alObject.add(ob1);
		alObject.add(obj2);
		
		show(alObject);
	}
	//Person及Person的子类
	public static void print(ArrayList<? extends Person> al){ //相当于ArrayList<Person> al=new ArrayList<Student>();不匹配
		for (Person p : al) {
			System.out.println(p);
		}
	}
	public static void show(ArrayList<? super Student> al){
		for (Object obj : al) {
			System.out.println(obj);
		}
	}
}
