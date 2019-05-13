package com.bjsxt.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class TestInputStream2 {
	public static void main(String[] args) throws IOException {
		//(1)搭桥
		FileInputStream fis=new FileInputStream("D:\\test.txt");
		//(2)创建大一些的中转站
		byte [] buf=new byte[1024];
		int len=0;//用于存储每次读到的实际字节
		int i=0;
		while((len=fis.read(buf))!=-1){
			i++;
			//借助String类构造方法
			System.out.println(new String(buf,0,len));
		}
		//(3)关闭
		fis.close();
		System.out.println(i);
	}
}
