package com.bjsxt.testfile;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		File f=new File("E:\\013��ʾ");
		printFile(f, 0);
	}
	public static void printFile(File file,int level){
		//��ӡ��״�ṹ�Ĳ�ι�ϵ
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		//���Ŀ¼���ļ�������
		System.out.println(file.getName());
		if(file.isDirectory()){ //�ж�File�����Ƿ���Ŀ¼
			File [] listFiles=file.listFiles();
			for(File temp:listFiles){
				//�Լ������Լ�
				printFile(temp,level+1);
			}
			
		}
	}
}
