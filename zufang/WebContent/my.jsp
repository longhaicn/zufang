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
    
    <title>My JSP 'my.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function deleteOne(f_id){
		if(confirm("确定删除？")){
			window.location.href="DeleteFangWuServlet?f_id="+f_id;
		}
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
	<tr>
		<td width='150'><a href="MyAllFangWuServlet?u_id=${user.u_id}">管理我的租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="SelectAllHouseTypeServlet?f_id=0">发布租房信息</a></td>
	</tr>
	<tr>
		<td width='100'><a href="AllMess">返回首页</a></td>
	</tr>
	<tr>
		<td width='100'><a href="SessionCloseServlet">[注销]</a></td>
	</tr>
	</table>
</td>
    <td width="35" background="images/layout_24.gif">&nbsp;</td>
    <td width="495">
	<table>
		<tr>
			<td width="3%">&nbsp;</td>
			<td width="97%">
			
			
			<table width='450' border='0'>
				<tr>
					<TD>标题</TD>
					<TD width='100' align='center'>月租金</TD>
					<TD width='110'align='center'>发布日期</TD>
					<TD width='50'>&nbsp;</TD>
					<TD width='50'>&nbsp;</TD>
				</tr>
				<tr>
					<td colspan='5'><hr/></td>
				</tr>
				<c:forEach items="${fws}" var ="fw" >
				<tr>
					<td><a href='selOne?id=${fw.f_id}'>${fw.f_title}</a></td>
					<td align='center' style='height:30px;'>${fw.f_money}元</td>
					<td align='center' style='height:30px;'>${fw.f_date}</td>
					<td align='center' style='height:30px;'><a href="javascript:deleteOne('${fw.f_id}')">[删除]</a></td>
					<td align='center' style='height:30px;'><a href='SelectAllHouseTypeServlet?f_id=${fw.f_id}'>[修改]</a></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan='5'><hr/></td>
				</tr>
			</table>
			
			
			
			
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
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
