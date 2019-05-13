package com.bjsxt.arrayobject;

public class TestArray {
	public static void main(String[] args) {
		//创建一个Person类型的数组，用于存储3个Person类型的对象
		Person [] pers=new Person[3];
		//创建Person类型的对象
		Person p1=new Person("张三", 19, "男");
		//将p1对象存储到Person类型的数组中
		pers[0]=p1;
		
		pers[1]=new Person("李四", 20, "女");
		pers[2]=new Person("王五",28,"男");
		
		for(int i=0;i<pers.length;i++){
			System.out.println(pers[i]);
		}
		//对象数组中存储的是对象的引用（内存地址）
	}
}
