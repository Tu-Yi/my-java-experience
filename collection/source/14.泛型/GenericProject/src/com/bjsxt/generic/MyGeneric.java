package com.bjsxt.generic;

public class MyGeneric<T> {//T����һ��Ӣ����ĸ������һ����������

}
class TestMyGeneric{
	public static void main(String[] args) {
		MyGeneric<String> my1=new MyGeneric<String>();
		MyGeneric<Integer> my2=new MyGeneric<Integer>();
	}
}