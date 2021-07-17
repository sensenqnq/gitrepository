<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
  <head>
    <title></title>	
	<link rel="stylesheet" type="text/css" href="/static/images/styles.css">
	  <script src="/static/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	  <script type="text/javascript">
		  function sub() {
			if (isNaN($("#co").val())){
				return true
			}else {
				alert("必须填入数字");
				return false;
			}
		  }
	  </script>
  </head>
  <body>
    <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">当前位置·:医药管理&gt;&gt; 查看库存</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="100" valign="top">
					<br>
       <form action="<%=basePath%>/baseData/Count" method="post" onsubmit="return sub()">
    	<input type="hidden" name="command" value="QueryMedCount" />
      <table border="0" align="center" width="450">
        <tr>
          <td align="center">
			  库存数量：
          	<select name="type">
				<option value="0">=</option>
				<option value="1">&gt;</option>
				<option value="-1">&lt;</option>
			</select>
			<input type="text" name="count" id="co" size="5" />
			<input type="submit" value="查询"/>
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
