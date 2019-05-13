package com.bjsxt.ioutils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class TestFileUtils {
	public static void main(String[] args) throws IOException {
		FileUtils.copyFile(new File("D:\\a.txt"), new File("D:\\copy2.txt"));
		//
		URL url=new URL("https://www.baidu.com");
		FileUtils.copyURLToFile(url, new File("D:\\baidu.html"));
	}
}
