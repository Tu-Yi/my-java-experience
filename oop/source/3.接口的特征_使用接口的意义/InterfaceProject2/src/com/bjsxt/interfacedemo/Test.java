package com.bjsxt.interfacedemo;

public class Test {
	public static void main(String[] args) {
		//接口类型（引用数据类型）指向实现类的对象
		Fly airPlane=new AirPlane();
		Fly bird =new Bird();
		Fly football=new FootBall();
		//调用相同的方法
		airPlane.flying();
		bird.flying();
		football.flying();
		//运行结果，不相同
		
	}
}
