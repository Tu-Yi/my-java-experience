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
 *  System.out.println(item.isFormField()); //是否是file表单项   是file false  不是file  true
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
public class AddServlet extends HttpServlet {

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
		//完善5：限制上传的单个和所有文件的大小。建议使用该方式
		upload.setFileSizeMax(16*1024);//单个文件的上限
		upload.setSizeMax(5*16*1024);//一次上传的所有文件的总大小的上限
		
		//3.通过ServletFileUpload对象实现上传操作，将客户端一个个表单项封装到一个个FileItem中
		List<FileItem>  itemList = null;
		try {
			itemList = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			request.setAttribute("mess", "文件不能超过16kb....");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		//4.遍历各个FileItem（相当于对各个表单项进行处理）
		//System.out.println(itemList.size());
		String name = null;
		int age = 0;
		double score = 0;
		String realName =null;
		String photoName = null;
		String photoType = null;
		for(int i=0;i<itemList.size();i++){
			//取出第i个表单项
			FileItem item = itemList.get(i);
			String fieldName = item.getFieldName();
			//对各个表单项进行处理（普通表单项和文件表单项要分开处理）
			if(item.isFormField()){//普通表单项
				
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
				
			}else{//文件表单项
				//photo
				if("photo".equals(fieldName)){
					//完善5：限制上传文件大小  16kb（在此处，采用此种方法限制文件大小，是不合适的）
//					long size = item.getSize();
//					if(size > 16*1024){
//						request.setAttribute("mess", "文件不能超过16kb");
//						request.getRequestDispatcher("/add.jsp").forward(request, response);
//						return;
//					}
					
					//完善4：只上传jpg、jpeg和gif文件
					String contentType = item.getContentType();//images/jpg
					photoType = item.getContentType();
					if(!"image/jpeg".equals(contentType) && !"image/gif".equals(contentType)){
						request.setAttribute("mess", "只能上传jpg和gif文件");
						request.getRequestDispatcher("/add.jsp").forward(request, response);
						return;
					}
					//指定上传的文件夹（Tomcat的webApps目录下，Tomcat的webApps目录之外）
					//File dir = new File("d:/upload");//Servlet是服务器技术，此处只服务端路径
					//直接使用物理路径，不灵活
					//完善3：由逻辑路径得到物理路径，提高灵活性
					//File dir = new File("D:\\Java\\apache-tomcat-7.0.79\\webapps\\updownload1/upload");
					//String path = "upload";//逻辑路径
					///upload-----------C:\\Java\\apache-tomcat-7.0.79\\webapps\\updownload1/upload
					String realPath = this.getServletContext().getRealPath("/upload");
					File dir = new File(realPath);
					//完善1：如果文件夹不存在，就创建
					if(!dir.exists()){
						dir.mkdirs();
					}
					//指定上传的文件名
					realName = item.getName(); //adfad.fadf.yi.jpg   
					//指定长传的文件夹和文件名
					//完善2：为了防止文件的同名覆盖，上传到服务器端的文件重新命名
					UUID uuid = UUID.randomUUID();
					String extName = realName.substring(realName.lastIndexOf("."));
					photoName = uuid.toString()+extName; //535bc231-935a-427b-a1d7-b3e6d8b8293e.jpg
					
					File file = new File(dir, photoName);
					//上传该照片到指定位置
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
