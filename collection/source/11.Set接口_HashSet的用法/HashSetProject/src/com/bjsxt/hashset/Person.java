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
	//Person�������дhashCode()������equals()����
	//Hash��ԭ��
	/***
	 * (1)����hashCode()��������Hash��ֵ
	 * (2)����y=k(x)�����ĺ�������洢λ��
	 * (3)���λ����û��Ԫ�أ���Ԫ�ش洢
	 * (4)�����λ������Ԫ�أ��������equals�����Ƚ������Ƿ���ͬ
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
