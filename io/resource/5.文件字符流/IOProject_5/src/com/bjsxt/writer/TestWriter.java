package com.bjsxt.writer;

import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
	public static void main(String[] args) {
		//创建对象
		FileWriter writer=null;
		try {
			writer = new FileWriter("D:\\b.txt");
			//写数据
			writer.write("你好吗?");//写到了缓冲区中，
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//关闭
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
