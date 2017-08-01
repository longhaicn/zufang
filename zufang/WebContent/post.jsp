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
    
    <title>My JSP 'post.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function check(){
		var f_title = document.getElementById("f_title").value;
		var f_money = document.getElementById("f_money").value;
		var h_id = document.getElementById("h_id").value;
		var f_tel = document.getElementById("f_tel").value;
		var f_people = document.getElementById("f_people").value;
		var f_mess = document.getElementById("f_mess").value;
		if(f_title==''||f_money==''||h_id==0||f_tel==''||f_people==''||f_mess=='')
			{
				alert("信息均不能为空！");
				return false;
			}else
			{
				return true;
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

	<form action="UpdateAndInsertToBataDaoServlet" method="post" name="mf" onsubmit="return check()">
		<input type="hidden" name="f_id" value="${fw.f_id}"/>
		<table>
			<tr>
				<td colspan="2">发布租房信息：</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
			  <td><strong>标题：</strong></td>
				<td><input type="text" value="${fw.f_title}" id="f_title" name="f_title"></td>
			</tr>
			<tr>
			  <td><strong>租金：</strong></td>
				<td><input type="text" value="${fw.f_money}" id="f_money" name="f_money"/>元/月</td>
			</tr>
			<tr>
			  <td><strong>户型：</strong></td>
				<td><select name="f_shi" id="f_shi">
					<option value="1" ${fw.f_shi==1?"selected='selected'":""}>1</option>
					<option value="2" ${fw.f_shi==2?"selected='selected'":""}>2</option>
					<option value="3" ${fw.f_shi==3?"selected='selected'":""}>3</option>
					<option value="4" ${fw.f_shi==4?"selected='selected'":""}>4</option>
					<option value="5" ${fw.f_shi==5?"selected='selected'":""}>5</option>
					<option value="6" ${fw.f_shi==6?"selected='selected'":""}>6</option>
					<option value="7" ${fw.f_shi==7?"selected='selected'":""}>7</option>
					<option value="8" ${fw.f_shi==8?"selected='selected'":""}>8</option>
					<option value="9" ${fw.f_shi==9?"selected='selected'":""}>9</option>
					<option value="10" ${fw.f_shi==10?"selected='selected'":""}>10</option>
				</select>室<select name="f_ting" id="f_ting">
					<option value="1" ${fw.f_ting==1?"selected='selected'":""}>1</option>
					<option value="2" ${fw.f_ting==2?"selected='selected'":""}>2</option>
					<option value="3" ${fw.f_ting==3?"selected='selected'":""}>3</option>
					<option value="4" ${fw.f_ting==4?"selected='selected'":""}>4</option>
					<option value="5" ${fw.f_ting==5?"selected='selected'":""}>5</option>
					<option value="6" ${fw.f_ting==6?"selected='selected'":""}>6</option>
					<option value="7" ${fw.f_ting==7?"selected='selected'":""}>7</option>
					<option value="8" ${fw.f_ting==8?"selected='selected'":""}>8</option>
					<option value="9" ${fw.f_ting==9?"selected='selected'":""}>9</option>
					<option value="10" ${fw.f_ting==10?"selected='selected'":""}>10</option>
				</select>厅</td>
			</tr>
			<tr>
			  <td><strong>房屋类型：</strong></td>
				<td><select name="h_id" id="h_id">
					<option value='0' >不限</option>
					<c:forEach items="${houses}" var="house">
						<c:if test="${house.h_id==fw.h_id}">
							<option value='${house.h_id}' selected="selected">${house.h_name}</option>
						</c:if>
						<c:if test="${house.h_id!=fw.h_id}">
							<option value='${house.h_id}'>${house.h_name}</option>
						</c:if>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
			  <td><strong>联系电话：</strong></td>
				<td><input type="text" value="${fw.f_tel}" id="f_tel" name="f_tel"></td>
			</tr>
			<tr>
			  <td><strong>联系人：</strong></td>
				<td><input type="text" value="${fw.f_people}" id="f_people" name="f_people"></td>
			</tr>
			<tr>
			  <td><strong>房屋信息：</strong></td>
				<td><textarea id="f_mess" name="f_mess"  rows="10" cols="40">${fw.f_mess}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="center"><input type="submit" value="提交" class="btn"></div>				</td>
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
