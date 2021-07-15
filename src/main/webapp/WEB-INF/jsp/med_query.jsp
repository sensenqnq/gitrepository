<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bean" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><bean:message key="system.category.medicine.query" /></title>	
	<link rel="stylesheet" type="text/css" href="/static/images/styles.css">
  </head>
  <body>
    <div class="div1">
	<table width="100%" cellpadding="0" cellspacing="0" border="0"	align="center">
		<tr>
			<td class="td_title1">·当前位置：医药管理&gt;&gt;高级查询</td>
		</tr>
		<tr>
			<td bgcolor="#FFFFFF" height="50">
			<br>
    <form  focus="name" onsubmit="warning()">
    	<input type="hidden" name="command" value="query" />
      <table border="0" align="center" width="450">        
        <tr>
          <td align="right">药品编码：</td>
          <td align="left"><input type="text"  name="medNo"/></td>
        </tr>
        <tr>
          <td align="right">药品名称：</td>
          <td align="left"><input type="text"  name="name"/></td></td>
        </tr>
        <tr>
          <td align="right">出厂地址：</td>
          <td align="left"><input type="text" name="factoryAdd"/></td></td>
        </tr>
        <tr>
          <td align="right">描述：</td>
          <td align="left"><input type="text" name="description"/></td></td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="提交"/></td>
		  </td>
        </tr>
      </table>
    </form>
    </td>
	</tr>
	</table>
	</div>
  <script type="text/javascript">
      function warning() {
          if ($("#")){

          }

      }
  </script>
  </body>
</html>
