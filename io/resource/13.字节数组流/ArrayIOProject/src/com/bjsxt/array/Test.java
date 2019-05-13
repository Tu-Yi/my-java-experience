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
		byte [] buf=write();//����д����ķ���
		//���ö�����ķ���
		read(buf);
	}
	public static byte[] write(){
		//�����ֽ�����������
		ByteArrayOutputStream baos=null;
		ObjectOutputStream oos=null;
		
		try {
			baos=new ByteArrayOutputStream();//�����ֽ�����������,Ŀ�ĵ����ֽ�����,�ײ㴴��һ��������Ϊ32���ֽ�����
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
			//�ر���
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
		//��������
		try {
			bais=new ByteArrayInputStream(buf); //����Դ��byte���͵�����
			ois=new ObjectInputStream(bais);
			
			//������
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
}
