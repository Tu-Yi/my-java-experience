package com.bjsxt.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		//write();
		read();
	}
	public static void read(){
		//(1)创建对象流对象
		ObjectInputStream ois=null;
		try {
			
			ois=new ObjectInputStream(new FileInputStream("E:\\object.txt"));
			//(2)读对象
			System.out.println(ois.readInt());
			System.out.println(ois.readUTF());
			Person p=(Person) ois.readObject();
			System.out.println(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//(3)关闭流
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
	//写对象的方法
	public static void write(){
		//(1)创建对象流对象
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("E:\\object.txt"));
			//(2)写对象
			oos.writeInt(98);
			oos.writeUTF("中国梦");
			oos.writeObject(new Person("marry", 20));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//(3)关闭流
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}
}
