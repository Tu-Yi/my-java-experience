package com.bjsxt.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInpuStream {
	public static void main(String[] args) throws IOException {
		//(1)数据源与应用程序之间搭建管道 
		FileInputStream fis=new FileInputStream(new File("D:\\test.txt"));
		//(2)从数据源开始向程序中读数据
		int count=fis.available();
		System.out.println(count);
		//中转站比较小，一次读一个字节
		//System.out.println(fis.read()); //读取一个字节
		//System.out.println(fis.available());
		int buf=0;//存储读到的字节
		int i=0;
		while((buf=fis.read())!=-1){
			i++;
			System.out.print((char)buf);
		}
		//(3)关闭
		fis.close();
		System.out.println(i);
		
	}
}
