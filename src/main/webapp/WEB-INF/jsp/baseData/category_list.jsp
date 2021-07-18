<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>

	<title></title>

	<link  rel="stylesheet" type="text/css" href="/static/css/page.css">
	<link rel="stylesheet" type="text/css" href="/static/images/styles.css">
</head>
<body>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">当前位置：类别管理>>查看类别>>所有类别
			</tr>

				<td bgcolor="#FFFFFF" height="50">
					<br>
					<table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
						<tr bgcolor="#FFFFFF">
							<td class="tb_tl">类别编号</td>
							<td class="tb_tl">类别名称</td>
							<td class="tb_tl">类别描述</td>
							<td class="tb_tl">创建时间</td>
							<td class="tb_tl">操作</td>
						</tr>
						<c:forEach items="${page.rows}" var="row">
						<tr>
							<tr bgcolor="#FFFFFF">
							<td>${row.id}</td>
							<td>${row.name}</td>
							<td>${row.description}</td>
							<td>${row.createTime}</td>
							<td>
								<a href="${pageContext.request.contextPath}/dms/category_update.action?id=${row.id}">修改</a>
								<a href="${pageContext.request.contextPath}/dms/delete.action?id=${row.id}" class="btn btn-danger btn-xs" >删除</a>
							</td>
						</tr>
						</c:forEach><tr bgcolor="#FFFFFF">
						<td colspan="8" align="right">
							<table border="0" width="100%">
								<tr>
									<td align="right">
										<div class="col-md-12 text-right">
											<pg:page url="${pageContext.request.contextPath}/dms/baseData/med_sell.action" />
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					</table>
					<br>


		</table>

	</div>
		</div>
	</div>

</body>
</html>
