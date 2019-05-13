package com.bjsxt.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopy {
	public static void main(String[] args) {
		//数据源是文件
		FileInputStream fis=null;
		//目的地
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream("D:\\test.txt");
			fos = new FileOutputStream("E:\\target1.txt");
			
			byte []buf=new byte[1024];  //中转站
			int len=0;//用于存储每次读到的字节个数
			while((len=fis.read(buf))!=-1){
				fos.write(buf, 0, len);
			}
			
			/*int b=0;//用于存储读到的字节,(中转站)
			while((b=fis.read())!=-1){
				//写入文件
				fos.write(b);
			}*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭
			try {
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
