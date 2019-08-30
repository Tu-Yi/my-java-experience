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
	<script type="text/javascript">
		function changeIndex(index){
		 	location.href="servlet/ShowAllServlet?index="+index;
		}
		
		function changeSize(size){
			//alert(size);
			location.href= "servlet/ShowAllServlet?size="+size;
		}
		
		function change2(index,size){
		 	//location.href="servlet/ShowAllServlet?index="+index+"&size="+size;
		 	document.forms[0].action="servlet/ShowAllServlet?index="+index+"&size="+size;
		 	document.forms[0].submit();
		}
		
		function change(index,size){
			document.forms[0].index.value = index;
			//document.forms[0].size.value = size;
			document.getElementById("size").value = size;
		 	document.forms[0].submit();
		}
		
		
	</script>
  </head>
  
  <body> 
  	<hr>
   	<form action="servlet/ShowAllServlet" method="post" id="form1">
	   	<table align="center">
	   		<tr>
	   			<td>姓名</td>	
	   			<td>	   			
	   				<input type="text" name="name" value="${name }">
	   				<input type="hidden"  name="index" value="">
	   				<input type="hidden" id="size" name="size">
	   			</td>
	   			<td>分数>=</td>
	   			<td><input type="text" name="minScore" value="${minScore }"></td>	   			
	   			<td><input type="submit" value="提交"></td>
	   		</tr>
	   	</table>
   	</form>   	
   	<hr>   	
  
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
    	<c:forEach items="${pageBean.list}" var="stu" varStatus="vs">
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
    	<tr>
    		<td colspan="11" align="center">
    			 <a href="javascript:change(1,${pageBean.size })">首页</a> 
    			<c:if test="${pageBean.index !=1 }">
    				<a href="javascript:change(${pageBean.index-1 },${pageBean.size })">上一页  </a>
    			</c:if>
    			<c:if test="${pageBean.index ==1 }">
    				上一页 
    			</c:if>
    			<c:forEach items="${pageBean.numbers }" var="num">
    				<c:if test="${num ==pageBean.index }"> 
    					[<a href="javascript:change(${num },${pageBean.size })">${num }</a>]
    				</c:if>
    				<c:if test="${num != pageBean.index }">
    					<a href="javascript:change(${num },${pageBean.size })">${num }</a>
    				</c:if>
    			</c:forEach>
    			<c:if test="${pageBean.index != pageBean.totalPageCount }">
    				<a href="javascript:change(${pageBean.index+1 },${pageBean.size })">下一页</a>
    			</c:if>
    			<c:if test="${pageBean.index == pageBean.totalPageCount }">
    				下一页 
    			</c:if> 			
    			 <a href="javascript:change(${pageBean.totalPageCount },${pageBean.size })">末页</a> 
    			每页
    				<select onchange="change(${pageBean.index},this.value)">
    					<c:forEach begin="5" end="25" step="5" var="i">
    						<c:if test="${i==pageBean.size }">
    							<option value="${i }" selected="selected">${i }</option>
    						</c:if>
    						<c:if test="${i!=pageBean.size }">
    							<option value="${i }">${i }</option>
    						</c:if>
    					</c:forEach>
    				</select>
    			条记录
    			 直接跳到第 
    			<select onchange="change(this.value,${pageBean.size})">
    				<c:forEach  begin="1"  end="${ pageBean.totalPageCount }" var="num">
    					<c:if test="${num == pageBean.index }">  
    						<option value="${num }" selected="selected">${num }</option>
    					</c:if>
    					<c:if test="${num != pageBean.index }">
    						<option value="${num }">${num }</option>
    					</c:if>
    				</c:forEach>
    			</select> 
    			  页 
    			      			 
    			  共${pageBean.totalCount }条记录
    		</td>    		
    	</tr>
    </table>
   
  </body>
</html>
