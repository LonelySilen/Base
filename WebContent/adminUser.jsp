<%@page import="com.silen.entity.po.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">
</script>
<style type="text/css">
	body{ background-color:#6CC; margin-top:0px;}
		#top{ background-color:#000; height:100px; margin-top:100px;}
		#content{ background-color:#999; margin-top:50px; width:800px; height:1000px; margin:0 auto;}
</style>
</head>

<body>
<%
	List<User> users = (List<User>)session.getAttribute("users");
 %>
	<div id="top">
		<table width="694" height="92">
        	<tr>
            	<td height="49">
                </td>
                <td>
                </td>
                <td>
                </td>
                <td>
                </td>
                <td align="center">
                	<font color="#FFFFFF" size="+3">用户管理界面</font>
                </td>
            </tr>
            <tr>
            	<td height="35">
                	<a href="adminMovieServlet">电影管理</a>
                </td>
                <td>
                	<a href="adminNewsServlet">新闻管理</a>
                </td>
                <td>
                	<a href="adminLogServlet">评论管理</a>
                </td>
                <td>
                	<a href="adminTicketServlet">票务管理</a>
                </td>
                <td>
                	<a href="login.jsp">退出</a>
                </td>
                
            </tr>
        </table>
    </div>
    <div id="content">
    	<table width="792">
    		<%
    		for(User user : users){
    		%>
    			<tr>
            	<td width="626" height="40">
            		<%=user.getUsn() %>
                </td>
                <td width="77">
                	
                </td>
                <td width="77">
                	<a href="removeUserServlet?id=<%=user.getId() %>">删除</a>
                </td>
            </tr>
            	<% 
    				}
    			 %>
        	
          
        </table>
    </div>
</body>
</html>