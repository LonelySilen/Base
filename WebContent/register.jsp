<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="script/sitedata_bas.js" charset="GBK"></script>
<script language="javascript" src="script/regCheck.js"></script>
<script language="javascript"> 
var Utils = {};
Utils.addEvent = function(el, type, func) {
	if (document.addEventListener) {
		el.addEventListener(type, func, false);
	} else if (document.attachEvent) {
		el.attachEvent('on' + type, func);
	}
};
Utils.addEvent(window, 'load', function() {
	var region1 = document.getElementById("region1");
	var region2 = document.getElementById("region2");
	var region3 = document.getElementById("region3");
	for ( var i = 0; i < arrCity.length; i++) {
		region1.options[i] = new Option(arrCity[i].name, arrCity[i].name);
	}
	region2.options[0] = new Option("请选择", "请选择");
	region3.options[0] = new Option("请选择", "请选择");
	region3.style.display = "none";
	Utils.addEvent(region1, 'change', function() {
		var region1_obj = arrCity[region1.selectedIndex];
		var region2_arr = region1_obj.sub;
		region2.options.length = 0;
		region3.options.length = 0;
		region3.style.display = "none";
		for ( var i = 0; i < region2_arr.length; i++) {
			region2.options[i] = new Option(region2_arr[i].name, region2_arr[i].name);
		}
	});
	Utils.addEvent(region2, 'change', function() {
		var region1_obj = arrCity[region1.selectedIndex];
		var region2_obj = region1_obj.sub[region2.selectedIndex];
		var region3_arr = region2_obj.sub;
		if (region2_obj.type == 0) {
			region3.options.length = 0;
			region3.style.display = "inline";
			for ( var i = 0; i < region3_arr.length; i++) {
				region3.options[i] = new Option(region3_arr[i].name, region3_arr[i].name);
			}
		} else {
			region3.style.display = "none";
		}
	});
});
</script>
<style type="text/css">
	body{ margin-top:0px; background-image:url(D:\jsp3\movie4\WebRoot\images\register\1.jpg); background-repeat:no-repeat; background-position:right;}
		#top{ margin-top:0px; height:100px; text-align:center;}
		#content{ margin-top:100px; height:500px; width:500px; margin:auto; }
</style>

  </head>
  
 <body>
 	<div id="top">
    	<h1><font color="black">注册</font></h1>
    </div>
	<div id="content">
	<form action="registerServlet" method="post" >
    	<table width="500" height="447">
        	<tr>
            	<td width="112" height="36">
                	<h3>姓名：</h3>
                </td>
                <td width="258">
                	<input type="text" width="200" height="25" name="name" />
                </td>
                <td width="114">
                	
                </td>
            </tr>
            <tr>
            	<td height="38">
                	<h3>账号：</h3>
                </td>
                <td>
                	<input type="text" width="200" height="25" name="usn" />
                </td>
                <td>
                </td>
            </tr>
            <tr>
            	<td height="33">
                	<h3>密码：</h3>
                </td>
                <td>
                	<input type="password" width="200" height="25" name="pwd" />
                </td>
                <td>
                	<font size="-1" color="#FF0000"></font>
                </td>
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
                	<input type="radio" value="male" name="gender" />男
                    <input type="radio" value="female" name="gender" />女
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
                	<input type="text" width="200" height="25" name="postCart" />
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
             <tr height="34">
            	<td>验证码：</td>
                <td><input name="code" type="text" /></td>
                <td><img alt="验证码" title="看不清，单击刷新" src="validateCodeServlet" onclick="this.src='validateCodeServlet?a='+Math.random()"/></td>
            </tr>
             <tr>
            	<td height="33">
                </td>
                <td align="center">
                	<input type="submit" value="注册" />
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
