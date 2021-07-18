<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
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
				<td class="td_title1">·当前位置：医药管理&gt;&gt;查看药品
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
  		<table border="1" align="center" width="700" cellpadding="1" cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
       <tr bgcolor="#FFFFFF" >
          <td align="center" colspan="4" height="40">
              药品信息
		  </td>
		  <td rowspan="7" width="350" align="center" valign="middle">				
	          		<img src="/static/upload/${med.photoPath}" width="320" alt="药品图片"	height="220" />
		  </td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70">ID：</td>
          <td align="left">${med.id}</td>
          <td class="tb_tl2" align="right" width="70">药品编码：</td>
          <td align="left">${med.medNo}</td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70">药品名称：</td>
          <td align="left" colspan="3">${med.name}</td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70">库存数量：</td>
          <td align="left">${med.medCount}</td>
          <td class="tb_tl2" align="right" width="70">需求数量：</td>
          <td align="left">${med.count}</td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70">价格：</td>
          <td align="left">${med.price}</td>
          <td class="tb_tl2" align="right" width="70">所属类别：</td>
          <td align="left">${med.categoryId}</td>
        </tr>
        <tr bgcolor="#FFFFFF" >
          <td class="tb_tl2" align="right" width="70">出厂地址：</td>
          <td align="left" colspan="3">${med.factoryAdd}</td>
        </tr>
        <tr bgcolor="#FFFFFF"  height="40">
          <td class="tb_tl2" align="right" width="70">描述：</td>
          <td align="left" colspan="3">${med.description}</td>
        </tr>
      </table>  	
  	<br>
      </td>
			</tr>
		</table>
	</div>
  </body>
</html>
