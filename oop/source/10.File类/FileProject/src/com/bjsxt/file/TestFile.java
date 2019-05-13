package com.bjsxt.file;

import java.io.File;
import java.io.IOException;

public class TestFile {
	//使用File类操作文件
	public static void main(String[] args) throws IOException {
		//创建File类的对象
		File f1=new File("D:\\a.txt");  //绝对路径
		File f2=new File ("D:/a.txt");
		File f3=new File("a.txt");//相对路径
		File f5=new File("D:\\test"); //目录
		File f4=new File(f5,"a.txt");
		File f6=new File("D:"+File.separator+"a.txt");
		/**File操作文件的相关方法*/
		System.out.println(f3.createNewFile());
		System.out.println(f1.delete()); //直接从磁盘上删除
		System.out.println(f1.exists()); //不存在false,
		System.out.println("绝对路径"+f3.getAbsolutePath());
		System.out.println("相对路径:"+f3.getPath());
		System.out.println("获取文件名:"+f3.getName());
		System.out.println(f3.toString());  //相对路径
		System.out.println("是否是文件"+f3.isFile());
		System.out.println("是否是文件:"+f5.isFile());
		System.out.println("文件中内容的字节数:"+f3.length());
	}
}
