package com.bjsxt.reader;

import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
	public static void main(String[] args) throws IOException {
		//(1)����
		FileReader reader=new FileReader("D:\\test.txt");
		//(2)��ȡ 
		//int b=reader.read(); //�������ַ���int���� ����
		//System.out.println((char)b);
		/*int b=0;//���ڴ洢ÿ�ζ������ַ����ݵ�����ֵ
		while((b=reader.read())!=-1){
			System.out.println((char)b);
		}*/
		char [] cbuf=new char[1024];
		int len=0;//���ڴ洢�������ַ��ĸ���
		while((len=reader.read(cbuf))!=-1){
			System.out.println(new String(cbuf,0,len));
		}
		//(3)�ر�
		reader.close();
		
	}
}
