package com.bjsxt.file;

import java.io.File;

public class TestDirectory {
	public static void main(String[] args) {
		//����File��Ķ���
		File f=new File("D:"+File.separator+"test");
		f.mkdir();  //���ڴ���Ŀ¼ ������Ŀ¼
		System.out.println("Ŀ¼�Ƿ����"+f.exists());
		System.out.println("��Ŀ¼�����ļ�:"+f.isDirectory());
		System.out.println("��Ŀ¼�����ļ�:"+f.isFile());
		
		File f2=new File("D:\\aa\\bb\\cc");
		f2.mkdirs(); //���ڴ���Ŀ¼�����Ŀ¼
		f.delete();
		File parent=f2.getParentFile(); //��ȡccĿ¼�ĸ���Ŀ¼
		System.out.println(parent);
		parent.delete(); //deleteɾ��Ŀ¼ʱ��ֻ����ɾ����Ŀ¼
		f2.delete();//ɾ��cc
		parent.delete();//ɾ��bb
		
		File f3=new File("D:\\");
		String [] strFile=f3.list();
		System.out.println(strFile.length); //������Ԫ�صĸ���
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
