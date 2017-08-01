<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function pass(){
			var pass1 =document.getElementById("pass1").value;
			var name =document.getElementById("u_name").value;
			var pass2 =document.getElementById("pass2").value;
			if(pass1==''||pass2==''||name==''){
				alert("请填写完整的信息。。。。");
				return false;
			}
			if(pass1!=pass2){
				alert("两次密码不一致，请重新输入");
				return false;
			}
			return true;
		}
		
	</script>
	
  </head>
  <BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="images/middle2.jpg">&nbsp;</td>
    <td width="172">
	<table align="center">
		<tr>
		  <td><a href="">返回首页</a></td>
		</tr>
		<tr>
		  <td><a href="login_form.htm">用户登陆</a></td>
		</tr>
	</table>
	</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<form action="addUser"  method="post" name="myForm" onsubmit="return pass()">
		<table align="center">
			<tr>
				<td>用户注册：</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
				<td>用户名:${qwe}</td>
				<td><input type="text" id="u_name" name="u_name"/></td>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="pass1" name="u_pass"></td>
			<tr>
			<tr>
				<td>重复密码：</td>
				<td><input type="password" id="pass2" name="upass1"></td>
			<tr>
				<td><input type="submit" value="注册" class="btn">&nbsp;</td>
				<td><input type="reset" value="重置" class="btn"></td>
			</tr>
		</table>
	</form>
	</td>
    <td width="40" background="images/middle4.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
  </tr>
</table>
<P align="center"> 版权所有</P>
<br/>
</BODY>
</html>
