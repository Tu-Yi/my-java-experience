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
		//(1)����Socket����
		Socket client=new Socket("localhost",9999);
		//(2)�Ӽ��̻�ȡ����
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//(3)��ȡ�����
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		//(4)��ȡ������
		DataInputStream dis=new DataInputStream(client.getInputStream());
		
		//�Ӽ��̻�ȡ����
		String str=br.readLine();
		dos.writeUTF(str);//��������˷�������
		
		System.out.println(dis.readUTF());//���շ������˵�����
		
	   
	}
}
