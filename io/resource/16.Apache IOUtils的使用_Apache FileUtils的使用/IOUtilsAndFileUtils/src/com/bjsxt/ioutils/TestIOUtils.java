package com.bjsxt.ioutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class TestIOUtils {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//读数据
		String str=IOUtils.toString(new FileInputStream("D:\\a.txt"));
		System.out.println(str);
		//写数据
		IOUtils.write(str, new FileOutputStream("D:\\aa.txt"));
		
		//复制文件中的内容
		IOUtils.copy(new FileInputStream("d:\\a.txt"), new FileOutputStream("D:\\copya.txt"));
		
		
	}
}
