<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/springmvc/buyFund" method="POST">
		银行账户名称：<input type="text" name="aname"><br/>
		金额：<input type="text" name="money"><br/>
		基金账户名称：<input type="text" name="fname"><br/>
		数量：<input type="text" name="count"><br/>
		<input type="submit" value="提交"><br/>
	</form>
</body>
</html>