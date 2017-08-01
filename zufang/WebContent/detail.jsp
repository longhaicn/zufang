<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function back(){
		history.go(-1);
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
    <td width="172" valign="top">
	<table align="center">
	<tr>
		<td width=''><font color='red'>当前用户：

			${user.u_name}</font>
		</td>
	</tr>
	<c:if test="${user!=null}">
	<tr>
		<td width='150'><a href="MyAllFangWuServlet?u_id=${user.u_id}">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="SelectAllHouseTypeServlet?f_id=0">发布租房信息</a></td>
	</tr>
	</c:if>
	<tr>
		<td width='100'><a href="AllMess">返回首页</a></td>
	</tr>
	<c:if test="${user!=null}">
	<tr>
		<td width='100'><a href="SessionCloseServlet">[注销]</a></td>
	</tr>
	</c:if>
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495" align="center">

	<table width="450">
	  <tr>
		<td id=listTitle>${fhe.f_title}</td>
	  </tr>
	  <tr>
	    <td id=listTitle><hr/></td>
	    </tr>
	  <tr>
		<td><strong>电话/手机：</strong>${fhe.f_tel}</td>
	  </tr>
	  <tr>
		<td><strong>联系人：</strong>${fhe.f_people}</td>
	  </tr>
	  <tr>
		<td><strong>房屋类型：</strong>${fhe.h_name}</td>
	  </tr>
	  <tr>
		<td><strong>户型：</strong>${fhe.f_ting}室${fhe.f_shi}厅</td>
	  </tr>
	  <tr>
		<td><strong>价格：</strong>${fhe.f_money}元</td>
	  </tr>
	  <tr>
		<td><strong>发布时间：</strong>${fhe.f_date}</td>
	  </tr>
	  <tr>
		<td><hr></td>
	  </tr>
	  <tr>
		<td >${fhe.f_mess}</td>
	  </tr>
	  <tr>
		<td><input type="button" value="后退" class="btn" onclick="back()"></td>
	  </tr>
	</table>

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
