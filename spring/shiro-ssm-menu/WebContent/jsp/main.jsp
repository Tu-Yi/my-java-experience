<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统-主页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">   
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>   
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#main_tree').tree({    
	    url:'${pageContext.request.contextPath}/menu/showMenu.do'   
	}); 
})
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'顶部',split:true" style="height:100px;">
    	后台管理系统  
    	<shiro:hasRole name="管理员">
	    	<a id="main_register" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">注册新用户（管理员可见）</a>  
    	</shiro:hasRole>
    </div>   
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;">
    	底部信息
    </div>   
    <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
    	<ul id="main_tree"></ul> 
    </div>   
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
</body>  
</html>