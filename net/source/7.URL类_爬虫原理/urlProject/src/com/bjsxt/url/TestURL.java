package com.bjsxt.url;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("https://www.baidu.com/index.html#aa？username=bjsxt&pwd=bjsxt");
		System.out.println("协议名称:"+url.getProtocol());
		System.out.println("主机名称:"+url.getHost());
		System.out.println("端口号:"+url.getPort());
		System.out.println("获取资源路径:"+url.getFile());
		System.out.println("获取资源路径:"+url.getPath());
		System.out.println("获取默认端口:"+url.getDefaultPort());
	}
}
