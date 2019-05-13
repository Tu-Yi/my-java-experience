package com.bjsxt.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		//调用写对象的方法
		//write();
		//调用读对象的方法
		read();
	}
	public static void write(){
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream("E:\\student.txt"));
			Student stu=new Student("marry", 20, "888888");
			Student.schoolName="JN校区";
			oos.writeObject(stu);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭
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
			ois=new ObjectInputStream(new FileInputStream("E:\\student.txt"));
			Student stu=(Student) ois.readObject();
			System.out.println(stu);
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
