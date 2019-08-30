package com.bjsxt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;

public class DownServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取学生的编号
		int id = Integer.parseInt(request.getParameter("id"));
		
		//2.根据编号调用业务层查询到该学生的所有信息（包括realName，photoName，photoType）
		StudentService  stuService = new StudentServiceImpl();
		Student stu = stuService.findById(id);
		
		//3.通过IO流实现照片下载（从服务器端到客户端）
		//3.1创建一个输入流和输出流
		String realPath = this.getServletContext().getRealPath("/upload");
		//String fileName = "D:\\Java/apache-tomcat-7.0.79/webapps/updownload1\\upload\\"+stu.getPhotoName();
		String fileName = realPath+"/"+stu.getPhotoName();
		File file = new File(fileName);
		
		response.setContentLength((int)file.length());//文件长度
		response.setContentType(stu.getPhotoType());//MIME类型
		//response.setHeader("Content-disposition", "inline");//!!!! attachment
		
		String realName = stu.getRealName();//霓凰郡主.jpg
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		
		if(userAgent.indexOf("msie")>=0){
			realName = URLEncoder.encode(realName, "utf-8");
		}else{
			realName = new String(realName.getBytes("utf-8"),"iso-8859-1");//???
		}
		
		
		response.setHeader("Content-disposition", "attachment;filename="+realName);
		InputStream is = new FileInputStream(file);  //读服务器端一个文件
		OutputStream os = response.getOutputStream(); //写到客户端
		
		//3.2使用输入流和输出流完成复制操作（服务器端-----客户端）
		IOUtils.copy(is, os);
		//3.3关闭输入流是输出流
		is.close();
		os.close();
		
		
		//表单 method= get 表单提交的中文乱码解决
		
		//request.setCharacterEncoding("utf-8");//post
		//String name = request.getParameter("name");
//		byte [] bytes = name.getBytes("iso-8859-1");
//		name = new String(bytes,"utf-8");
		//name = new String(name.getBytes("iso-8859-1"),"utf-8");
		
	}

	

}
