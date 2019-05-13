package com.bjsxt.enumpro;
/**枚举在自定义类中的使用*/
public class Person {
	private String name;//姓名
	private int age;//年龄
	private Gender gender;//性别
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Person(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person() {
		super();
	}
	
}
