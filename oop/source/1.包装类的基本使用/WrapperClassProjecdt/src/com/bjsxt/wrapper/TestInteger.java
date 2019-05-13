package com.bjsxt.wrapper;

public class TestInteger {
	public static void main(String[] args) {
		
		Integer i1=new Integer(123);
		Integer i2=new Integer("123");
		System.out.println("i1==i2:"+(i1==i2)); //false
		System.out.println("i1.equals(i2):"+i1.equals(i2));//内容
		System.out.println(i2.toString());//说明Integer类重写了toString方法
		Integer i3=new Integer(128);
		System.out.println(i1.compareTo(i3));//-1
		System.out.println(i1.compareTo(i2));//0
		System.out.println(i3.compareTo(i2));//1
		
		//(1)Integer-->int     包装类对象.intValue()
		int i=i1.intValue();
		System.out.println(Integer.max(10, 20));
		//(2)int-->Integer
		Integer i4=Integer.valueOf(123);
		
		//(3)String -->int      包装类类名.parseInt(String s)
		int ii=Integer.parseInt("234");
		
		//(4)int-->String
	    String str=ii+"";
	    String s=String.valueOf(ii);
	    
		//(5)String-->Integer;
	    Integer i5=new Integer("345");
	    //(6)Integer-->String
	    String ss=i5.toString();
	    System.out.println(ss);
		
	}
}
