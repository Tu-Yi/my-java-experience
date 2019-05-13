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
		/*File srcFile=new File("D:\\180416\\五一作业.docx");
		File targetFile=new File("E:\\五一作业.docx");
		//调用复制文件的方法
		copyFile(srcFile, targetFile);*/
		File srcDir=new File("D:\\180416");
		File targetDir=new File("E:\\180416");
		//调用复制指定目录下所有文件的方法
		copyDir(srcDir, targetDir);
	}
	public static void copyDir(File srcDir,File targetDir){
		if(!targetDir.exists()){
			targetDir.mkdir();//如果目的地的目录不存在，则需要使用File类的方法进行创建目录
		}
		File []files=srcDir.listFiles(); //获取指定目录下的所有File对象
		for (File file : files) {
			if (file.isFile()) {
				 //复制  srcDir -->D:\\180416  拼接  D:\\180416\\XXXX.doc文件
				//    targetDir-->E:\\180416 拼接 E:\\180416\\XXXX.doc文件
				copyFile(new File(srcDir+"\\"+file.getName()), new File(targetDir+"\\"+file.getName()));
			}else{
				//继续调用该方法，使用递归实现
				copyDir(new File(srcDir+"\\"+file.getName()), new File(targetDir+"\\"+file.getName()));
			}
		}
	}
	public static void copyFile(File srcFile,File targetFile){
		//(1)提高读取效率，从数据源
		BufferedInputStream bis=null;
		//(2)提高写入效率，写到目的地
		BufferedOutputStream bos=null;
		try {
			bis = new BufferedInputStream(new FileInputStream(srcFile));
			
			bos = new BufferedOutputStream(new FileOutputStream(targetFile));
			//(3)边读边写
			byte [] buf=new byte[1024];//中转站
			int len=0;//用于存储读到的字节的个数
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
		//(4)关闭
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
