<%@page pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="/static/images/styles.css">
    <script src="/static/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        function ff() {
            var medNo = $("#a").val();
            $.ajax({
                type:"get",
                url:"/baseData/ch",
                data:{"medNo":medNo},
                success:function (data) {
                    console.log(data)
                    if (data==="abc"){
                        $("#b")[0].innerText="已存在相同编码"
                    }else if (data==="aaa"){
                        $("#b")[0].innerText=""
                    }else {
                        $("#b")[0].innerText="编码不能为空"
                    }
                }
            });
        }
        function sub() {
            if ($("#b").text()==="已存在相同编码"){
                alert("药品编码已存在，无法提交")
                return false;
            }else if ($("#b").text()==="编码不能为空"){
                alert("必须填写药品")
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="div1">
    <table width="100%" cellpadding="0" cellspacing="0" border="0"	align="center">
        <tr>
            <td class="td_title1">·<bean:message key="system.current.place"/>当前位置：进货/需求管理&gt;&gt;添加进货</td>
        </tr>
        <tr>
            <td bgcolor="#FFFFFF" height="50">
                <br>
                <form action="/baseData/req_save.action" method="post" onsubmit="return sub()">
                    <table border="0" align="center" width="300">
                        <tr>
                            <td align="right">药品编码：</td>
                            <td align="left"><input type="text" id="a" name="id" onblur="ff()"/></td>
                            <td align="left"><input type="submit" value="提交" /></td>
                        </tr>
                        <tr>
                            <td colspan="3" id="b">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编码不能为空</td>
                        </tr>
                    </table>
                    <form>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
