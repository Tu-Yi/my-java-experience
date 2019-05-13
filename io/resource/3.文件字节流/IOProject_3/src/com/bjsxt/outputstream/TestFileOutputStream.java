package com.bjsxt.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {
		//(1)搭桥
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream("D:\\a.txt",true);//true如果磁盘上有文件，而且文件中有内容，将在原来的内容的基础上进行追加
			//(2)写数据，一次写一个字节
			//fos.write(97);
			//(2)一次写多个字节
			byte [] buf="helloworld".getBytes();
			fos.write(buf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//(3)关闭
			try {
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
