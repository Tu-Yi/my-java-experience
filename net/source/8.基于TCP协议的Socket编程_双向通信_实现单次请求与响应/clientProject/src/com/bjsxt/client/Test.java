package com.bjsxt.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test {
	public static void main(String[] args) throws IOException {
		//(1)����Socket����
		Socket client=new Socket("127.0.0.1", 9999);
		//(2)��ȡ�����
		OutputStream os=client.getOutputStream();
		os.write('a');
		
		//(3)��ȡ������
		InputStream is=client.getInputStream();
		byte [] buf=new byte[1024];//��תվ
		int len=0;//�������ֽڵĸ���
		while((len=is.read(buf))!=-1){
			System.out.println(new String(buf,0,len));
		}
		//(4)�ر���
		if(is!=null){
			is.close();
		}
		if(os!=null){
			os.close();
		}
		if(client!=null){
			client.close();
		}
	}
}
