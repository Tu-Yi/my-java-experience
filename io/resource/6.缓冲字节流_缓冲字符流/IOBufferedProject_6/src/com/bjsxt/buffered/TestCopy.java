package com.bjsxt.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {
	public static void main(String[] args) throws IOException {
		//��1������Դ
		FileInputStream fis=new FileInputStream("D:\\jdk api 1.8_google.CHM");
		//(2)Ŀ�ĵ�
		FileOutputStream fos=new FileOutputStream("D:\\jdk api 1.8_google2.CHM");
		/**
		 * ʹ�û�����
		 * */
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//(3)�����ݺ�д����
		long start=System.currentTimeMillis();
		byte [] buf=new byte[1024];//��תվ
		int len=0;
		while((len=bis.read(buf))!=-1){
			bos.write(buf,0,len);
			bos.flush();//�ֶ�ˢ�»�����
		}
		long end=System.currentTimeMillis();
		System.out.println("�ļ�����һ��ʹ����:"+(end-start)+"����");
		//(4)�ر�
		bos.close();
		bis.close();
	}
}
