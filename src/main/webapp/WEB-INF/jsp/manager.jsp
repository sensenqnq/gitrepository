<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>医药管理系统</title>
	</head>	
		<frameset rows="180,*" cols="*" framespacing="0" frameborder="no"
			border="0">
			<frame src="<%=basePath%>/" name="top" scrolling="NO">
			<frameset rows="*" cols="223,*" framespacing="0" frameborder="no"
				border="0">
				<frame src="left.html" name="left">
				<frame src="" name="main">
			</frameset>
		</frameset>
		<noframes>
			<body>
			</body>
		</noframes>
	</logic:notEmpty>
</html>
