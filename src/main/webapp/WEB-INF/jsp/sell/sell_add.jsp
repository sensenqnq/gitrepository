<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
				<td class="td_title1">·当前位置：购买药品&gt;&gt; 选购药品
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <form action="${pageContext.request.contextPath}/dms/sell/sell_save.action" method="post">
      <table border="0" align="center" width="500">
        <tr>
          <td align="right">药品名称：</td>
          <td align="left">
          	<input type="hidden" name="id" value="${medicine.id}" />
            <input type="text" name="name" value="${medicine.name}"  disabled/>
          </td>
        </tr>
        <tr>
          <td align="right">价格：</td>
          <td align="left"><input type="text" name="" value="${medicine.price}"  disabled/></td>
        </tr>
        <tr>
          <td align="right">数量：</td>
          <td align="left"><input type="text" name="medCount" /></td>
        </tr>
        <tr>
          <td align="right">出厂地址：</td>
          <td align="left"><input type="text" name="" value="${medicine.factoryAdd}" disabled/></td>
        </tr>
        <tr>
          <td align="center" colspan="2"><input type="submit" value="结帐"/> </td>
        </tr>
      </table>
    </form>
     </td>
			</tr>
		</table>
	</div>
  </body>
</html>
