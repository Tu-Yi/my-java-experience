package com.bjsxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Test2 {
	//���շ�
			/** һ�գ�
			 * һ��
			 * @throws IOException 
			 */
	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("�ͷ���Ա");
		DatagramSocket ds=new DatagramSocket(9999);
		while(true){
			//׼ ����������
			byte [] buf=new byte[1024];
			//׼ �����ݱ�����
			DatagramPacket dp=new DatagramPacket(buf, buf.length);
			
			//����
			ds.receive(dp);
			
			//�鿴���յ�������
			String str=new String(dp.getData(),0,dp.getLength());
			System.out.println("�ͻ�˵:"+str);
			
			String s=input.next();
			/**�ظ�����*/
			byte [] buf2=s.getBytes();
			DatagramPacket dp2=new DatagramPacket(buf2, buf2.length, dp.getAddress(), dp.getPort());
			ds.send(dp2);
			if("bye".equals(s)){
				break;
			}
		}
		//�ر�
			
		ds.close();
		
			
	}
}
