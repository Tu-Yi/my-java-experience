package com.bjsxt.object;

import java.io.Serializable;

public class Student implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4502633718082654465L;
	private String name;
	private int age;
	public static String schoolName;//ѧУ����
	private transient String pwd; //���Ե�ֵ�����ٱ����л�
	public Student() {
		super();
	}
	public Student(String name, int age, String pwd) {
		super();
		this.name = name;
		this.age = age;
		this.pwd = pwd;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", pwd=" + pwd + "]"+"schoolName="+schoolName;
	}
	
}
