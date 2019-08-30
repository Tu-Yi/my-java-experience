package com.bjsxt.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
/**
 *  System.out.println(item.isFormField()); //�Ƿ���file����   ��file false  ����file  true
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
public class AddServlet extends HttpServlet {

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
		//����5�������ϴ��ĵ����������ļ��Ĵ�С������ʹ�ø÷�ʽ
		upload.setFileSizeMax(16*1024);//�����ļ�������
		upload.setSizeMax(5*16*1024);//һ���ϴ��������ļ����ܴ�С������
		
		//3.ͨ��ServletFileUpload����ʵ���ϴ����������ͻ���һ���������װ��һ����FileItem��
		List<FileItem>  itemList = null;
		try {
			itemList = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			request.setAttribute("mess", "�ļ����ܳ���16kb....");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		//4.��������FileItem���൱�ڶԸ���������д���
		//System.out.println(itemList.size());
		String name = null;
		int age = 0;
		double score = 0;
		String realName =null;
		String photoName = null;
		String photoType = null;
		for(int i=0;i<itemList.size();i++){
			//ȡ����i������
			FileItem item = itemList.get(i);
			String fieldName = item.getFieldName();
			//�Ը���������д�����ͨ������ļ�����Ҫ�ֿ�����
			if(item.isFormField()){//��ͨ����
				
				//name
				if("name".equals(fieldName)){
					name = item.getString("utf-8");
				}
				//age
				if("age".equals(fieldName)){
					age = Integer.parseInt(item.getString());
				}
				
				//score
				if("score".equals(fieldName)){
					score = Double.parseDouble(item.getString());
				}
				
			}else{//�ļ�����
				//photo
				if("photo".equals(fieldName)){
					//����5�������ϴ��ļ���С  16kb���ڴ˴������ô��ַ��������ļ���С���ǲ����ʵģ�
//					long size = item.getSize();
//					if(size > 16*1024){
//						request.setAttribute("mess", "�ļ����ܳ���16kb");
//						request.getRequestDispatcher("/add.jsp").forward(request, response);
//						return;
//					}
					
					//����4��ֻ�ϴ�jpg��jpeg��gif�ļ�
					String contentType = item.getContentType();//images/jpg
					photoType = item.getContentType();
					if(!"image/jpeg".equals(contentType) && !"image/gif".equals(contentType)){
						request.setAttribute("mess", "ֻ���ϴ�jpg��gif�ļ�");
						request.getRequestDispatcher("/add.jsp").forward(request, response);
						return;
					}
					//ָ���ϴ����ļ��У�Tomcat��webAppsĿ¼�£�Tomcat��webAppsĿ¼֮�⣩
					//File dir = new File("d:/upload");//Servlet�Ƿ������������˴�ֻ�����·��
					//ֱ��ʹ������·���������
					//����3�����߼�·���õ�����·������������
					//File dir = new File("D:\\Java\\apache-tomcat-7.0.79\\webapps\\updownload1/upload");
					//String path = "upload";//�߼�·��
					///upload-----------C:\\Java\\apache-tomcat-7.0.79\\webapps\\updownload1/upload
					String realPath = this.getServletContext().getRealPath("/upload");
					File dir = new File(realPath);
					//����1������ļ��в����ڣ��ʹ���
					if(!dir.exists()){
						dir.mkdirs();
					}
					//ָ���ϴ����ļ���
					realName = item.getName(); //adfad.fadf.yi.jpg   
					//ָ���������ļ��к��ļ���
					//����2��Ϊ�˷�ֹ�ļ���ͬ�����ǣ��ϴ����������˵��ļ���������
					UUID uuid = UUID.randomUUID();
					String extName = realName.substring(realName.lastIndexOf("."));
					photoName = uuid.toString()+extName; //535bc231-935a-427b-a1d7-b3e6d8b8293e.jpg
					
					File file = new File(dir, photoName);
					//�ϴ�����Ƭ��ָ��λ��
					try {
						item.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//other 
			}			
			
		}
		
		
		Student stu = new Student(name, age, score, realName, photoName, photoType);
		
		StudentService  stuService = new StudentServiceImpl();
		int n = stuService.save(stu);
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
