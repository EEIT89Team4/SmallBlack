<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.product.model.*"%>
<%-- ������script���� �A���m�ߧ�αĥ� EL ���g�k���� --%>

<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���~��� - listOneProduct.jsp</title>
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
				<td><h3>���~��� - ListOneProduct.jsp</h3> <a
					href="Product_DataTables.html">�^����</a></td>
			</tr>
		</table>

		<table border='1' bordercolor='#CCCCFF' width='600' align="center">
			<tr align='center' valign='middle'>
				<th>���~�s��:</th>
				<th>���~����:</th>
				<th>���~�ӳ�����:</th>
				<th>���~�W��:</th>
				<th>����:</th>
				<th>���:</th>
				<th>�t�ӦW��:</th>
				<th>�ƶq:</th>
				<th>�ֿn�P��ƶq:</th>
				<th>�J��:</th>
				<th>���Ĥ��:</th>
				<th>���ĤѼ�:</th>
				<th>ĵ�ܼƶq:</th>
				<th>���~����:</th>
					
			</tr>
			<tr align='center' valign='middle'>
				<td><%=productVO.getProduct_no()%></td>
				<td><%=productVO.getClass_no()%></td>
				<td><%=productVO.getClassdetail_no()%></td>
				<td><%=productVO.getProduct_name()%></td>
				<td><%=productVO.getProduct_price()%></td>
				<td><%=productVO.getUnit()%></td>
				<td><%=productVO.getSupplier_name()%></td>
				<td><%=productVO.getProduct_quantity()%></td>
				<td><%=productVO.getSaleaccount_quantity()%></td>
				<td><%=productVO.getWeight()%></td>
				<td><%=productVO.getDeadline()%></td>
				<td><%=productVO.getDeadlineday()%></td>
				<td><%=productVO.getProduct_alertquantity()%></td>
				<td><%=productVO.getProduct_description()%></td>
			</tr>
		</table>
	</div>
</body>
</html>
