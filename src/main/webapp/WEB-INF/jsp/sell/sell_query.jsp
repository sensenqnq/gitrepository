<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
				<td class="td_title1">·当前位置：销售管理&gt;&gt;日期查询
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <form name="queryForm" action="${pageContext.request.contextPath}/selldetail/query.action" method="get">
    	<input type="hidden" name="command" value="today" />
      <table border="0" align="center" width="500">
        <tr>
          <td align="right">开始日期：</td>
          <td align="left">
          	<input name="begin" type="text" value=""/>
          	日期格式：yyyy-mm-dd
          </td>
        </tr>
        <tr>
          <td align="right">结束日期：</td>
          <td align="left">
	          <input name="end" type="text" value=""/>
	          日期格式：yyyy-mm-dd
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
          	<input type="submit" value="查询">
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
