package com.bjsxt.generic;

public class MyMethod<T> {//泛型类
	public void show(T t){  //在创建MyMethod类的对象时决定
		System.out.println(t);
	}
	public <Q> void method(Q q){ //在调用method这个方法时明确
		System.out.println(q);
	}
	public <K>void fun(K...k){ //可变参数的泛型方法
		for (int i = 0; i < k.length; i++) {
			System.out.println(k[i]);
		}
	}
}
