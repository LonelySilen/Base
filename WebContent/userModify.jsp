<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userModify.jsp' starting page</title>
    
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
	body{ margin-top:0px; background-image:url(D:\jsp3\movie4\WebRoot\images\register\1.jpg); background-repeat:no-repeat; background-position:right;}
		#top{ margin-top:0px; height:100px; text-align:center;}
		#content{ margin-top:100px; height:500px; width:500px; margin:auto; }
</style>
  </head>
  
 <body>
 <%
 String usn = (String)session.getAttribute("usn");
  %>
 	<div id="top">
    	<h1><font color="black">个人信息修改界面</font></h1>
    </div>
	<div id="content">
	<form action="userModifyServlet?usn=<%=usn %>" method="post"" >
    	<table width="500" height="447">
        	
           
            <tr>
            	<td width="112" height="36">
                	<h3>密码：</h3>
                </td>
                 <td width="258">
                	<input type="password" width="200" height="25" name="pwd" />
                </td>
                <td>
                	<font size="-1" color="#FF0000"></font>
                <td width="114">
            </tr>
            <tr>
            	<td height="34">
                	<h3>重复密码：</h3>
                </td>
                <td>
                	<input type="password" width="200" height="25" name="repwd" />
                </td>
                <td>
                	<font size="-1" color="#FF0000">两次密码务必一致</font>
                </td>
            </tr>
            <tr>
            	<td height="39">
                	<h3>性别：</h3>
                </td>
                <td>
                	<input type="radio" value="男" name="gender" />男
                    <input type="radio" value="女" name="gender" />女
                </td>
                <td>
                </td>
            </tr>
            <tr>
            	<td height="36">
                	<h3>手机：</h3>
                </td>
                <td>
                	<input type="text" width="200" height="25" name="mobile" />
                </td>
                <td>
                </td>
            </tr>
            <tr>
            	<td height="34">
                	<h3>邮编：</h3>
                </td>
                <td>
                	<input type="text" width="200" height="25" name="postcart" />
                </td>
                <td>
                </td>
            </tr>
            <tr>
            	<td height="34">
                	<h3>地址：</h3>
                </td>
                <td>
                	<input type="text" width="200" height="25" name="address" />
                </td>
                <td>
                </td>
            </tr>
            
             <tr>
            	<td height="33">
                </td>
                <td align="center">
                	<input type="submit" value="修改" />
                    <input type="reset" value="重置" />
                </td>
                <td>
                </td>
            </tr>
             
             <tr height="34">
            	<td colspan="3" style="text-align:center;"><span id="formMsg"></span></td>
            </tr>
        </table>
    </form>
    </div>
</body>
</html>
