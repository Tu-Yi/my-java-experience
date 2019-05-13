package com.bjsxt.chat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) throws IOException {
		//(1)创建Socket对象
		Socket client=new Socket("localhost",9999);
		//(2)从键盘获取数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//(3)获取输出流
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		//(4)获取输入流
		DataInputStream dis=new DataInputStream(client.getInputStream());
		
		//从键盘获取数据
		String str=br.readLine();
		dos.writeUTF(str);//向服务器端发送数据
		
		System.out.println(dis.readUTF());//接收服务器端的数据
		
	   
	}
}
