<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link href="/static/images/styles.css" type="text/css" rel="stylesheet">
    <script src="/static/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        function warning() {
            if ($("#a").val()!="" || $("#b").val()!="" || $("#c").val()!="" || $("#d").val()!="" ) {
                alert("成功");
                return true;
            } else {
                alert("必须填入四个条件")
                return false;
            }
        }
    </script>
    </head>
<body>
<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0" align="center">
        <tr>
            <td class="td_title1">·当前位置：医药管理&gt;&gt;高级查询</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="<%=basePath%>/baseData/Advanced.action" method="post" focus="name" onsubmit="return warning()">
                    <input type="hidden" name="command" value="query"/>
                    <table border="0" align="center" width="450">
                        <tr>
                            <td align="right">药品编码：</td>
                            <td align="left"><input type="text" id="a" name="medNo"/></td>
                        </tr>
                        <tr>
                            <td align="right">药品名称：</td>
                            <td align="left"><input type="text" id="b" name="name"/></td>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">出厂地址：</td>
                            <td align="left"><input type="text" id="c" name="factoryAdd"/></td>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">描述：</td>
                            <td align="left"><input type="text" id="d" name="description"/></td>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input id="aaa" type="submit" value="提交"/></td>
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
