package com.bjsxt.string;

public class TestString {
	public static void main(String[] args) {
		String str="abc";
		String str2=new String("abc");   
		System.out.println("两个对象的内存地址是否相等:"+(str==str2));//false
		/**比较对应位置上的字符是否相等，如果所有的对象位置上的字符均相等，true，否则返回false*/
		System.out.println("两个对象的内容是否相等:"+(str.equals(str2)));
		//以下结果为 false
		/**因为Person对象 instanceof String  的结果为false ,直接返回false*/
		System.out.println("String对象与Person对象的内容是否相等:"+(str.equals(new Person())));
	}
}
class Person{
	
}
