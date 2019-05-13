package com.bjsxt.testfile;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		File f=new File("E:\\013演示");
		printFile(f, 0);
	}
	public static void printFile(File file,int level){
		//打印树状结构的层次关系
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		//输出目录或文件的名称
		System.out.println(file.getName());
		if(file.isDirectory()){ //判断File对象是否是目录
			File [] listFiles=file.listFiles();
			for(File temp:listFiles){
				//自己调用自己
				printFile(temp,level+1);
			}
			
		}
	}
}
