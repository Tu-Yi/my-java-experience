package com.bjsxt.throwsoo;

public class TestThrows {
	
	public static void show()throws Exception{
		
	}
	public static void method()throws RuntimeException{
		
	}
	public static void main(String[] args){//throws Exception {
		//调用本类中的静态方法show()
		try {
			show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		method();
	}
}
