package com.bjsxt.string;

public class TestString {
	public static void main(String[] args) {
		String str="abc";
		String str2=new String("abc");   
		System.out.println("����������ڴ��ַ�Ƿ����:"+(str==str2));//false
		/**�Ƚ϶�Ӧλ���ϵ��ַ��Ƿ���ȣ�������еĶ���λ���ϵ��ַ�����ȣ�true�����򷵻�false*/
		System.out.println("��������������Ƿ����:"+(str.equals(str2)));
		//���½��Ϊ false
		/**��ΪPerson���� instanceof String  �Ľ��Ϊfalse ,ֱ�ӷ���false*/
		System.out.println("String������Person����������Ƿ����:"+(str.equals(new Person())));
	}
}
class Person{
	
}
