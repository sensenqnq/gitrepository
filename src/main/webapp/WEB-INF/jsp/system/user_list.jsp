<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
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
	<link rel="stylesheet" type="text/css" href="../../../static/images/styles.css">
	  <link href="../../../static/css/page.css" rel="stylesheet">
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">·当前位置：系统管理&gt;&gt; 查看所有管理员&gt;&gt;所有用户
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
      <table border="1" align="center" width="500" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
          <td class="tb_tl">ID</td>
          <td class="tb_tl">用户名</td>
          <td class="tb_tl">创建时间</td>
          <td class="tb_tl">操作</td>
        </tr>
		  <c:forEach items="${page.rows}" var="user">
	        		<tr bgcolor="#FFFFFF">
	        			<td>${user.id}</td>
	        			<td>
	        				${user.username}
	        			</td>
	        			<td>${user.createTime}</td>
	        			<td><a href="<%=basePath%>/dms/deleteUser/${user.id}">删除</a>
	        			</td>
	        		</tr>      </c:forEach>
		  <tr bgcolor="#FFFFFF">
			  <td colspan="4" align="right">
				  <table border="0" width="100%">
					  <tr>
						  <td align="right">
							  <div class="paging">
								  <pg:page url="${pageContext.request.contextPath}/dms/system/user_list.action" />
							  </div>
						  </td>
					  </tr>
				  </table>
			  </td>
		  </tr>
	  </table>
      <br>
      </td>
			</tr>
		</table>
	</div>
  </body>
</html>
