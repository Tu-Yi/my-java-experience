package com.bjsxt.url;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("https://www.baidu.com/index.html#aa��username=bjsxt&pwd=bjsxt");
		System.out.println("Э������:"+url.getProtocol());
		System.out.println("��������:"+url.getHost());
		System.out.println("�˿ں�:"+url.getPort());
		System.out.println("��ȡ��Դ·��:"+url.getFile());
		System.out.println("��ȡ��Դ·��:"+url.getPath());
		System.out.println("��ȡĬ�϶˿�:"+url.getDefaultPort());
	}
}
