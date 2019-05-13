package com.bjsxt.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args) throws IOException {
		//(1)创建Socket对象
		Socket client=new Socket("127.0.0.1", 9999);
		//(2)获取输出流
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("helloworld");
		//(3)获取输入流
		DataInputStream dis=new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		//(4)关闭流
		if(dis!=null){
			dis.close();
		}
		if(dos!=null){
			dos.close();
		}
		if(client!=null){
			client.close();
		}
	}
}
