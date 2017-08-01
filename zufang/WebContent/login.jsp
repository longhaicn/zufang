<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

  </head>
 <BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
  </tr>
  <tr>
    <td width="38" background="images/middle2.jpg">&nbsp;</td>
    <td width="172" valign="top" align="center">
	<table align="center">
	<tr>
		<td width=''><font color='red'>当前用户：${user.u_name}

			</font>
		</td>
	</tr>
	<tr>
		<td width='150'><a href="MyAllFangWuServlet?u_id=${user.u_id}">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="SelectAllHouseTypeServlet?f_id=0">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="SessionCloseServlet">[注销]</a></td>
	</tr>
	</table>
<style>td{border:solid 0px blue;}
.table_title{
border:solid 1px #aaa;
border-width:0 0 1px 0;
}
</style>
</td>

    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495" align="center"><br/>
	<form action="selectIndexFangWu?ty=login.jsp" method="post" name="mf">
				<div style="text-align:left;width:88%;">
					<input type="text" name="selValue"/>
					<input type="submit" value="查询" class="btn"> 
				</div>
<table width="88%" cellspacing="0">
				<tr  >
					<TD width='250' class="table_title">标题</TD>
					<TD width='90' align='center' class="table_title">月租金</TD>
					<TD align='center' class="table_title">发布日期</TD>
				</tr>
				
			<c:forEach items="${fws}" var="fw">
				<tr>
					<td><a href='selOne?id=${fw.f_id}'>${fw.f_title}</a></td>
					<td align='center' style='height:30px;'>${fw.f_money}元</td>
					<td align='center'>${fw.f_date}</td>
				</tr>
			</c:forEach>
				
			
				
				<tr>
					<td colspan='3'><hr/></td>
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
