package com.bjsxt.generic;

public interface MyInterface<T> {

}
class MyImplement implements MyInterface<String>{
	
}
class MyImplement1<T> implements MyInterface<T>{
	
}
class TestMyInterface{
	public static void main(String[] args) {
		MyImplement my=new MyImplement();
		
		MyImplement1<Integer> my2=new MyImplement1<Integer>();
	}
}