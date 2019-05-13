package com.bjsxt.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		//write();
		read();
	}
	//�����ݵķ���
	public static void read() throws IOException{
		//(1)����Դ
		/*FileInputStream fis=new FileInputStream("E:\\data.txt");
		//(2)��߶�ȡЧ��
		BufferedInputStream bis=new BufferedInputStream(fis);
		//(3)����java�Ļ����������ͺ��ַ���
		DataInputStream dis=new DataInputStream(bis);*/
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream("E:\\data.txt")));
		//(4)������  --(�����ݵ�˳��Ҫ��д���ݵ�˳����ȫһ��)
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readUTF());
		//�ر�
		dis.close();
	
	}
	public static void write() throws IOException{
		//(1)Ŀ�ĵ�
		/*FileOutputStream fos=new FileOutputStream("E:\\data.txt");
		//(2)���������д��Ч��
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//(3)�����������Ӷ�java�����������ͺ�String�Ĵ���
		DataOutputStream dos=new DataOutputStream(bos);*/
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\data.txt")));
		//��4��д������
		dos.writeInt(98);
		dos.writeDouble(98.5);
		dos.writeBoolean(true);
		dos.writeChar('a');
		dos.writeUTF("helloworld");
		//(5)�ر���
		if(dos!=null){
			dos.close();
		}
	}
}
