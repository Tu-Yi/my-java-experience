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
<script src="//at.alicdn.com/t/font_1244454_xm053xc0h7.js"></script>
<script src="js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.15/lodash.min.js"></script>
<style>
.icon {
	width: 1em;
	height: 1em;
	vertical-align: -0.15em;
	fill: currentColor;
	overflow: hidden;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

ul, ol {
	list-style: none;
}

/*让容器里的元素在页面上居中*/
body {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.wrapper {
	display: flex;
	position: relative;
}

.inputWrapper {
	position: relative;
	display: inline-block;
}

.inputWrapper+button {
	background: #3988fb;
	border: none;
	font-size: 14px;
	padding: 0 20px;
	color: #ffffff;
}

.inputWrapper+button:focus {
	outline: none;
}

.inputWrapper+button:hover {
	box-shadow: 1px 1px 1px 0 rgba(0, 0, 0, 0.5);
	background: #3781f0;
}

.floatDiv {
	position: absolute;
	right: 0;
	top: 0;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-right: 10px;
	color: #b8b8b8;
}

.splitLine {
	width: 0;
	height: 16px;
	border-left: 1px solid;
	margin: 0 10px;
}

input {
	border: 1px solid #b8b8b8;
	width: 540px;
	height: 35px;
	line-height: 35px;
	padding-left: 8px;
	font-size: 15px;
}

.inputWrapper svg.icon {
	width: 20px;
	height: 20px;
	fill: #b8b8b8;
}

.inputWrapper svg.icon:hover {
	width: 20px;
	height: 20px;
	fill: #4b94fc;
	cursor: pointer;
}

input:focus {
	outline: none;
	border-color: #4b94fc;
}

.suggestion {
	position: absolute;
	top: 100%;
	left: 0;
	display: none;
	border: 1px solid #4b94fc;
	padding: 5px;
	width: 540px;
}

.suggestion.active {
	display: block;
}
</style>
</head>
<body>
	<div id="wrapper" class="wrapper">
		<div class="inputWrapper">
			<input id="keyword" type="text" autocomplete="off"> <span
				class="floatDiv"> <svg class="icon" aria-hidden="true">
	          <use xlink:href="#icon-mic"></use>
	        </svg> <span class="splitLine"></span> <svg class="icon"
					aria-hidden="true">
	          <use xlink:href="#icon-LC_icon_camera_line_2"></use>
	        </svg>
			</span>
		</div>

		<button id="search">百度一下</button>
		<ul id="suggestion" class="suggestion">
		</ul>
	</div>
	<script>
		var count=-1;
		$(keyword).on("keyup",  _.debounce(
				function(e){
					var eve = window.event || e;
					var code = eve.keyCode;
					var value = keyword.value
					if(!value.trim()){
						suggestion.classList.remove('active');
						return;
					}
					if (code>=65 && code<=90 || code==8 || code==32) {
						getSuggestion(value).then((datas)=>{
							let listUl = $("#suggestion")
							listUl.empty();
							if(datas.length>0){
								for(let i=0;i<datas.length;i++){
									listUl.append("<li>"+datas[i].title+"</li>")
								}
								$("#suggestion li").mouseover(function(){
									$("#suggestion li").css("background","")
									$(this).css("background","#ccc")
									count=$(this).index();
								})
								$("#suggestion li").click(function(){
									$("#keyword").val($(this).html())
									suggestion.classList.remove('active');
								})
								suggestion.classList.add('active');
							}else{
								suggestion.classList.remove('active');
							}
							
						})
						
					}
					$(document).one("click", function(e) {
						suggestion.classList.remove('active');
					});
					//判断用户点击的是否是键盘的下键
		 			if(code==40){
		 				//判断是否有提示语
		 				if($("#suggestion li").length>0){
		 					//判断
		 					count=count<$("#suggestion li").length-1?++count:0;
		 					//清空所有提示语的div的背景颜色
					 			$("#suggestion li").css("background-color","");
		 					//让提示语div中第一个提示语的背景色变成灰色
			 				$("#suggestion li:eq("+count+")").css("background-color","#ccc");
			 				//将选择的提示语改变到搜索框中
			 				$("#keyword").val($("#suggestion li:eq("+count+")").html());
		 				}
		 			}
		 			//判断用户点击的是否是键盘的上键
		 			if(code==38){
		 				//判断是否有提示语
		 				if($("#suggestion li").length>0){
		 					//判断
		 					count=count>0?--count:$("#suggestion li").length-1;
		 					//清空所有提示语的div的背景颜色
					 			$("#suggestion li").css("background-color","");
		 					//让提示语div中第一个提示语的背景色变成灰色
			 				$("#suggestion li:eq("+count+")").css("background-color","#ccc");
		 					//将选择的提示语改变到搜索框中
			 				$("#keyword").val($("#suggestion li:eq("+count+")").html());
		 				}
		 			}
				},
				500
			)
		);
		$(wrapper).on("click", function(e) {
			e.stopPropagation();
		});
		function getSuggestion(value){
			return new Promise((resolve,reject)=>{
				$.get("search",{sdata:value},function(data){
					let datas = JSON.parse(data)
					resolve(datas)
				})
			})
			
		}
	</script>
</body>
</html>




