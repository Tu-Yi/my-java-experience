package com.niliv.pojo;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String post;
	private int salary;
	private int assistance;
	public Employee(int id, String name, int age, String post, int salary, int assistance) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.post = post;
		this.salary = salary;
		this.assistance = assistance;
	}
	public Employee() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAssistance() {
		return assistance;
	}
	public void setAssistance(int assistance) {
		this.assistance = assistance;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", post=" + post + ", salary=" + salary
				+ ", assistance=" + assistance + "]";
	}
	
	
}
