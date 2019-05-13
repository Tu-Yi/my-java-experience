package com.bjsxt.throwsoo;

public class TestThrow {
	
	public static void show(){
		
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		show();
	}
}
