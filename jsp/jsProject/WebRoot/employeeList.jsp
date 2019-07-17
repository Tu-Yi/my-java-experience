<%@ page language="java" import="java.util.*,com.niliv.pojo.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 员工列表</strong>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="5%">id</th>
				<th width="15%">用户名</th>
				<th width="10%">年龄</th>
				<th width="10%">岗位</th>
				<th width="10%">薪水</th>
				<th width="10%">补助</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<c:choose>
					<c:when test="${employee.age<20}">
						<tr style="background:#ccc;">
					</c:when>
					<c:when test="${employee.age>=20}">
						<tr style="background:#c8eccb;">
					</c:when>
				</c:choose>
					<td width="5%">${employee.id}</td>
					<td width="15%">${employee.name}</td>
					<td width="10%">${employee.age}</td>
					<td width="10%">${employee.post}</td>
					<td width="10%">${employee.salary}</td>
					<td width="10%">${employee.assistance}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		function del(id, mid) {
			if (confirm("您确定要删除吗?")) {

			}
		}
	</script>
</body>
</html>