package com.bjsxt.pro3;

public class Goods {
	private String name;//����
	private String brand;//Ʒ��
	private boolean isFlag;//���ڱ�ʶ�Ƿ�����Ʒ ,����Ϊtrueʱ��������Ʒ��falseʱ����û����Ʒ
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
		if(isFlag){//�൱��isFlag==true
			try {
				super.wait();//�������̵߳ȴ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  //���������̱߳����Ѻ��wait()֮��Ĵ��뿪ʼִ��
		//������Ʒ
		this.setName(name);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBrand(brand);
		System.out.println("-------�������߳�������-------"+this.getBrand()+"-------"+this.getName());
		//֪ͨ������
		super.notify();
		isFlag=true;
	}
	//��дһ��ȡֵ�ķ���
	public synchronized void get(){
		if(!isFlag){  // �಻��isFlag==false
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//�����ߵȴ�
		}//�������̱߳����Ѻ��wait()֮��ʼִ��
		
		System.out.println("�������߳�ȡ����------"+this.getBrand()+"--------"+this.getName());
		super.notify();//֪ͨ�������߳�
		isFlag=false;//û����Ʒ
	}
	
}
