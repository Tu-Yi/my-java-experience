package com.bjsxt.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("----------------���������ѿ���---------------------");
		// (1)����ServerSocket����
		ServerSocket server = new ServerSocket(9999);
		// (2)�����ͻ����Ƿ��пͻ�������
		Socket socket = server.accept();

		// (3)��ȡ��������������
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while(true){
			String str = dis.readUTF();
			System.out.println("�ͻ��˷��͵�����Ϊ:-->" + str);
	
			// (4)��ȡ�������Ӧ�ͻ��˵�����
			dos.writeUTF("���������յ���:" + str);
		}

		// (5)�ر���
		//CloseUtil.closeAll(dos, dis, socket);
	}
}
