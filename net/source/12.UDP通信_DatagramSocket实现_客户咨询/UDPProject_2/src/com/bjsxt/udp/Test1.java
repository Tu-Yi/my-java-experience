package com.bjsxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test1 {
	//���շ�
			/** һ�գ�
			 * һ��
			 * @throws IOException 
			 */
	public static void main(String[] args) throws IOException {
		System.out.println("�ͷ���Ա");
		DatagramSocket ds=new DatagramSocket(9999);
		//׼ ����������
		byte [] buf=new byte[1024];
		//׼ �����ݱ�����
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		
		//����
		ds.receive(dp);
		
		//�鿴���յ�������
		String str=new String(dp.getData(),0,dp.getLength());
		System.out.println("�ͻ�˵:"+str);
		
		
		/**�ظ�����*/
		byte [] buf2="welcome to beijing".getBytes();
		DatagramPacket dp2=new DatagramPacket(buf2, buf2.length, dp.getAddress(), dp.getPort());
		ds.send(dp2);
		//�ر�
		ds.close();
		
			
	}
}
