package com.bjsxt.interfacepro;

public interface MyInterface {
	  String name="张三";
	  public static final String name2="张三";
	 void show();
	 String fun();
	 int [] method();
	 /**JDK1.8新特性 ,必须使用default关键字*/
	 public default void method2(){
		 
	 }
	 //接口中不允许定义构造方法
	/* public MyInterface(){
		 
	 }*/
}
