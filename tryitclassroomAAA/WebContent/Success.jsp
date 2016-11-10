<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.supplier.model.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html> -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Success Upload</title>
</head>
<script>

</script>
<body>
<div id="sucDiv1">
    <h1>新增成功!</h1>
    <table border='1' bordercolor='#CCCCFF' width='600' align="center">
			<tr>
				<th style="text-align:center">廠商名稱</th>
				<th style="text-align:center">負責人1</th>			
			</tr>
			<tr align='center'>
				<td><%=request.getParameter("suppliername1")%></td>
				<td><%=request.getParameter("chargepersonname1")%></td>
			</tr>
		</table>
    <input type="button" value="返回廠商列表" id="suc" onclick="location.href='Supplier_DataTables.html'">
    </div>
</body>
<!-- </html> -->