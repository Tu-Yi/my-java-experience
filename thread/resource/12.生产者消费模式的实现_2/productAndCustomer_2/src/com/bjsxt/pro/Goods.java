package com.bjsxt.pro;

public class Goods {
	private String name;//����
	private String brand;//Ʒ��
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Goods(String name, String brand) {
		super();
		this.name = name;
		this.brand = brand;
	}
	public Goods() {
		super();
	}
	
}
