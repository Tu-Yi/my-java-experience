package com.bjsxt.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestClasses {
	public static void write(){
		//�����༶����
				ArrayList<Student> al=new ArrayList<Student>();
				al.add(new Student("marry",20,"888888"));
				al.add(new Student("lili",22,"123456"));
				al.add(new Student("jack",30,"654321"));
				
				Classes cl=new Classes("jn1001", al);
				
				//�������������
				ObjectOutputStream oos=null;
				try {
					oos=new ObjectOutputStream(new FileOutputStream("E:\\classes.txt"));
					oos.writeObject(cl);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//�ر���
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
	public static void read(){
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream("E:\\classes.txt"));
			Classes cl=(Classes) ois.readObject();
			System.out.println(cl.getClassName()+"\t"+cl.getAl());
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
			//�ر���
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
	public static void main(String[] args) {
		//write();
		read();
	}
}
