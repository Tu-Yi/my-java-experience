<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录后跳转页面</title>
  </head>
  
  <body>
		<table>
			<tr>
				<td>功能编号</td>
				<td>功能名称</td>
				<td>功能url</td>
			</tr>
			<c:forEach items="${sessionScope.user.roles}" var="role">
				<c:forEach items="${role.permissions}" var="permission">
					<tr>
						<td>${permission.fid}</td>
						<td><a href="${ctx}/${permission.furl}">${permission.fname}</a> </td>
						<td>${permission.furl}</td>
					</tr>
				</c:forEach>
			</c:forEach>
			
		</table>
  </body>
</html>