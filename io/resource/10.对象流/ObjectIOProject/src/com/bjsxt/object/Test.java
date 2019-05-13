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
		//(1)��������������
		ObjectInputStream ois=null;
		try {
			
			ois=new ObjectInputStream(new FileInputStream("E:\\object.txt"));
			//(2)������
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
			//(3)�ر���
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
	//д����ķ���
	public static void write(){
		//(1)��������������
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("E:\\object.txt"));
			//(2)д����
			oos.writeInt(98);
			oos.writeUTF("�й���");
			oos.writeObject(new Person("marry", 20));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//(3)�ر���
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
