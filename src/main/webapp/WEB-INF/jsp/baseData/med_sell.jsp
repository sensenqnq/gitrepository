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
    <link rel="stylesheet" type="text/css" href="/static/images/styles.css">
	  <link href="/static/css/page.css" rel="stylesheet">
  </head>
  <body>
  <div class="div1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0"	align="center">
		<tr>
			<td class="td_title1">·当前位置：购买药品&gt;&gt;选购药品	</td>
		</tr>
		<tr>
		   <td bgcolor="#FFFFFF" height="50">
					<br>
       <table border="1" align="center" width="600" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
          <td colspan="7" align="center">
          		<table border="0" width="100%">
          			<tr>
          				<td align="left">
          					<form  action="<%=basePath%>/dms/baseData/med_sell.action" method="post"  class="blur_form">
          						模糊查询：<input name="keyWord" type="text" size="20"/>
          						<input type="submit" value="提交"/>
          					</form>
          				</td>
          			</tr>
          		</table>
          </td>
        </tr>

        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl">药品ID</td>
          <td class="tb_tl">药品名称</td>
          <td class="tb_tl">价格</td>
          <td class="tb_tl">库存数量</td>
          <td class="tb_tl">出厂地址</td>
          <td class="tb_tl">操作</td>
        </tr>
		   <c:forEach  items="${page.rows}" var="med">
	        		<tr bgcolor="#FFFFFF" >
	        			<td>${med.medNo}</td>
	        			<td>${med.name}</td>
						<td>${med.price}</td>
	        			<td>${med.medCount}</td>
	        			<td>${med.factoryAdd}</td>
	        			<td>
	        				<a href="${pageContext.request.contextPath}/dms/sell/sell_add/${med.id}/${med.name}/${med.price}/${med.factoryAdd}">购买</a>
	        			</td>
	        		</tr>	</c:forEach>
		   <tr bgcolor="#FFFFFF">
			   <td colspan="9" align="right">
				   <table border="0" width="100%">
					   <tr>
						   <td align="right">
							   <div class="paging">
								   <pg:page url="${pageContext.request.contextPath}/dms/baseData/med_sell.action" />
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
