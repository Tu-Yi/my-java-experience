package com.bjsxt.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Test {
	public static void main(String[] args) {
		//�������󣬴Ӽ��̻�ȡ���ݣ�д������ļ�
		//(1)����Դ�Ǳ�׼�������豸������ System.in
		//(3)��߶�ȡЧ�ʣ�
		BufferedReader br=null;
		//(4)���д��Ч��
		BufferedWriter bw=null;
		try {
			InputStream is=System.in;
			//(2)��Ҫʹ��ת������ת�����ַ���
			InputStreamReader isr=new InputStreamReader(is,"gbk");
			br = new BufferedReader(isr);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\systein.txt"),"gbk"));
			//(5)д������ļ�
			String line=null;//���ڴ洢�����ַ���
			while(!"over".equals((line=br.readLine()))){
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//(6)�ر�
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		}
	}
}
