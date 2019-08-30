<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询并显示所有学生信息</title>
    
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
    <!-- 显示所有学生   /stumanager/    -->
    <table align="center" border="1" width="60%">
    	<tr>
    		<th>学生 编号</th>
    		<th>学生姓名</th>
    		<th>学生年龄</th>
    		<th>学生成绩</th>
    		<th>vs.index</th>
    		<th>更新操作</th>
    		<th>删除操作</th>
    	</tr>
    	<c:forEach items="${stulist}" var="stu" varStatus="vs">
    		<tr>
    			<td>${stu.id }</td>
    			<td>${stu.name }</td>
    			<td>${stu.age }</td>
    			<td>${stu.score }</td>
    			<td>${vs.index }</td>
    			<td><a href="/stumanager/servlet/StudentServlet?operate=preupdate&sid=${stu.id}">更新</a></td>
    			<td><a href="/stumanager/servlet/StudentServlet?operate=delete&sid=${stu.id}">删除</a></td>
    		</tr>
    	</c:forEach>
    
    </table>
   
  </body>
</html>
