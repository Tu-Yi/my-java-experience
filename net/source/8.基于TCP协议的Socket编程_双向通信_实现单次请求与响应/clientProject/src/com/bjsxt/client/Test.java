package com.bjsxt.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test {
	public static void main(String[] args) throws IOException {
		//(1)创建Socket对象
		Socket client=new Socket("127.0.0.1", 9999);
		//(2)获取输出流
		OutputStream os=client.getOutputStream();
		os.write('a');
		
		//(3)获取输入流
		InputStream is=client.getInputStream();
		byte [] buf=new byte[1024];//中转站
		int len=0;//读到的字节的个数
		while((len=is.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		//(4)关闭流
		if(is!=null){
			is.close();
		}
		if(os!=null){
			os.close();
		}
		if(client!=null){
			client.close();
		}
	}
}
