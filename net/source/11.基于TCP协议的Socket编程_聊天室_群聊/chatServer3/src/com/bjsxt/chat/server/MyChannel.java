package com.bjsxt.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/*
 * ÿһ���ͻ��˶�������·
 * 1.������
 * 2.�����
 * 3.��������
 *4.��������
 */
public class MyChannel implements Runnable{
	private DataInputStream dis;
	private DataOutputStream dos;
	private boolean flag=true;
	public MyChannel(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
			dos=new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			flag=false;
			CloseUtil.closeAll(dis,dos);
		}
	}
	//�������ݵķ���
	private String receive(){
		String str="";
		try {
			str=dis.readUTF();
		} catch (IOException e) {
			flag=false;
			CloseUtil.closeAll(dis,dos);
			Server.list.remove(this);
		}
		return str;
	}
	//�������ݵķ���
	private void send(String str){
		if (str!=null&&str.length()!=0) {
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e) {
				flag=false;
				CloseUtil.closeAll(dos,dis);
				Server.list.remove(this);
			}
			
		}
	}
	//ת���ķ���
	private void sendOther(){
		String str=this.receive();
		List<MyChannel> list=Server.list;
		for (MyChannel other : list) {
			if (other==this) {
				continue;//�������Լ�
			}
			other.send(str);//��������
		}
	}
	@Override
	public void run() {
		while(flag){
			//���÷������ݵķ���
			//this.send(receive());
			sendOther();
		}
	}
	

}
