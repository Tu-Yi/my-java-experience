package com.bjsxt.interfacepro;

public interface MyInterface {
	  String name="����";
	  public static final String name2="����";
	 void show();
	 String fun();
	 int [] method();
	 /**JDK1.8������ ,����ʹ��default�ؼ���*/
	 public default void method2(){
		 
	 }
	 //�ӿ��в������幹�췽��
	/* public MyInterface(){
		 
	 }*/
}
