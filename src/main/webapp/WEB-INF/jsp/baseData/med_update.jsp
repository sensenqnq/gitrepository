<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<link rel="stylesheet" type="text/css" href="/static/images/styles.css">
  </head>
  <body>
   <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">·当前位置：医药管理&gt;&gt; 更新药品</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <form action="<%=basePath%>/dms/updateM.action" method="post">
      <table border="0" align="center" width="450">
        <tr>
          <td align="right">药品编码</td>
          <td align="left"><input type="text" name="medNo" value="${med.medNo}" disabled/></td>
        </tr>
        <tr>
          <td align="right">药品名称：</td>
          <td align="left"><input type="text" name="name" value="${med.name}" disabled/></td>
        </tr>
        <tr>
          <td align="right">价格：</td>
          <td align="left"><input type="text" name="price" value="${med.price}" disabled/></td>
        </tr>
        <tr>
          <td align="right">库存数量：：</td>
          <td align="left">
          	<input type="text" name="medCount" />
          	<font color="red">目前：${med.medCount}</font>
          </td>
        </tr>
        <tr>
          <td align="right">出厂地址：</td>
          <td align="left"><html:textarea property="factoryAdd" cols="30" rows="3" readonly="true"></html:textarea><input type="text" name="factoryAdd" value="${med.factoryAdd}" /></td>
        </tr>
        <tr>
          <td align="right">描述：</td>
          <td align="left"><input type="text" name="description" value="${med.description}" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>
      </table>
    </form>
    </td>
			</tr>
		</table>
	</div>
  </body>
</html>
