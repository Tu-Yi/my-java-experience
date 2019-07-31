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
<link rel="stylesheet" href="css/area.css" />
</head>
<body>
	<div id="wrapper_pre" class="wrapper">
		<div class="inputWrapper">
			<input id="pre" type="text" autocomplete="off" placeholder="省/市"> 
		</div>
		<ul id="preData" class="suggestion">
		</ul>
	</div>
	<div id="wrapper_city" class="wrapper">
		<div class="inputWrapper">
			<input id="city" type="text" autocomplete="off" placeholder="市/区/县"> 
		</div>
		<ul id="cityData" class="suggestion">
		</ul>
	</div>
	<div id="wrapper_county" class="wrapper">
		<div class="inputWrapper">
			<input id="county" type="text" autocomplete="off" placeholder="区/县"> 
		</div>
		<ul id="countyData" class="suggestion">
		</ul>
	</div>
	<script src="js/jquery.js"></script>
	<!-- js工具，主要使用输入防抖动函数 -->
	<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.15/lodash.min.js"></script>
	<!-- localstorage处理对象 -->
	<script src="js/storage.js"></script>
	<!-- 页面初始化 -->
	<script src="js/init.js"></script>
	<!-- 区域数据对象，提供获取区域数据promise -->
	<script src="js/area.js"></script>
	<!-- 处理3个input操作 -->
	<script src="js/view_pre.js"></script>
	<script src="js/view_city.js"></script>
	<script src="js/view_county.js"></script>
</body>
</html>




