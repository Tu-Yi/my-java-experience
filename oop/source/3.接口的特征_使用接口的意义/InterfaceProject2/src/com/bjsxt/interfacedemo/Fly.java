package com.bjsxt.interfacedemo;

public interface Fly {
	public void flying();//飞行的能力
}
class AirPlane implements Fly{

	@Override
	public void flying() {
		System.out.println("飞机在祖国的蓝天上自由飞翔...........");
	}
	
}
class Bird implements Fly{
	@Override
	public void flying() {
		System.out.println("小鸟唱着动听的歌，在天空中飞................");
	}
}
class FootBall implements Fly{
	@Override
	public void flying() {
		System.out.println("球被踢了一脚，划了个美丽的弧线飞到了对方的球门里..........");
	}
}