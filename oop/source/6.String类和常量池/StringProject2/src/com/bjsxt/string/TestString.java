package com.bjsxt.string;

public class TestString {
	public static void main(String[] args) {
		String str="apple";
		String str2="banana";
		String str3="cat";
		String str4="dog";
		String str5="app";
		/**�������ַ����ĳ��ȵ���Сֵ��ʹ��ѭ�����Ƚ϶�Ӧλ���ϵ���ĸ���������ͬ�����Ӧλ����ĸ��ASCIIֵ���*/
		System.out.println(str.compareTo(str2));  //-1    97-98?
		System.out.println(str.compareTo(str3));//-2    97-99?
		System.out.println(str.compareTo(str4));//-3    97-100?
		//�����ַ����ĳ������  5-3=2
		System.out.println(str.compareTo(str5)); //2  
		
		/**String��Ĺ��췽��*/
		String s1=new String();//������һ������Ϊ0���ַ���
		String s2=null;//û�д�������ֻ��������String���͵Ķ���s2
		String s3=new String("hello");
		//ͨ��char���͵����鹹��String����
		char [] c={'a','b','c'};
		String s4=new String(c);
		
		byte [] b={97,98,99};
		String s5=new String(b);
		
		String s6=new String(c,0,2);
		System.out.println("s6:"+s6);
		
		String s7=new String(b,1,2);
		System.out.println("s7:"+s7);
		
		
		
	}
}
