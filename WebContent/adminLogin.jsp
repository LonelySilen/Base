<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
</script>
	<style type="text/css">
	body{ margin-top:0px; background-image:url(D:\jsp3\movie4\WebRoot\images\adminpic\login.png); background-repeat:no-repeat; background-color:#0E6D38;}
		#top{ margin-top:40px; height:100px; font-size:36px; font-weight:bolder; text-align:center;}
		#content{ margin-top:50px; height:200px;}
		#uname , #upass{ border:1px solid #69F; width:150px; }
</style>
  </head>
  
  <body>
  	<div id="top">
    	海 布 里 电 影 网 站 管 理 系 统
    </div>
	
   <div id="content">
   		<form action="adminLoginServlet" method="post">
    	<table width="425" height="139" align="center">
    		<tr>
    			<td width="143" height="43"></td>
    			<td width="184"></td>
    			<td width="82"></td>
    		</tr>
    		<tr>
    			<td height="43"></td>
    			<td></td>
    			<td></td>
    		</tr>
        	<tr>
            	<td height="43" align="right">账号：</td>
                <td>
                	<input name="usn" type="text" height="40" width="170" />
                </td>
                <td></td>
            </tr>
            <tr>
            	<td height="44" align="right">密码： </td>
                <td>
                	<input name="pwd" type="password" height="40" width="170" />
                </td>
                <td></td>
            </tr>
            <tr>
            	<td></td>
                <td>
                	<input type="submit" value="登录" />
                    <input type="reset" value="重置" />
                </td>
                <td></td>
            </tr>
           
        </table>
        </form>
</div>

</body>
</html>
