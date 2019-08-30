package com.bjsxt.pojo;

public class Star {
	private String username;
	private int age;
	
	//域属性，也称为对象属性
	private Parter parter;
	
	public Parter getParter() {
		return parter;
	}
	public void setParter(Parter parter) {
		this.parter = parter;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Star [username=" + username + ", age=" + age + ", parter=" + parter + "]";
	}
	
	
	
}
