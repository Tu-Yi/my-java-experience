package com.bjsxt.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	//�������϶��󣬴洢ÿһ�����ӽ����Ŀͻ���
	public static List<MyChannel> list=new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException {
		System.out.println("----------------���������ѿ���---------------------");
		// (1)����ServerSocket����
		ServerSocket server = new ServerSocket(9999);
		// (2)�����ͻ����Ƿ��пͻ�������
		while(true){
			Socket socket = server.accept();
			//�����߳���Ķ���
			MyChannel channel=new MyChannel(socket);
			//��ӵ�������
			list.add(channel);
			
			//�����߳�
			new Thread(channel).start();;
		}
		


		// (5)�ر���
		//CloseUtil.closeAll(dos, dis, socket);
	}
}
