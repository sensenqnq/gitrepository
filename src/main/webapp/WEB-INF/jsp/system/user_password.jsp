<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
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
          function hh() {
            $.ajax({
                type:"get",
                url:"/dms/Verify",
                data:{"ps":$("#ps1")},
                success:function (data) {
                    if (data==="b"){
                        alert("原密码错误")
                        return false;
                    }
                    return true;
                }
            })
          }
      </script>
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">·当前位置：系统管理&gt;&gt; 修改密码</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <form action="<%=basePath%>/dms/updatePassword" method="post" onsubmit="return hh()">
    <input type="hidden" name="command" value="modifyPassword" />
      <table border="0" align="center" width="450">
        <tr>
          <td align="right">原密码：</td>
          <td align="left">          	
          	<html:hidden property="id"/><input type="password" name="ps" id="ps1"/></td>
        </tr>
        <tr>
          <td align="right">密码 ：</td>
          <td align="left"><input type="password" name="password"/></td>
        </tr>
         <tr>
          <td align="right">确认密码：</td>
          <td align="left"><input type="password" name="repassword"/></td>
        </tr>
        <tr>
          <td align="center" colspan="2"><input type="submit" value="提交"/> </td>
        </tr>
      </table>
    </form>
    </td>
			</tr>
		</table>
	</div>
  </body>
</html>
