package com.bjsxt.chat.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
	//(2)�Ӽ��̻�ȡ����
	private BufferedReader  br;
			//�������ݵ�������
	private DataOutputStream  dos;
	private boolean flag=true;//Ĭ��Ϊtrue
	
	public Send(){
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client){
		this();//���ñ�����޲ι��췽��
		try {
			dos=new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			flag=false;
			CloseUtil.closeAll(dos,client);
		}
	}
	
	private String getMessage(){
		String str="";
		try {
			str = br.readLine();
		} catch (IOException e) {
			flag=false;
			CloseUtil.closeAll(br);
		}
		return str;
	}
	private void send(String str){
		try {
			dos.writeUTF(str);
			dos.flush();
		} catch (IOException e) {
			flag=false;
			CloseUtil.closeAll(dos);
		}
	}
	@Override
	public void run() {
		while(flag){
			//���÷�����Ϣ�ķ���
			this.send(getMessage());
		}
	}

}
