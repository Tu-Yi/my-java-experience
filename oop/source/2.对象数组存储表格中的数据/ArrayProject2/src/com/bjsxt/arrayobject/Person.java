package com.bjsxt.arrayobject;

public class Person {
	private String name;//姓名
	private int age;//年龄
	private String gender;//性别
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
}
