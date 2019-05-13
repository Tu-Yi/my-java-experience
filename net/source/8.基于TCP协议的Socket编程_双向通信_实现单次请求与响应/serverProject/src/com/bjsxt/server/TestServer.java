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
		System.out.println("-------------��������������----------------");
		//(1)����ServerSocket����
		ServerSocket server=new ServerSocket(9999);
		//(2)�����Ƿ��пͻ�������������
		Socket client=server.accept();
		//(3) ��ȡ������
		DataInputStream dis=new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		
		//(4)��ȡ�����
		//"�յ���"
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("�յ���");
		//(5)�ر������ر�Socket
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
