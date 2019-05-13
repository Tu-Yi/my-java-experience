package com.bjsxt.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	
	public static void main(String[] args) throws IOException {
		System.out.println("----------------服务器端已开启---------------------");
		//(1)创建ServerSocket对象
		ServerSocket server=new ServerSocket(9999);
		
		//(2)监听客户端是否有客户端连接
		Socket socket=server.accept();
		
		//获取输入流
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		//获取输出流
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		
		String str=dis.readUTF();
		System.out.println("客户端发送了:"+str);
		
		dos.writeUTF("服务器端收到了:"+str);
		
		//(5)关闭流
		CloseUtil.closeAll(dos,dis,socket);
	}
}
