package com.bjsxt.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class TestInputStream2 {
	public static void main(String[] args) throws IOException {
		//(1)����
		FileInputStream fis=new FileInputStream("D:\\test.txt");
		//(2)������һЩ����תվ
		byte [] buf=new byte[1024];
		int len=0;//���ڴ洢ÿ�ζ�����ʵ���ֽ�
		int i=0;
		while((len=fis.read(buf))!=-1){
			i++;
			//����String�๹�췽��
			System.out.println(new String(buf,0,len));
		}
		//(3)�ر�
		fis.close();
		System.out.println(i);
	}
}
