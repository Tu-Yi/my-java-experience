package com.bjsxt.pattern;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) {
		ICar car=new Car();
		car.move();
		System.out.println("\nΪ���������µĹ���");
		FlyCar fly=new FlyCar(car);
		fly.move();
		
		System.out.println("\n��Ϊ���������Զ���ʻ�Ĺ���");
		AICar ai=new AICar(fly);
		ai.move();
		
		System.out.println("\n���ϴ�����Լ�дΪ");
		AICar ai2=new AICar(new FlyCar(new Car()));
		ai2.move();
		
		System.out.println("�������");
		WaterCar water=new WaterCar(new FlyCar(new AICar(new Car())));
		water.move();
		
		try {
			BufferedInputStream bis=new BufferedInputStream(new DataInputStream(new FileInputStream("D:\\a.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
