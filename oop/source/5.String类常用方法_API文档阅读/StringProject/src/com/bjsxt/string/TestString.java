package com.bjsxt.string;

public class TestString {
	public static void main(String[] args) {
		String str="abc";//������һ��String���͵ı�������ֵΪ"abc";
		System.out.println(str);
		/**String���൱��char���͵����飬����ĳ���һ���������ܸ��ģ�value�����黹ʹ����final��������*/
		/**String��ĳ��÷���*/
		System.out.println(str.charAt(0)+"\t"+str.charAt(1)+"\t"+str.charAt(2));
		System.out.println(str.equalsIgnoreCase("ABc")); //���Դ�Сд�ıȽ�
		System.out.println(str.indexOf("b")+"\t"+str.indexOf("k"));//�ҵ������������Ҳ�������-1
		System.out.println(str.indexOf(98)+"\t"+str.indexOf('b')); //str.indexOf('b')���Զ�����ת�����Զ���char-->int
		String str2="helloworld";
		System.out.println(str2.indexOf("o")+"\t"+str2.lastIndexOf("o"));  //lastIndexOf��������
		System.out.println(str2.indexOf("o",5)+"\t"+str2.lastIndexOf("o",3)+"\t"+str2.lastIndexOf("o",7));
		System.out.println("�ַ����ַ��ĸ���"+str2.length());
		System.out.println(str2.replace('o', 'P'));
		System.out.println(str2);
		System.out.println(str2.startsWith("hell"));//��XXX��ͷ
		System.out.println("Io.java".endsWith(".java"));//��XXX��β
		System.out.println(str2.substring(3));//һֱ��ȡ���ַ����Ľ�β
		System.out.println(str2.substring(3, 7));//��ͷ����β
		System.out.println(str2);
		System.out.println("JAVA".toLowerCase()+"\t"+"java".toUpperCase());
		
		String str3="   hello   world   ";
		System.out.println(str3.length()+"\t"+str3.trim().length());
		System.out.println(str3);
		str3=str3.trim();
		System.out.println(str3);
		
	}
}
