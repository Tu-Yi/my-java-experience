package com.bjsxt.method;

import java.util.Arrays;
import java.util.Comparator;

public class TestArraysMethod {
	public static void main(String[] args) {
		//创建了一个一维数组
		int [] arrA={23,34,345,234};
		int [] arrB={23,34,345,234};
		//(1)Arrays.toString(数组名),快速的遍历数组元素
		System.out.println(Arrays.toString(arrA));
		System.out.println("arrA==arrB:"+(arrA==arrB)); //false
		//两个数组以相同的顺序包含相同的元素
		System.out.println(Arrays.equals(arrA, arrB));//true
		//(2)Arrays.equals(...)与Object中的equals方法有什么不同？
		System.out.println(arrA.equals(arrB));//false ,直接调用是Object中的equals方法，用于比较两个对象的内存地址(引用)是否相等
		
		//(3)copyOf(...)
		
		int [] arrC=new int[5];//默认值0
		System.out.println("前"+arrC);
		
		//arrC=Arrays.copyOf(arrA, 10);//目标数组长度不够 ，进行了重新创建arrC数组,更改了arrC的引用
		arrC=Arrays.copyOf(arrA, 5);  //重新开辟空间
		System.out.println("后"+arrC);
		System.out.println(Arrays.toString(arrC));
		//(4)填 充
		//Arrays.fill(arrC, 99);
		for(int i=0;i<arrC.length;i++){
			arrC[i]=99;
		}
		System.out.println(Arrays.toString(arrC));
		
		//对arrA数组进行排序-->升序
		Arrays.sort(arrA);
		System.out.println(Arrays.toString(arrA));
		
		//创建一个Person类型的数组，用于存储3个Person类型的对象
		Person [] pers=new Person[3];
		pers[0]=new Person("marry", 20, "女");
		pers[1]=new Person("jack", 22, "男");
		pers[2]=new Person("rose", 19, "女");
		//调用sort方法，对Person类型 的数组进行排序
		Arrays.sort(pers);  //ClassCastException异常，Person不能转换成Comparable接口类型
		//遍历数组
		for(Person p:pers){
			System.out.println(p);
		}
		/**希望按照姓名排序*/
		Arrays.sort(pers, 
				new Comparator()
		{

			@Override
			public int compare(Object o1, Object o2) {
				Person p1=(Person)o1;
				Person p2=(Person)o2;
				//调用了字符串中比较大小的方法
				return p1.getName().compareTo(p2.getName());
			}
			
		});
		System.out.println("\n按照姓名去排序");
		//遍历数组
		for(Person p:pers){
			System.out.println(p);
		}
	}
}
class Person implements Comparable<Person>{
	private String name;
	private int age;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"\t"+age+"\t"+gender;
	}
	@Override
	public int compareTo(Person o) {  //大于 正数，小于负数，等于0
	
		return this.age-o.age;
	}
}
