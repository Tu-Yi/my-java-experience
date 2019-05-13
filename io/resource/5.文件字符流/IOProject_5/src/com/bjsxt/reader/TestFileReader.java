package com.bjsxt.reader;

import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
	public static void main(String[] args) throws IOException {
		//(1)搭桥
		FileReader reader=new FileReader("D:\\test.txt");
		//(2)读取 
		//int b=reader.read(); //读到的字符的int类型 数据
		//System.out.println((char)b);
		/*int b=0;//用于存储每次读到的字符数据的整数值
		while((b=reader.read())!=-1){
			System.out.println((char)b);
		}*/
		char [] cbuf=new char[1024];
		int len=0;//用于存储读到的字符的个数
		while((len=reader.read(cbuf))!=-1){
			System.out.println(new String(cbuf,0,len));
		}
		//(3)关闭
		reader.close();
		
	}
}
