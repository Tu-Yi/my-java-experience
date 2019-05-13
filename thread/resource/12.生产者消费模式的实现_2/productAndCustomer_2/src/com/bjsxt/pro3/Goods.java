package com.bjsxt.pro3;

public class Goods {
	private String name;//名称
	private String brand;//品牌
	private boolean isFlag;//用于标识是否有商品 ,假设为true时代表有商品，false时代表没有商品
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
		if(isFlag){//相当于isFlag==true
			try {
				super.wait();//生产者线程等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  //当生产者线程被唤醒后从wait()之后的代码开始执行
		//生产商品
		this.setName(name);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBrand(brand);
		System.out.println("-------生产者线程生产了-------"+this.getBrand()+"-------"+this.getName());
		//通知消费者
		super.notify();
		isFlag=true;
	}
	//编写一个取值的方法
	public synchronized void get(){
		if(!isFlag){  // 相不于isFlag==false
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//消费者等待
		}//消费者线程被唤醒后从wait()之后开始执行
		
		System.out.println("消费者线程取走了------"+this.getBrand()+"--------"+this.getName());
		super.notify();//通知生产者线程
		isFlag=false;//没有商品
	}
	
}
