package com.bjsxt.generic;

public class TestMyMethod {
	public static void main(String[] args) {
		MyMethod<String> my=new MyMethod<String>();
		my.show("hello");//在创建类的对象时明确了数据类型为String
		
		//在了泛型方法，解决了参数个数相同的情况下的方法重载
		my.method("hello");
		my.method(123);
		my.method('a');
		
		//可变参数的泛型方法，解决参数的个数不同，类型不同的方法重载
		my.fun("hello");
		my.fun("hello","world","java");
		my.fun(123,456);
	}
}	
