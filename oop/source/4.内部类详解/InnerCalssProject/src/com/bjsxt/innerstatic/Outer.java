package com.bjsxt.innerstatic;

public class Outer {
	private static String name="张三";
	 /**静态内部类 ,(1)不允许访问外部类的非static属性 
	  * (2)如果内部类中的方法为static方法，那么内部类也必须为静态的*/
	static class Inner{ 
		public void show(){
			System.out.println(name);
		}
	}
	static class Inner2{
		public static void show(){
			
		}
	}
}
