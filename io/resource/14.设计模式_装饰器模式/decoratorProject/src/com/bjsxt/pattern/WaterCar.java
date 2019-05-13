package com.bjsxt.pattern;

public class WaterCar extends SuperCar {

	public WaterCar(ICar car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		this.water();
	}
	public void water(){
		System.out.println("汽车可以潜水");
	}
}
