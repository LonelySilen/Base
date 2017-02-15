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
	
	String usn = (String)session.getAttribute("usn");
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
                	<font color="#FFFFFF" size="+3">个人中心</font>
                </td>
            </tr>
            <tr>
            	<td height="35">
                	<a href="indexServlet?usn=<%=usn %>">主页</a>
                </td>
                <td>
                	<a href="showAllMovieServlet?usn=<%=usn %>">电影</a>
                </td>
                <td>
                	<a href="showAllNewsServlet?usn=<%=usn %>">新闻</a>
                </td>
                <td>
                	<a href="showAllLogServlet?usn=<%=usn %>">社区</a>
                </td>
                <td>
                	<a href="login.jsp">退出</a>
                </td>
                
            </tr>
        </table>
    </div>
    <div id="content">
    	
    	<table width="792">
    		
        	 <tr>
            	<td height="40"  align="right">
            		<a href="userModify.jsp?usn=<%=usn %>">修改个人信息</a>
                </td>
                <td>
                </td>
                <td>
                	
                </td>
          </tr>
        </table>
    </div>
</body>
</html>
