package com.bjsxt.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {
	public static void main(String[] args) throws IOException {
		//（1）数据源
		FileInputStream fis=new FileInputStream("D:\\jdk api 1.8_google.CHM");
		//(2)目的地
		FileOutputStream fos=new FileOutputStream("D:\\jdk api 1.8_google2.CHM");
		/**
		 * 使用缓冲流
		 * */
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//(3)读数据和写数据
		long start=System.currentTimeMillis();
		byte [] buf=new byte[1024];//中转站
		int len=0;
		while((len=bis.read(buf))!=-1){
			bos.write(buf,0,len);
			bos.flush();//手动刷新缓冲区
		}
		long end=System.currentTimeMillis();
		System.out.println("文件复制一共使用了:"+(end-start)+"毫秒");
		//(4)关闭
		bos.close();
		bis.close();
	}
}
