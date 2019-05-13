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
		/**网络爬虫
		 * (1)从网络上获取资源 www.baidu.com
		 * (2)存储到本地
		 * */
		//(1)创建URL对象
		URL url=new URL("https://www.baidu.com");//主页资源
		//(2)获取字节输入流
		InputStream is=url.openStream();
		//(3)缓冲流
		BufferedReader br=new BufferedReader(new InputStreamReader(is, "utf-8"));
		//(4)存储到本地
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("index.html"),"utf-8"));
		//(5)边读边写
		String line=null;
		while((line=br.readLine())!=null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		//(6)关闭流
		bw.close();
		br.close();
	
		
	}
}
