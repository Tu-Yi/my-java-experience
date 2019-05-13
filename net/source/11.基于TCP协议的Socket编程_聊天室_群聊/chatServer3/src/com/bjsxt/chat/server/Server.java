package com.bjsxt.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	//创建集合对象，存储每一个连接进来的客户端
	public static List<MyChannel> list=new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException {
		System.out.println("----------------服务器端已开启---------------------");
		// (1)创建ServerSocket对象
		ServerSocket server = new ServerSocket(9999);
		// (2)监听客户端是否有客户端连接
		while(true){
			Socket socket = server.accept();
			//创建线程类的对象
			MyChannel channel=new MyChannel(socket);
			//添加到集合中
			list.add(channel);
			
			//启动线程
			new Thread(channel).start();;
		}
		


		// (5)关闭流
		//CloseUtil.closeAll(dos, dis, socket);
	}
}
