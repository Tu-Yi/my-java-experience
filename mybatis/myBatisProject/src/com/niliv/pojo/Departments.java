package com.niliv.pojo;

import java.io.Serializable;

public class Departments implements Serializable {
	
	private int id;
	private String name;
	private String address;
	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", address=" + address + "]";
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
