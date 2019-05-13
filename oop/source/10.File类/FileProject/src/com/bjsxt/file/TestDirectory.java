package com.bjsxt.file;

import java.io.File;

public class TestDirectory {
	public static void main(String[] args) {
		//创建File类的对象
		File f=new File("D:"+File.separator+"test");
		f.mkdir();  //用于创建目录 ，单层目录
		System.out.println("目录是否存在"+f.exists());
		System.out.println("是目录还是文件:"+f.isDirectory());
		System.out.println("是目录还是文件:"+f.isFile());
		
		File f2=new File("D:\\aa\\bb\\cc");
		f2.mkdirs(); //用于创建目录，多层目录
		f.delete();
		File parent=f2.getParentFile(); //获取cc目录的父级目录
		System.out.println(parent);
		parent.delete(); //delete删除目录时，只允许删除空目录
		f2.delete();//删除cc
		parent.delete();//删除bb
		
		File f3=new File("D:\\");
		String [] strFile=f3.list();
		System.out.println(strFile.length); //数组中元素的个数
		for(String s:strFile){
			System.out.println(s);
		}
		System.out.println("\n--------------------------------\n");
		File [] flist=f3.listFiles();
		for(File file:flist){
			System.out.println(file);
		}
		
		
	}
}
