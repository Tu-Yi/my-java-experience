package com.bjsxt.pattern;

public class FlyCar extends SuperCar {

	public FlyCar(ICar car) {
		super(car);
		
	}
	//��дmove()����
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();  //���ø������ʻ����
		
		//���÷��еķ���
		this.fly();
	}
	public void fly(){
		System.out.println("�������Է��У���Ϊ�г��");
	}
}
