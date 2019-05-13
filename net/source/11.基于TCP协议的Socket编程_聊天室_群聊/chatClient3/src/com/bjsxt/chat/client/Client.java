package com.bjsxt.chat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		//(1)创建Socket对象
		Socket client=new Socket("localhost",9999);
		
		//创建发送的线程类对象
		Send send=new Send(client);
		//创建接收的线程类对象
		Receive receive=new Receive(client);
		//创建Thread类对象并启动线程
		new Thread(send).start();
		new Thread(receive).start();
	
	}
}
