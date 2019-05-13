package com.bjsxt.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopy {
	public static void main(String[] args) {
		//����Դ���ļ�
		FileInputStream fis=null;
		//Ŀ�ĵ�
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream("D:\\test.txt");
			fos = new FileOutputStream("E:\\target1.txt");
			
			byte []buf=new byte[1024];  //��תվ
			int len=0;//���ڴ洢ÿ�ζ������ֽڸ���
			while((len=fis.read(buf))!=-1){
				fos.write(buf, 0, len);
			}
			
			/*int b=0;//���ڴ洢�������ֽ�,(��תվ)
			while((b=fis.read())!=-1){
				//д���ļ�
				fos.write(b);
			}*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر�
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
