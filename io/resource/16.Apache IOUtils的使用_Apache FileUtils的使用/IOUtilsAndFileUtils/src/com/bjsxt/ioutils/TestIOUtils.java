package com.bjsxt.ioutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class TestIOUtils {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//������
		String str=IOUtils.toString(new FileInputStream("D:\\a.txt"));
		System.out.println(str);
		//д����
		IOUtils.write(str, new FileOutputStream("D:\\aa.txt"));
		
		//�����ļ��е�����
		IOUtils.copy(new FileInputStream("d:\\a.txt"), new FileOutputStream("D:\\copya.txt"));
		
		
	}
}
