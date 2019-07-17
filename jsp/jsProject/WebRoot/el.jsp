<%@ page language="java" import="java.util.*,com.niliv.pojo.*" pageEncoding="utf-8"%>
<!--将流转数据显示到浏览器中：使用传统方式  -->
<h3>传统方式在jsp中获取作用域中的数据</h3>
<%--
	缺陷:
		1、书写比较繁琐
		2、需要导包
		3、需要强转
 --%>
<hr />
<h3>使用EL表达式方式获取作用域数据</h3>
<%--
	El表达式的语法：
		${表达式}
		注意：
			自带响应功能
	El表达式的使用：
		El表达式获取请求数据
			获取用户请求数据(请求实体) 
				${param.键名}  获取请求实体中一个键一个值的数据
				${paramValues.键名} 获取请求实体中同键不同值的数据，返回的是String数组，可以使用角标直接获取 例如：爱好
			获取请求头数据
				${header}  返回所有的请求头数据，键值对形式
				${header["键名"]} 返回指定的键的请求头数据
				${headerValues["键名"]}
			获取Cookie数据
				${cookie}	获取所有的Cookie对象 键值对
				${cookie.Cookie对象的键名} 获取存储了指定Cookie数据的Cookie对象
				${cookie.Cookie对象的键名.name} 获取存储了指定Cookie数据的Cookie对象的存储的键
				${cookie.Cookie对象的键名.value}获取存储了指定Cookie数据的Cookie对象的存储的值
		EL表达式获取作用域数据
			作用域对象：pageContext  request  session application 
			作用域数据：我们使用setAttribute方法存储的数据
			获取：
				普通字符串数据 ${键名}
				对象数据 ${键名.属性名}
				集合数据
					list集合 ${键名[角标]}
					Map集合 ${map集合作用域存储的键名.map集合存储的数据的键名}
			作用域数据查找顺序：如果找到了则不再查找，如果找不到，则继续查找下一个作用域，如果四个作用域中都没有则什么都不显示
				pageContext-->request-->session-->application
			指定作用域获取数据：
				${pageScope.键名}   		指明获取pageContext作用域中的数据
				${requestScope.键名}		指明获取request作用域中的数据
				${sessionScope.键名}		指明获取session作用域中的数据
				${applicationScope.键名}	指明获取application作用域中的数据
		EL表达式逻辑运算
			算术运算:+,-,*,/ 在EL表达式中可以直接进行算术运算
				${算术表达式} 例如 :${1+2}
				注意：+表示算术运算，不能进行字符串连接
			逻辑运算:&&  || !
				${逻辑表达式}
				注意：没有单& 和单|
			比较运算:== != >,>=,<,<=
				${比较表达式}
			三目运算：
				${条件?值:值}
		EL表达式的empty判断
			${empty 键名}
			作用：
				判断该键是否有存储有效数据
 --%>
<hr />
${str} <br />
${user.fav} <br />
${list[2]} <br />
${list[3].fav} <br />
${hs.b1} <br />
${hs.u.fav} <br />
<hr />
<h3>获取用户请求数据(请求实体)</h3>
<%=request.getParameter("uname") %>--${param.uname} <br />
<%=request.getParameterValues("fav")[1] %>--${paramValues.fav[1]}
<h3>获取用户请求头数据</h3>
<%=request.getHeader("User-Agent") %>--${header["User-Agent"]}--${headerValues["Accept-Language"][0]}
<h3>获取Cookie数据</h3>
${cookie} <br />
${cookie.JSESSIONID} <br />
${cookie.JSESSIONID.name}--${cookie.JSESSIONID.value}
<h3>EL获取作用域数据时作用域的查找顺序</h3>
<%
	pageContext.setAttribute("hello", "hello pageContext");
	request.setAttribute("hello","hello request");
	session.setAttribute("hello", "hello session");
	application.setAttribute("hello", "hello application");
%>
${requestScope.hello}--${a}
<h3>EL表达式的逻辑运算</h3>
<%
	request.setAttribute("a","2");

%>
${1+2}--${2*3}--${a+3}--${1+"5"} <br />
${2>3&&4<5}--${2>3||4<5}--${!(2>3)} <br />
${2==2}--${3>2}<br />
${2>3?"男":"女"}
<h3>EL表达式的empty判断</h3>
<%
	request.setAttribute("str","");
	User u=new User();
	request.setAttribute("u", u);
	ArrayList la=new ArrayList();
	request.setAttribute("la",la);

%>
${empty str}<br />
${empty u}<br />
${empty la}<br />


<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />







