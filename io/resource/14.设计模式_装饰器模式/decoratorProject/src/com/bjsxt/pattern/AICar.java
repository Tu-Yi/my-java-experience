package com.bjsxt.pattern;

public class AICar extends SuperCar{

	public AICar(ICar car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		this.autoDrive();
	}
	public void autoDrive(){
		System.out.println("可以自动行驶");
	}
}
