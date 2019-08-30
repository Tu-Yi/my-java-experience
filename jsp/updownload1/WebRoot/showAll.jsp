<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAll.jsp' starting page</title>
    
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
  
   
  	<!--输出所有的学生信息 -->
  	<a  href="add.jsp">添加学生信息</a>

   		<table align="center" border="1" width="70%">
   		<tr>
   			<th>编号</th>
   			<th>姓名</th>
   			<th>年龄</th>
   			<th>分数</th>   
   			<th>照片</th>   		
   			<th>下载</th>
   		</tr>   		
   		<c:forEach items="${requestScope.stuList2}" var="stu" >
   			<tr>
   				<td>${stu.id}</td>
   				<td>${stu.name }</td>
   				<td>${stu.age }</td>
   				<td>${stu.score}</td>  
   				<td><img alt="" src="upload/${stu.photoName }" width="100px"></td>   			
   				<td>
   					<a href="upload/${stu.photoName }">下载1</a>
   					<a href="servlet/DownServlet?id=${stu.id}">下载2</a>
   				</td>
   			</tr>   			
   		</c:forEach>    		     			
   	</table>
   
   
  </body>
</html>
