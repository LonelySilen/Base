<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	
	
</style>
<script type="text/javascript">
	function checkForm(){ //表单验证的流程, 只验证错误的情况，出现错误retun false
		//获取用户名
		var uname = document.getElementById("uname").value;
		if(uname.length==0){
			alert("请输入用户名");	
			return false;
		}
		
		if(uname.length<0){
			alert("用户名长度有误。");	
			return false;
		}
		
		//密码
		var upass = document.getElementById("upass").value;
		if(upass.length==0 || upass==""){
			alert("请输入密码");
			return false;
		}
		
		return true;
	}
</script>
	<style type="text/css">
	body{ margin-top:0px; background-image:url(D:\jsp3\movie4\WebRoot\images\login\login.jpg); background-color:#5F1718; }
		#top{ margin-top:40px; height:100px; font-size:36px; font-weight:bolder; text-align:center;}
		#content{ margin-top:50px; height:200px;}
		#uname , #upass{ border:1px solid #69F; width:150px; }
</style>

  </head>
  <body>
  	<div id="top">
    	登录demo
    </div>
	<form action="userLoginServlet" method="post" onsubmit="return checkForm();">
   <div id="content">
    	<table width="425" height="139" align="center">
        	<tr>
            	<td width="143" height="43" align="right">账号：</td>
                <td width="184">
                	<input name="usn" type="text" height="40" width="170" />
                </td>
                <td width="82"></td>
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
            <tr>
            	<td>
            		<a href="adminLogin.jsp"><font size="-1" color="#66CCFF">管理员登陆</font></a>
                </td>
                <td>
                </td>
            	<td valign="middle">
                	<a href="register.jsp"><font size="-1" color="#66CCFF">注册新用户</font></a>
                </td>
            </tr>
        </table>
</div>
</form>
</body>
</html>
