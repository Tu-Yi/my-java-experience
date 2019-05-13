package com.bjsxt.treeset;

public class Person implements Comparable {
	private String name;//姓名
	private int age;//年龄
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
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		//按照年龄的升序比较
		Person p=(Person)o;
		
		return this.age-p.getAge();
	}
	
}
