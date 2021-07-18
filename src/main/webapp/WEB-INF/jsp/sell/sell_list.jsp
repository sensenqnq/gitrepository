<%@ taglib prefix="pg" uri="http://wanggang.cn/common/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title></title>
	  <link rel="stylesheet" href="/static/css/page.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="/static/images/styles.css">
  </head>
  <body>
  <div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">·当前位置：销售管理&gt;&gt;销售明细
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
      <table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
        <tr bgcolor="#FFFFFF">
          <td colspan="8" align="center">
          		<table border="0" width="100%">
          			<tr>
          				<td align="left">
          					<form name="queryForm" action="${pageContext.request.contextPath}/selldetail/sell_list.action" method="get" class="blur_form">
          						<input type="hidden" name="command" value="blurQuery"/>
          						模糊查询：<input name="keyWord" type="text" size="20" value=""/>
          						<input type="submit" value="查询"/>
          					</form>
          				</td>
          			</tr>
          		</table>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl">销售编号</td>
          <td class="tb_tl">药品名称</td>
          <td class="tb_tl">价格</td>
          <td class="tb_tl">数量</td>
          <td class="tb_tl">金额</td>
          <td class="tb_tl">销售时间</td>
          <td class="tb_tl">操作员</td>
        </tr>
		  <c:forEach items="${page.rows}" var="item">
			  <tr bgcolor="#FFFFFF">
				  <td>${item.id}</td>
				  <td>${item.sellName}</td>
				  <td>${item.sellPrice}</td>
				  <td>${item.sellCount}</td>
				  <td>${item.medid}</td>
				  <td>
					  <fmt:formatDate value="${item.sellTime}" pattern="yyy-MM-dd HH:mm:ss"/>
				  </td>
				  <td>${item.userid}</td>
			  </tr>
		  </c:forEach>
	        	<tr bgcolor="#FFFFFF">
		          <td colspan="8" align="right">
		          	<table border="0" width="100%">
		          		<tr>
		          			<td align="right">
			          			<div class="col-md-12 text-right">
						<pg:page url="${pageContext.request.contextPath }/selldetail/sell_list.action" />
								</div>
		          			</td>
		          		</tr>
		          	</table>
			      </td>
			    </tr>
      </table>

					<br>
      <br>
      </td>
			</tr>
		</table>
	</div>
  </body>
</html>
