package com.bjsxt.writer;

import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
	public static void main(String[] args) {
		//��������
		FileWriter writer=null;
		try {
			writer = new FileWriter("D:\\b.txt");
			//д����
			writer.write("�����?");//д���˻������У�
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//�ر�
			try {
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
