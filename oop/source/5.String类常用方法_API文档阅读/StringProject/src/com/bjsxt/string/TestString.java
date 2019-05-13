package com.bjsxt.string;

public class TestString {
	public static void main(String[] args) {
		String str="abc";//声明了一个String类型的变量，其值为"abc";
		System.out.println(str);
		/**String类相当于char类型的数组，数组的长度一旦创建不能更改，value的数组还使用了final进行修饰*/
		/**String类的常用方法*/
		System.out.println(str.charAt(0)+"\t"+str.charAt(1)+"\t"+str.charAt(2));
		System.out.println(str.equalsIgnoreCase("ABc")); //忽略大小写的比较
		System.out.println(str.indexOf("b")+"\t"+str.indexOf("k"));//找到返回索引，找不到返回-1
		System.out.println(str.indexOf(98)+"\t"+str.indexOf('b')); //str.indexOf('b')叫自动类型转换，自动将char-->int
		String str2="helloworld";
		System.out.println(str2.indexOf("o")+"\t"+str2.lastIndexOf("o"));  //lastIndexOf反向搜索
		System.out.println(str2.indexOf("o",5)+"\t"+str2.lastIndexOf("o",3)+"\t"+str2.lastIndexOf("o",7));
		System.out.println("字符串字符的个数"+str2.length());
		System.out.println(str2.replace('o', 'P'));
		System.out.println(str2);
		System.out.println(str2.startsWith("hell"));//以XXX开头
		System.out.println("Io.java".endsWith(".java"));//以XXX结尾
		System.out.println(str2.substring(3));//一直截取到字符串的结尾
		System.out.println(str2.substring(3, 7));//含头不含尾
		System.out.println(str2);
		System.out.println("JAVA".toLowerCase()+"\t"+"java".toUpperCase());
		
		String str3="   hello   world   ";
		System.out.println(str3.length()+"\t"+str3.trim().length());
		System.out.println(str3);
		str3=str3.trim();
		System.out.println(str3);
		
	}
}
