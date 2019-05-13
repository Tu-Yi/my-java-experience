package com.bjsxt.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) throws IOException {
		System.out.println("-------------服务器端已启动----------------");
		//(1)创建ServerSocket对象
		ServerSocket server=new ServerSocket(9999);
		//(2)监听是否有客户端来请求连接
		Socket client=server.accept();
		//(3) 获取输入流
		DataInputStream dis=new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		
		//(4)获取输出流
		//"收到了"
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("收到了");
		//(5)关闭流，关闭Socket
		if(dos!=null){
			dos.close();
		}
		if(dis!=null){
			dis.close();
		}
		if(client!=null){
			client.close();
		}
	}
}
