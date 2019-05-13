package com.bjsxt.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println("-------------服务器端已启动----------------");
		//(1)创建ServerSocket对象
		ServerSocket server=new ServerSocket(9999);
		//(2)监听是否有客户端来请求连接
		Socket client=server.accept();
		//(3) 获取输入流
		InputStream is=client.getInputStream();
		System.out.println((char)is.read());
		//(4)获取输出流
		//"收到了"
		OutputStream os=client.getOutputStream();
		os.write("收到了!".getBytes());
		//(5)关闭流，关闭Socket
		if(os!=null){
			os.close();
		}
		if(is!=null){
			is.close();
		}
		if(client!=null){
			client.close();
		}
	}
}
