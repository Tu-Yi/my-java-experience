<%@page import="com.bjsxt.pojo.Menus"%>
<%@page import="java.util.List"%>
<%@page import="com.bjsxt.pojo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <SCRIPT language=javascript src="js/dtree/dtree.js"></SCRIPT>
    <script type="text/javascript" src="js/java-like.util.js"></script>
    <link rel="stylesheet" href="js/dtree/dtree.css" type="text/css">
</head>
<body>
	<form action="" name="form1" method=POST>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td rowspan="5" width="1" bgcolor="CCCCCC"></td>
            <td bgcolor="CCCCCC" height="1"></td>
            <td rowspan="4" bgcolor="CCCCCC" width="1"></td>
        </tr>

        <tr>
            <td bgcolor="E3E7FF" align="center" height="5"></td>
        </tr>

        <tr>
            <td bgcolor="CCCCCC" height="1"></td>
        </tr>

        <tr>
            <td bgcolor="F9F9F9" align="center" valign="top">
                <table width="90%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="F5F5F5">
                    <tr bgcolor="F3F9FF">
                        <td bgcolor="F5F5F5">
                            <SCRIPT LANGUAGE="JavaScript">
                                d = new dTree('d');
                                d.config.target = "body";
                                d.config.imageDir = 'js/dtree/img';
                                d.reSetImagePath();
                                d.config.folderLinks = false;
                                d.config.closeSameLevel =true;
                                var isOpen ;
                                //根节点
								<%
									Users user = (Users)session.getAttribute("user");
                                List menus = user.getMenus();
                                for(int i=0;i<menus.size();i++){
                                	Menus menu = (Menus)menus.get(i);
								%>
                                d.add(<%=menu.getMenuid() %>, <%=menu.getFatherid() %>, '<%=menu.getMenuname() %>', '<%=menu.getMenuurl() %>', '', 'body');
								<%}%>
                                document.write(d);
                            </script>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr>
            <td background="images/jao1.gif" colspan="2" align="right"><img
                    src="images/jao.gif" width="8" height="8"></td>
        </tr>

    </table>
</form>
</body>
</html>