package com.bjsxt.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class TestURL2 {
	public static void main(String[] args) throws IOException {
		/**��������
		 * (1)�������ϻ�ȡ��Դ www.baidu.com
		 * (2)�洢������
		 * */
		//(1)����URL����
		URL url=new URL("https://www.baidu.com");//��ҳ��Դ
		//(2)��ȡ�ֽ�������
		InputStream is=url.openStream();
		//(3)������
		BufferedReader br=new BufferedReader(new InputStreamReader(is, "utf-8"));
		//(4)�洢������
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("index.html"),"utf-8"));
		//(5)�߶���д
		String line=null;
		while((line=br.readLine())!=null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//(6)�ر���
		bw.close();
		br.close();
	
		
	}
}
