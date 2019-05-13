package com.bjsxt.treemap;

public class Person implements Comparable {
	private String name;
	private int age;
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
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Person p=(Person)o;
		return this.age-p.getAge();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
