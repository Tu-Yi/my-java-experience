package com.bjsxt.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println("-------------��������������----------------");
		//(1)����ServerSocket����
		ServerSocket server=new ServerSocket(9999);
		//(2)�����Ƿ��пͻ�������������
		Socket client=server.accept();
		//(3) ��ȡ������
		InputStream is=client.getInputStream();
		System.out.println((char)is.read());
		//(4)��ȡ�����
		//"�յ���"
		OutputStream os=client.getOutputStream();
		os.write("�յ���!".getBytes());
		//(5)�ر������ر�Socket
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
