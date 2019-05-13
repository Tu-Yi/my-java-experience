package com.bjsxt.exception;

import java.io.File;
import java.io.IOException;

public class TestCheckedException {
	public static void main(String[] args) {
		//检查时异常，N多个程序在编译期间必须处理的异常的一总称
		File f=new File("D:\\a.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//在D盘创建一个名称为a.txt的文件
	}
}
