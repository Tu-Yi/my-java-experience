package com.bjsxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Test2 {
	//һ��˫��ͨ��
	/**һ��
	 * һ��
	 * @throws IOException */
	public static void main(String[] args) throws IOException {
		System.out.println("��ѯ��");
		Scanner input=new Scanner(System.in);
		//����DatagramSocket����
		DatagramSocket ds=new DatagramSocket(8888);//��Ӧ�ó���Ķ˿�
		while(true){
			//׼��Ҫ���͵�����
			String s=input.next();
			byte[] buf=s.getBytes();
			//�������ݱ�����
			                            //���͵����ݣ�  �����٣�������̨��������������ʹ�õĶ˿�
			DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 9999);
			
			//����
			ds.send(dp);
			
			/**��������*/
			byte [] buf2=new byte[1024];
			DatagramPacket dp2=new DatagramPacket(buf2, buf2.length);
			// ����String�Ĺ��췽���鿴
			ds.receive(dp2);
			String str=new String(dp2.getData(),0,dp2.getLength());
			System.out.println("�ͷ�˵:"+str);
			
			if("bye".equals(s)){
				break;
			}
		}
		ds.close();
	}
}
