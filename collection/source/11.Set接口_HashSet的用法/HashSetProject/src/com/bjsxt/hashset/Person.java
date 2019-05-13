package com.bjsxt.hashset;

public class Person {
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
	//Person类必须重写hashCode()方法及equals()方法
	//Hash表原理
	/***
	 * (1)调用hashCode()方法计算Hash码值
	 * (2)根据y=k(x)这样的函数计算存储位置
	 * (3)如果位置上没有元素，则将元素存储
	 * (4)如果该位置上有元素，则需调用equals方法比较内容是否相同
	 */
	@Override
	public int hashCode() {
		System.out.println("Person.hashCode()");
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Person.equals()");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
