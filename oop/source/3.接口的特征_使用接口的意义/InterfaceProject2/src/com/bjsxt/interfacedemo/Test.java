package com.bjsxt.interfacedemo;

public class Test {
	public static void main(String[] args) {
		//�ӿ����ͣ������������ͣ�ָ��ʵ����Ķ���
		Fly airPlane=new AirPlane();
		Fly bird =new Bird();
		Fly football=new FootBall();
		//������ͬ�ķ���
		airPlane.flying();
		bird.flying();
		football.flying();
		//���н��������ͬ
		
	}
}
