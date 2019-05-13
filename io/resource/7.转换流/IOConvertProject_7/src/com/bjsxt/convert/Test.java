package com.bjsxt.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Test {
	public static void main(String[] args) {
		//任务需求，从键盘获取数据，写入磁盘文件
		//(1)数据源是标准的输入设备，键盘 System.in
		//(3)提高读取效率，
		BufferedReader br=null;
		//(4)提高写入效率
		BufferedWriter bw=null;
		try {
			InputStream is=System.in;
			//(2)需要使用转换流，转换成字符流
			InputStreamReader isr=new InputStreamReader(is,"gbk");
			br = new BufferedReader(isr);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\systein.txt"),"gbk"));
			//(5)写入磁盘文件
			String line=null;//用于存储读到字符串
			while(!"over".equals((line=br.readLine()))){
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//(6)关闭
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		}
	}
}
