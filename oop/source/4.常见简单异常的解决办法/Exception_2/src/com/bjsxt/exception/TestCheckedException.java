package com.bjsxt.exception;

import java.io.File;
import java.io.IOException;

public class TestCheckedException {
	public static void main(String[] args) {
		//���ʱ�쳣��N��������ڱ����ڼ���봦����쳣��һ�ܳ�
		File f=new File("D:\\a.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��D�̴���һ������Ϊa.txt���ļ�
	}
}
