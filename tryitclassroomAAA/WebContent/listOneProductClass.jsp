<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.productclass.model.*"%>
<%-- ������script���� �A���m�ߧ�αĥ� EL ���g�k���� --%>

<%
ProductClassVO productclassVO = (ProductClassVO) request.getAttribute("productclassVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���~������� - listOneProductClass.jsp</title>
<script src="js/jquery-1.12.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/u/bs/jq-2.2.3,dt-1.10.12/datatables.min.css" />
</head>
<body bgcolor='white'>
	<div style="text-align: center;">
		<table border='1'
			class="table table-bordered table-striped table-hover">
			<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
				<td><h3>���~������� - ListOneProductClass.jsp</h3> <a
					href="Product_DataTables.html">�^����</a></td>
			</tr>
		</table>

		<table border='1' bordercolor='#CCCCFF' width='600' align="center">
			<tr align='center' valign='middle'>
				<th>���~�����s��:</th>
				<th>���~�����W��:</th>
					
			</tr>
			<tr align='center' valign='middle'>
				<td><%=productclassVO.getClass_no()%></td>
				<td><%=productclassVO.getClass_name()%></td>
			</tr>
		</table>
	</div>
</body>
</html>
