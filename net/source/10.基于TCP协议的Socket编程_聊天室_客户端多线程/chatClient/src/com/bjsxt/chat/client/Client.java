package com.bjsxt.chat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		//(1)����Socket����
		Socket client=new Socket("localhost",9999);
		
		//�������͵��߳������
		Send send=new Send(client);
		//�������յ��߳������
		Receive receive=new Receive(client);
		//����Thread����������߳�
		new Thread(send).start();
		new Thread(receive).start();
	
	}
}
