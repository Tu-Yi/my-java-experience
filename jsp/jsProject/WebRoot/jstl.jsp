<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	JSTL学习：
		作用：在jsp页面使用其可以非常方便的进行数据的处理。较与使用java代码块方法，更加的简单，代码更加的简洁易读。
		使用：
			核心标签库
		流程:
			导入jar包
			引入标签库
				<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		内容:
			基本标签：
				out标签:<c:out value="${表达式}" default="默认值"></c:out>
					作用：结合EL表达式将数据响应给浏览器，如果EL表达式没有取到数据则可以使用default属性声明默认值。
				set标签： <c:set value="数据" var="键名" scope="作用域名"></c:set>
					作用：将数据存储到指定的作用域中，默认是pageContext作用域
					注意：
						scope的值为：page  request  session  application
				remove标签：<c:remove var="要删除数据的键名" scope="作用域名"/>
					作用：删除作用域中的数据，默认是删除四个作用域中的符合要求的数据。
						但是可以通过scope属性指明要删除的作用域数据。		
					注意：
						使用pageContext.removeAttriute("键名")，	此方法会将四个作用域中的符合要求的数据全部删除
						使用pageContext.removeAttriute(String name,int scope)
							指明要删除的作用域中的数据 scope的值为 1pageContext,2request ,3 session,4 application
						使用request.removeAttibute("键名") 		删除当前作用域符合要求的数据
						使用session.removeAttibute("键名")	   		删除当前作用域符合要求的数据
						使用application.removeAttibute("键名")		删除当前作用域符合要求的数据
			逻辑标签：
				单分支判断标签:<c:if test="${表达式}">数据</c:if>
					作用：可以根据el表达式进行一定程度的单分支逻辑判断。
					注意：
						test属性中书写的是EL表达式，或者说是EL表达式的逻辑表达式。
						该标签只能进行EL表达式相关的逻辑判断。不能进行EL表达式不能获取的数据的逻辑处理
				多分支判断标签：
					<c:choose>
						<c:when test="${表达式}"></c:when>
						<c:when test="${表达式}"></c:when>
						..
						<c:otherwise></c:otherwise>
					</c:choose>
					注意：
						符合条件后只会执行一个分支，其他分支不会执行。
				循环标签：
					<c:foreach>
						循环体
					</c:foreach>
					属性:
						begin:声明循环的开始位置
						end:声明循环的结束位置
						step:声明循环的步长
						varStatus:声明变量记录循环状态 ,例如变量名:i
							注意：记录的数据存储到了作用域中可以直接使用El表达式进行获取
							示例：   ${i.index}  获取当次循环的下标
								  ${i.count}  获取当次循环的次数
								  ${i.first}  判断是否是第一次循环
								  ${i.last}	     判断是否是最后一次循环
						items:声明要遍历的数据，可以是集合和数组等
							注意：要使用EL表达式来获取
						var:声明变量记录每次遍历的结果。可以做循环体中使用使用EL表达式获取遍历出来的数据	
 --%>
 <h3>JSTL学习：</h3>
 <hr />
 <%
 	request.setAttribute("str","jstl学习");
 %>
 <!-- out标签学习 -->
 <%=request.getAttribute("str") %>--${str}--<c:out value="${str}" default="我是out标签"></c:out>
 <br />
 <!-- set标签学习 -->
 <%
 	request.setAttribute("s1","set标签学习");
	
 %>
 <c:set value="set标签学习2" var="s2" scope="request"></c:set>
 <c:set value="hello pageContext" var="hello" scope="page"></c:set>
 <c:set value="hello request" var="hello" scope="request"></c:set>
 <c:set value="hello session" var="hello" scope="session"></c:set>
 <c:set value="hello application" var="hello" scope="application"></c:set>
 ${s1}--${requestScope.s2}
 <br />
 <!-- remove标签学习 -->
<%-- <%
	pageContext.removeAttribute("hello",4);
 	//request.removeAttribute("hello");
 	//session.removeAttribute("hello");
 %>  --%>
<c:remove var="hello" scope="request"/>
${hello}
 <br />
<!-- 单分支判断标签 -->
<c:set var="a" value="12"></c:set>
<%
	int b=4;
	int a=Integer.parseInt((String)pageContext.getAttribute("a"));
	if(a>8){
%>
	<b>今天天气真好，适合学习1</b>
<%} %>
<c:if test="${a>8}">
	<b>今天天气真好，适合学习2</b>
</c:if>
 <br />
<!--多分支逻辑判断  -->
<c:set var="score" value="40"></c:set>
<c:choose>
	<c:when test="${score>=90}">
		<i>奖励苹果电脑一台</i>
	</c:when>
	<c:when test="${score<90&&score>=80}">
		<i>奖励苹果手机一部</i>
	</c:when>
	<c:when test="${score>=70&&score<80}">
		<i>无奖励无惩罚</i>
	</c:when>
	<c:otherwise>
		<i>男女混合双打</i>
	</c:otherwise>
</c:choose>
 <br />
<!--循环标签  -->
<c:forEach begin="0" end="5" step="1" varStatus="i">
	<c:if test="${i.count==3}">
		<u>我是第三次循环</u>
	</c:if>
	11111--${i.index}--${i.count}--${i.first}--${i.last}<br />
</c:forEach>

<!-- 遍历List集合 -->
<%
	//创建测试数据list
	ArrayList<String> list=new ArrayList<String>();
	list.add("苹果");
	list.add("榴莲");
	list.add("荔枝");
	//将list存储到作用域中
	request.setAttribute("list",list);
	
%>
<c:forEach items="${list}" var="s" varStatus="i">
	${s}--${i.index}--${i.count}<br />
</c:forEach>
<!--遍历map集合  -->
<%
	//声明Map集合测试数据
	HashMap<String,String> hs=new HashMap<String ,String>();
	hs.put("s1","唱歌");
	hs.put("s2", "跳舞");
	hs.put("s3", "敲代码");
	//将数据存储到作用域中
	request.setAttribute("hs", hs);
%>
<c:forEach items="${hs}" var="s">
	${s.key}--${s.value}<br />
</c:forEach>