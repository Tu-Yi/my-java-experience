<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">修改部门信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
	    <form action="<%=request.getContextPath()%>/DepartmentServlet?method=update" method="post">
		    <ul class="forminfo">
			    <li><label>部门编号</label><input name="deptno" type="text" class="dfinput" value="${dept.deptno }" readonly/> </li>
			    <li><label>部门名称</label><input name="deptname" type="text" class="dfinput" value="${dept.deptName }"/></li>
			    <li><label>办公地点</label><input name="location" type="text" class="dfinput" value="${dept.location }"/></li>
			    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
		    </ul>
	    </form>
    </div>
	<span style="color:red;font-size:16px;">${error}</span> 
</body>

</html>
