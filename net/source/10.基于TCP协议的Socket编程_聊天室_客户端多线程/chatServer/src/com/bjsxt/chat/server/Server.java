package com.bjsxt.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("----------------服务器端已开启---------------------");
		// (1)创建ServerSocket对象
		ServerSocket server = new ServerSocket(9999);
		// (2)监听客户端是否有客户端连接
		Socket socket = server.accept();

		// (3)获取输入流接收数据
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true){
			String str = dis.readUTF();
			System.out.println("客户端发送的数据为:-->" + str);
	
			// (4)获取输出流响应客户端的请求
			dos.writeUTF("服务器端收到了:" + str);
		}

		// (5)关闭流
		//CloseUtil.closeAll(dos, dis, socket);
	}
}
