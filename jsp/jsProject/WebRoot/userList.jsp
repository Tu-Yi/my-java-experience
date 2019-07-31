<%@ page language="java" import="java.util.*,com.niliv.pojo.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong></div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">id</th>
      <th width="15%">用户名</th>
      <th width="10%">密码</th>
      <th width="10%">操作</th>
    </tr>
    <c:forEach items="${users}" var="user">
    <tr>
      <td width="5%">${user.id}</td>
      <td width="15%">${user.uname}</td>
      <td width="10%">${user.pwd}</td>
      <td width="10%"><div class="button-group"> <a class="button border-main" href="cateedit.html"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="del('${user.id}')" ><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
    </c:forEach>
  </table>
</div>
<script type="text/javascript">
function del(id){
	if(confirm("您确定要删除吗?")){
		$.get("data",{method:'delUserInfo',id},(data)=>{
			if(JSON.parse(data).msg){
				alert("用户删除成功")
				window.location.href="data?method=selUserInfo"
			}
		})
	}
}
</script>
</body>
</html>