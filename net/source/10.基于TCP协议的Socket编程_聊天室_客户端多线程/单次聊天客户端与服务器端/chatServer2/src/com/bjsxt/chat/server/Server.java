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
		System.out.println("----------------���������ѿ���---------------------");
		//(1)����ServerSocket����
		ServerSocket server=new ServerSocket(9999);
		
		//(2)�����ͻ����Ƿ��пͻ�������
		Socket socket=server.accept();
		
		//��ȡ������
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		//��ȡ�����
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		
		String str=dis.readUTF();
		System.out.println("�ͻ��˷�����:"+str);
		
		dos.writeUTF("���������յ���:"+str);
		
		//(5)�ر���
		CloseUtil.closeAll(dos,dis,socket);
	}
}
