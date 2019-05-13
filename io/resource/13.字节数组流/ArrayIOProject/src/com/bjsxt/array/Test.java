package com.bjsxt.array;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		byte [] buf=write();//调用写对象的方法
		//调用读对象的方法
		read(buf);
	}
	public static byte[] write(){
		//创建字节数组流对象
		ByteArrayOutputStream baos=null;
		ObjectOutputStream oos=null;
		
		try {
			baos=new ByteArrayOutputStream();//创建字节数组流对象,目的地是字节数组,底层创建一个长度数为32的字节数组
			oos=new ObjectOutputStream(baos);
			oos.writeInt(98);
			oos.writeDouble(98.5);
			oos.writeChar('a');
			oos.writeBoolean(false);
			oos.writeObject(new Date(1000));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭流
			if (oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return baos.toByteArray();
	}
	public static void read(byte [] buf){
		ByteArrayInputStream bais=null;
		ObjectInputStream ois=null;
		//创建对象
		try {
			bais=new ByteArrayInputStream(buf); //数据源是byte类型的数组
			ois=new ObjectInputStream(bais);
			
			//读数据
			System.out.println(ois.readInt());
			System.out.println(ois.readDouble());
			System.out.println(ois.readChar());
			System.out.println(ois.readBoolean());
			System.out.println(ois.readObject());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			//关闭流
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
