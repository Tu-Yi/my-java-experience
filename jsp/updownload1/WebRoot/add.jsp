<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
 
   ${requestScope.mess }
     <form action="servlet/AddServlet" method="post" enctype="multipart/form-data" >   		
    	用户名:<input type="text" name="name"><br>
    	年龄:<input type="text" name="age"><br>
    	分数:<input type="text" name="score"><br>
    	照片:<input type="file" name="photo"><br>    
    	<input type="submit" value="提交">	
    </form>
    
  </body>
</html>
