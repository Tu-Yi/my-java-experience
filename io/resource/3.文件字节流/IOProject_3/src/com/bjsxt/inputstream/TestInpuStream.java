package com.bjsxt.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInpuStream {
	public static void main(String[] args) throws IOException {
		//(1)����Դ��Ӧ�ó���֮���ܵ� 
		FileInputStream fis=new FileInputStream(new File("D:\\test.txt"));
		//(2)������Դ��ʼ������ж�����
		int count=fis.available();
		System.out.println(count);
		//��תվ�Ƚ�С��һ�ζ�һ���ֽ�
		//System.out.println(fis.read()); //��ȡһ���ֽ�
		//System.out.println(fis.available());
		int buf=0;//�洢�������ֽ�
		int i=0;
		while((buf=fis.read())!=-1){
			i++;
			System.out.print((char)buf);
		}
		//(3)�ر�
		fis.close();
		System.out.println(i);
		
	}
}
