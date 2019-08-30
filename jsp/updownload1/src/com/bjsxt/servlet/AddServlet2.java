package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * System.out.println(item.isFormField()); //是否是file表单项   是file false  不是file  true
	System.out.println(item.getFieldName());//表单项的name属性的值
	System.out.println(item.getString());//对于非file表单项，value属性的值；对于file表单项，是文件内容
	System.out.println(item.getName());//对于file表单项，上传文件的名称；对于非file表单项，返回null
	System.out.println(item.getContentType());//对于file表单项，上传文件mime类型 ；对于非file表单项，返回null
	System.out.println(item.getSize());//对于file表单项，上传文件的大小 ；对于非file表单项，value值的宽度
 * 
 * 
 * @author Administrator
 *
 */
public class AddServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.创建FileItemFactory对象
		FileItemFactory factory = new DiskFileItemFactory();
		
		//2.创建ServletFileUpload对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");//解决file表单项的文件名中文乱码问题
		//3.通过ServletFileUpload对象实现上传操作，将客户端一个个表单项封装到一个个FileItem中
		List<FileItem>  itemList = null;
		try {
			itemList = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//4.遍历各个FileItem（相当于对各个表单项进行处理）
		System.out.println(itemList.size());
		for(int i=0;i<itemList.size();i++){
			//取出第i个表单项
			FileItem item = itemList.get(i);
			//输出item的内容，熟悉FileItem的主要方法
			System.out.println(item.isFormField()); //是否是file表单项   是file false  不是file  true
			System.out.println(item.getFieldName());//表单项的name属性的值
			//System.out.println(item.getString());//对于非file表单项，value属性的值；对于file表单项，是文件内容
			//System.out.println(item.getString("utf-8"));//解决非file表单项的中文乱码问题 比如name
			System.out.println(item.getName());//对于file表单项，上传文件的名称；对于非file表单项，返回null
			System.out.println(item.getContentType());//对于file表单项，上传文件mime类型 ；对于非file表单项，返回null
			System.out.println(item.getSize());//对于file表单项，上传文件的大小 ；对于非file表单项，value值的宽度
			System.out.println("================================");
			
		}
		
		int n = 1;
		// 页面跳转
		if (n != 0) {
			// 重定向:/后面要跟上下文路径 /stumgr /stumgr2
			response.sendRedirect(request.getContextPath()
					+ "/servlet/ShowAllServlet");
		} else {
			request.setAttribute("mess", "添加失败!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
		}

	}

}
