package com.bjsxt.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {
		//(1)����
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream("D:\\a.txt",true);//true������������ļ��������ļ��������ݣ�����ԭ�������ݵĻ����Ͻ���׷��
			//(2)д���ݣ�һ��дһ���ֽ�
			//fos.write(97);
			//(2)һ��д����ֽ�
			byte [] buf="helloworld".getBytes();
			fos.write(buf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//(3)�ر�
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
