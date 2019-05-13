package com.bjsxt.generic;

public class MyGeneric<T> {//T就是一个英文字母，代表一种数据类型

}
class TestMyGeneric{
	public static void main(String[] args) {
		MyGeneric<String> my1=new MyGeneric<String>();
		MyGeneric<Integer> my2=new MyGeneric<Integer>();
	}
}