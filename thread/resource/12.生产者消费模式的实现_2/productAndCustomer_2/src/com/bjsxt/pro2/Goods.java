package com.bjsxt.pro2;

public class Goods {
	private String name;//名称
	private String brand;//品牌
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
	//编写一个赋值的方法  同步监视器为Goods类的对象
	public synchronized void set(String name,String brand){
		this.setName(name);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBrand(brand);
		System.out.println("-------生产者线程生产了-------"+this.getBrand()+"-------"+this.getName());
	}
	//编写一个取值的方法
	public synchronized void get(){
		System.out.println("消费者线程取走了------"+this.getBrand()+"--------"+this.getName());
	}
	
}
