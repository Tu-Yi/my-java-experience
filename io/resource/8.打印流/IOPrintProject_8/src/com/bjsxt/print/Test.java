package com.bjsxt.print;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws IOException {
		
		//PrintStream ps=System.out;//��ʾ��
		//PrintStream ps=System.err;
		//PrintStream ps=new PrintStream(new FileOutputStream("D:\\print.txt"));
		PrintWriter ps=new PrintWriter(new FileOutputStream("D:\\print1.txt"));
		 //��������ת�����Զ�ת��String����
		ps.println("helloworld");
		ps.println(true);
		ps.println(19);
		ps.println(98.5);
		ps.println(new Date(1000));
		ps.flush();
		ps.close();
		//ֻ��д���ַ�������
		BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\a.txt"));
		bw.write("helloworld");
		//bw.write(98.5);
		//bw.write(new Date());
		
	}
}
