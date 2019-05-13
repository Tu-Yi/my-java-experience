package com.bjsxt.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/*
 * 每一个客户端都是条道路
 * 1.输入流
 * 2.输出流
 * 3.接收数据
 *4.发送数据
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
	//接收数据的方法
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
	//发送数据的方法
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
	//转发的方法
	private void sendOther(){
		String str=this.receive();
		List<MyChannel> list=Server.list;
		for (MyChannel other : list) {
			if (other==this) {
				continue;//不发给自己
			}
			other.send(str);//发送数组
		}
	}
	@Override
	public void run() {
		while(flag){
			//调用发送数据的方法
			//this.send(receive());
			sendOther();
		}
	}
	

}
