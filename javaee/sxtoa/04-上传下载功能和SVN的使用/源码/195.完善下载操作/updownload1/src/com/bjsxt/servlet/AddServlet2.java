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
 * System.out.println(item.isFormField()); //�Ƿ���file����   ��file false  ����file  true
	System.out.println(item.getFieldName());//�����name���Ե�ֵ
	System.out.println(item.getString());//���ڷ�file���value���Ե�ֵ������file������ļ�����
	System.out.println(item.getName());//����file����ϴ��ļ������ƣ����ڷ�file�������null
	System.out.println(item.getContentType());//����file����ϴ��ļ�mime���� �����ڷ�file�������null
	System.out.println(item.getSize());//����file����ϴ��ļ��Ĵ�С �����ڷ�file���valueֵ�Ŀ��
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
		//1.����FileItemFactory����
		FileItemFactory factory = new DiskFileItemFactory();
		
		//2.����ServletFileUpload����
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");//���file������ļ���������������
		//3.ͨ��ServletFileUpload����ʵ���ϴ����������ͻ���һ���������װ��һ����FileItem��
		List<FileItem>  itemList = null;
		try {
			itemList = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//4.��������FileItem���൱�ڶԸ���������д���
		System.out.println(itemList.size());
		for(int i=0;i<itemList.size();i++){
			//ȡ����i������
			FileItem item = itemList.get(i);
			//���item�����ݣ���ϤFileItem����Ҫ����
			System.out.println(item.isFormField()); //�Ƿ���file����   ��file false  ����file  true
			System.out.println(item.getFieldName());//�����name���Ե�ֵ
			//System.out.println(item.getString());//���ڷ�file���value���Ե�ֵ������file������ļ�����
			//System.out.println(item.getString("utf-8"));//�����file����������������� ����name
			System.out.println(item.getName());//����file����ϴ��ļ������ƣ����ڷ�file�������null
			System.out.println(item.getContentType());//����file����ϴ��ļ�mime���� �����ڷ�file�������null
			System.out.println(item.getSize());//����file����ϴ��ļ��Ĵ�С �����ڷ�file���valueֵ�Ŀ��
			System.out.println("================================");
			
		}
		
		int n = 1;
		// ҳ����ת
		if (n != 0) {
			// �ض���:/����Ҫ��������·�� /stumgr /stumgr2
			response.sendRedirect(request.getContextPath()
					+ "/servlet/ShowAllServlet");
		} else {
			request.setAttribute("mess", "���ʧ��!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
		}

	}

}
