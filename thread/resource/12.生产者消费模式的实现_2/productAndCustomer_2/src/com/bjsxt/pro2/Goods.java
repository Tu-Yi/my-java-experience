package com.bjsxt.pro2;

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
	//��дһ����ֵ�ķ���  ͬ��������ΪGoods��Ķ���
	public synchronized void set(String name,String brand){
		this.setName(name);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBrand(brand);
		System.out.println("-------�������߳�������-------"+this.getBrand()+"-------"+this.getName());
	}
	//��дһ��ȡֵ�ķ���
	public synchronized void get(){
		System.out.println("�������߳�ȡ����------"+this.getBrand()+"--------"+this.getName());
	}
	
}
