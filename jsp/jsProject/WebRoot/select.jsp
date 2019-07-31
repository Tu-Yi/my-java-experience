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
<script src="js/jquery.js"></script>
<style>
select {
	width: 200px;
	height: 30px;
}
div {
	margin: 0 auto;
	width: 700px;
	margin-top:200px;
}
</style>
</head>
<body>
	<div>
		<label for="province">省</label> <select name="" id="province"></select>
		<label for="city">市</label> <select name="" id="city"></select> 
		<label for="region">区</label> <select name="" id="region"></select>
	</div>
	<script>
		$(function(){
			bindSelect(0,"province")
			$("#province").change(()=>{
				let areaid = $("#province").val()
				console.log(areaid)
				bindSelect(areaid,"city")
			})
			$("#city").change(()=>{
				let areaid = $("#city").val()
				console.log(areaid)
				bindSelect(areaid,"region")
			})
		})
		function bindSelect(areaid,selId){
			$.get("area",{parentid:areaid},data=>{
				let areas = JSON.parse(data);
				console.log(areas)
				let sel = $("#"+selId)
				sel.empty();
				for(let i=0;i<areas.length;i++){
					sel.append("<option value="+areas[i].areaid+">"+areas[i].areaname+"</option>")
				}
				$("#"+selId).trigger("change")
			})
		}
	</script>
</body>
</html>