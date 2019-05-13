package com.bjsxt.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {
	public static void main(String[] args) {
		/*File srcFile=new File("D:\\180416\\��һ��ҵ.docx");
		File targetFile=new File("E:\\��һ��ҵ.docx");
		//���ø����ļ��ķ���
		copyFile(srcFile, targetFile);*/
		File srcDir=new File("D:\\180416");
		File targetDir=new File("E:\\180416");
		//���ø���ָ��Ŀ¼�������ļ��ķ���
		copyDir(srcDir, targetDir);
	}
	public static void copyDir(File srcDir,File targetDir){
		if(!targetDir.exists()){
			targetDir.mkdir();//���Ŀ�ĵص�Ŀ¼�����ڣ�����Ҫʹ��File��ķ������д���Ŀ¼
		}
		File []files=srcDir.listFiles(); //��ȡָ��Ŀ¼�µ�����File����
		for (File file : files) {
			if (file.isFile()) {
				 //����  srcDir -->D:\\180416  ƴ��  D:\\180416\\XXXX.doc�ļ�
				//    targetDir-->E:\\180416 ƴ�� E:\\180416\\XXXX.doc�ļ�
				copyFile(new File(srcDir+"\\"+file.getName()), new File(targetDir+"\\"+file.getName()));
			}else{
				//�������ø÷�����ʹ�õݹ�ʵ��
				copyDir(new File(srcDir+"\\"+file.getName()), new File(targetDir+"\\"+file.getName()));
			}
		}
	}
	public static void copyFile(File srcFile,File targetFile){
		//(1)��߶�ȡЧ�ʣ�������Դ
		BufferedInputStream bis=null;
		//(2)���д��Ч�ʣ�д��Ŀ�ĵ�
		BufferedOutputStream bos=null;
		try {
			bis = new BufferedInputStream(new FileInputStream(srcFile));
			
			bos = new BufferedOutputStream(new FileOutputStream(targetFile));
			//(3)�߶���д
			byte [] buf=new byte[1024];//��תվ
			int len=0;//���ڴ洢�������ֽڵĸ���
			while((len=bis.read(buf))!=-1){
				bos.write(buf,0,len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//(4)�ر�
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	}
}
