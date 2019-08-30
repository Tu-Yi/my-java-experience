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
		//1.��ȡѧ���ı��
		int id = Integer.parseInt(request.getParameter("id"));
		
		//2.���ݱ�ŵ���ҵ����ѯ����ѧ����������Ϣ������realName��photoName��photoType��
		StudentService  stuService = new StudentServiceImpl();
		Student stu = stuService.findById(id);
		
		//3.ͨ��IO��ʵ����Ƭ���أ��ӷ������˵��ͻ��ˣ�
		//3.1����һ���������������
		String realPath = this.getServletContext().getRealPath("/upload");
		//String fileName = "D:\\Java/apache-tomcat-7.0.79/webapps/updownload1\\upload\\"+stu.getPhotoName();
		String fileName = realPath+"/"+stu.getPhotoName();
		File file = new File(fileName);
		
		response.setContentLength((int)file.length());//�ļ�����
		response.setContentType(stu.getPhotoType());//MIME����
		//response.setHeader("Content-disposition", "inline");//!!!! attachment
		
		String realName = stu.getRealName();//�޻˿���.jpg
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		
		if(userAgent.indexOf("msie")>=0){
			realName = URLEncoder.encode(realName, "utf-8");
		}else{
			realName = new String(realName.getBytes("utf-8"),"iso-8859-1");//???
		}
		
		
		response.setHeader("Content-disposition", "attachment;filename="+realName);
		InputStream is = new FileInputStream(file);  //����������һ���ļ�
		OutputStream os = response.getOutputStream(); //д���ͻ���
		
		//3.2ʹ�����������������ɸ��Ʋ�������������-----�ͻ��ˣ�
		IOUtils.copy(is, os);
		//3.3�ر��������������
		is.close();
		os.close();
		
		
		//�� method= get ���ύ������������
		
		//request.setCharacterEncoding("utf-8");//post
		//String name = request.getParameter("name");
//		byte [] bytes = name.getBytes("iso-8859-1");
//		name = new String(bytes,"utf-8");
		//name = new String(name.getBytes("iso-8859-1"),"utf-8");
		
	}

	

}
