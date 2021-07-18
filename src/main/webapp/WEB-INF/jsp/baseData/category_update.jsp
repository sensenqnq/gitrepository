<%@ page contentType="text/html; charset=UTF-8" deferredSyntaxAllowedAsLiteral="true"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>	</title>
	<link rel="stylesheet" type="text/css" href="/static/images/styles.css">
</head>
<body>
	<div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">·当前位置：类别管理&gt;&gt;修改类别</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
					<form action="${pageContext.request.contextPath}/dms/update1.action?id=${id}" method="post">
						<table border="0" align="center" width="500">
							<tr>
								<td align="right">类别名称：</td>
								<td align="left">
                                    <input type="text" name="name" value="${category.name}"/>
								</td>
							</tr>
							<tr>
								<td align="right">类别描述：
								</td>
								<td align="left">
                                    <input type="text" name="desc" value="${category.description}"/>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit"  value="提交"/>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
