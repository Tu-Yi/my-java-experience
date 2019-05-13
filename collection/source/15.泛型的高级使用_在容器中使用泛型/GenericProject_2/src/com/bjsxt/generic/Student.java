package com.bjsxt.generic;

public class Student extends Person {
	private String stuNo;//Ñ§ºÅ

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public Student(String name, int age, String stuNo) {
		super(name, age);
		this.stuNo = stuNo;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return super.toString()+"Student [stuNo=" + stuNo + "]";
	}
	
}
