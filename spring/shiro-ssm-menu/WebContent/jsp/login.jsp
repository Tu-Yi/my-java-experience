<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>重新登录页面</title>
  </head>
  
  <body>
		<form action="${ctx}/user/login.do" method="post">
			用户名:<input type="text" name="username"/><font color="red">${message}</font><br>
			密  码:<input type="password" name="password"/><br>
			<input type="submit" value="登录"/>
		</form>
  </body>
</html>
