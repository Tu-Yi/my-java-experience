package com.bjsxt.file;

import java.io.File;
import java.io.IOException;

public class TestFile {
	//ʹ��File������ļ�
	public static void main(String[] args) throws IOException {
		//����File��Ķ���
		File f1=new File("D:\\a.txt");  //����·��
		File f2=new File ("D:/a.txt");
		File f3=new File("a.txt");//���·��
		File f5=new File("D:\\test"); //Ŀ¼
		File f4=new File(f5,"a.txt");
		File f6=new File("D:"+File.separator+"a.txt");
		/**File�����ļ�����ط���*/
		System.out.println(f3.createNewFile());
		System.out.println(f1.delete()); //ֱ�ӴӴ�����ɾ��
		System.out.println(f1.exists()); //������false,
		System.out.println("����·��"+f3.getAbsolutePath());
		System.out.println("���·��:"+f3.getPath());
		System.out.println("��ȡ�ļ���:"+f3.getName());
		System.out.println(f3.toString());  //���·��
		System.out.println("�Ƿ����ļ�"+f3.isFile());
		System.out.println("�Ƿ����ļ�:"+f5.isFile());
		System.out.println("�ļ������ݵ��ֽ���:"+f3.length());
	}
}
