<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
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
	body{ background-color:#6CF; margin-top:0px;}
		#top{ height:100px; margin-top:100px; text-align:center;}
		#content{ margin:auto; width:1000px; height:200px; margin-top:50px; text-align:center;}
			#content #user{ width:200px; height:200px; float:left;}
			#content #movie{ width:200px; height:200px; float:left;}
			#content #news{ width:200px; height:200px; float:left;}
			#content #log{ width:200px; height:200px; float:left;}
			#content #ticket{ width:200px; height:200px; float:left;}
			#content #quit{ width:200px; height:200px; float:left;}
			
</style>
  </head>
  
<body>
	<div id="top">
    	<font size="+6">你好，管理员</font>
    </div>
    <div id="content">
    	<div id="user">
        	<a href="adminUserServlet"><h1>用户管理</h1></a>
        </div>
        <div id="movie">
        	<a href="adminMovieServlet"><h1>电影管理</h1></a>
        </div>
        <div id="news">
        	<a href="adminNewsServlet"><h1>新闻管理</h1></a>
        </div>
        <div id="log">
        	<a href="adminLogServlet"><h1>评论管理</h1></a>
        </div>
        <div id="ticket">
        	<a href="adminTicketServlet"><h1>票务管理</h1></a>
        </div>
         <div id="quit">
        	<a href="login.jsp"><h1>退出</h1></a>
        </div>
    </div>
</body>
</html>
