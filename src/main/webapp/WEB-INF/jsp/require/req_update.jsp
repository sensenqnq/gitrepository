<%@page language="java" pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" %>
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
				<td class="td_title1">·当前位置：进货/需求管理	&gt;&gt; 更新需求</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <form action="/dms/update.action" method="post">
    	<input type="hidden" name="command" value="add" />
      <table border="0" align="center" width="500">
        <tr>
          <td align="right">药品编码：</td>
          <td align="left"><input type="text" name="medNo" value="${med.medNo}" readonly/></td>
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
          <td align="right">需求数量</td>
          <td align="left"><input type="text" name="count" value="${med.count}"/>
                	<font color="red">
                        目前数量：<input type="text" name="medCount" value="${med.medCount}" disabled/>
          	</font>
          </td>
        </tr>
        <tr>
          <td align="right">出厂地址：</td>
          <td align="left"><input type="text" name="factoryAdd" value="${med.factoryAdd}" disabled/></td>
        </tr>
        <tr>
          <td align="right">描述：</td>
          <td align="left"><input type="text" name="description" value="${med.description}" disabled/></td>
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
