package com.bjsxt.innerstatic;

public class Outer {
	private static String name="����";
	 /**��̬�ڲ��� ,(1)����������ⲿ��ķ�static���� 
	  * (2)����ڲ����еķ���Ϊstatic��������ô�ڲ���Ҳ����Ϊ��̬��*/
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
