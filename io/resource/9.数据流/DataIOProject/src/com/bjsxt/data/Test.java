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
	//读数据的方法
	public static void read() throws IOException{
		//(1)数据源
		/*FileInputStream fis=new FileInputStream("E:\\data.txt");
		//(2)提高读取效率
		BufferedInputStream bis=new BufferedInputStream(fis);
		//(3)处理java的基本数据类型和字符串
		DataInputStream dis=new DataInputStream(bis);*/
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream("E:\\data.txt")));
		//(4)读数据  --(读数据的顺序要与写数据的顺序完全一致)
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readUTF());
		//关闭
		dis.close();
	
	}
	public static void write() throws IOException{
		//(1)目的地
		/*FileOutputStream fos=new FileOutputStream("E:\\data.txt");
		//(2)缓冲流提高写入效率
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//(3)数据流，增加对java基本数据类型和String的处理
		DataOutputStream dos=new DataOutputStream(bos);*/
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\data.txt")));
		//（4）写入数据
		dos.writeInt(98);
		dos.writeDouble(98.5);
		dos.writeBoolean(true);
		dos.writeChar('a');
		dos.writeUTF("helloworld");
		//(5)关闭流
		if(dos!=null){
			dos.close();
		}
	}
}
