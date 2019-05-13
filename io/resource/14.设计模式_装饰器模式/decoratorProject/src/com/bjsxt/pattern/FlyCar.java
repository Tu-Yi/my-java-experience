package com.bjsxt.pattern;

public class FlyCar extends SuperCar {

	public FlyCar(ICar car) {
		super(car);
		
	}
	//重写move()方法
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();  //调用父类的行驶方法
		
		//调用飞行的方法
		this.fly();
	}
	public void fly(){
		System.out.println("汽车可以飞行，因为有翅膀");
	}
}
