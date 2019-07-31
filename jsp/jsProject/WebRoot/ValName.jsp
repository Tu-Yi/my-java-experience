<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'regJquery.jsp' starting page</title>
    <!--引入jQuery文件  -->
    <script type="text/javascript" src="js/j.js"></script>
    <!-- 
    	jQuery中的ajax学习:
    		jquery是js的一个轻量型框架，已经将js创建的操作进行了封装，而ajax也是js的
    		一部分，所以jQuery也已经将ajax进行了封装。
    	封装：
    		$.get(url,data,fn)	
    			url:请求地址
    			data:请求参数，参数格式为json对象
    			fn:回调函数，注意函数要声明一个形参，用来接收响应数据。
    		$.post(url,data,fn)
    			url:请求地址
    			data:请求参数，参数格式为json对象
    			fn:回调函数，注意函数要声明一个形参，用来接收响应数据。
    		$.ajax({json格式参数}):参数说明参照api
    			
    		
    		
     -->
    <!--声明js代码域  -->
    <script type="text/javascript">
    	//页面加载成功给HTML元素添加事件
    	$(function(){
    		//给用户名文本框添加失去焦点事件
    		$("#uname").blur(function(){
    			//发起ajax请求，校验用户名是否被注册
    				//get请求方式
		    			/* $.get("data",{uname:$("#uname").val()},function(data){
		    				alert(data);
		    			}); */
	    			//post请求方式
	    				/*  $.post("data",{uname:$("#uname").val()},function(data){
							alert(data);
						}); */
	    			//$.ajax方式
	    				$.ajax({
	    					type:"get",
	    					url:"data",
	    					data:"name="+$("#uname").val(),
	    					success:function(data){
	    						alert(data);
	    					}
	    				})	
    		})
    	})
    </script>
  </head>
  
  <body>
  	<h3>jQuery中的ajax学习</h3>
  	<hr />
   	 用户名: <input type="text" name="uname" id="uname" value="" />
  </body>
</html>
