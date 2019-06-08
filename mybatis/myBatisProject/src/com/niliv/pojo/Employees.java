package com.niliv.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employees implements Serializable {
	
	private int id;
	private String name;
	private String createDate;
	private String birthday;
	private int salary;
	private int did;
	
	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", createDate=" + createDate + ", birthday=" + birthday
				+ ", salary=" + salary + ", did=" + did + "]";
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	
	
}
