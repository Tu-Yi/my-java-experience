package com.bjsxt.interfacedemo;

public interface Fly {
	public void flying();//���е�����
}
class AirPlane implements Fly{

	@Override
	public void flying() {
		System.out.println("�ɻ�����������������ɷ���...........");
	}
	
}
class Bird implements Fly{
	@Override
	public void flying() {
		System.out.println("С���Ŷ����ĸ裬������з�................");
	}
}
class FootBall implements Fly{
	@Override
	public void flying() {
		System.out.println("������һ�ţ����˸������Ļ��߷ɵ��˶Է���������..........");
	}
}