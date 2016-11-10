<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁為script取值 ，應練習改用採用 EL 的寫法取值 --%>

<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>產品資料 - listOneProduct.jsp</title>
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
				<td><h3>產品資料 - ListOneProduct.jsp</h3> <a
					href="Product_DataTables.html">回首頁</a></td>
			</tr>
		</table>

		<table border='1' bordercolor='#CCCCFF' width='600' align="center">
			<tr align='center' valign='middle'>
				<th>產品編號:</th>
				<th>產品分類:</th>
				<th>產品細部分類:</th>
				<th>產品名稱:</th>
				<th>價格:</th>
				<th>單位:</th>
				<th>廠商名稱:</th>
				<th>數量:</th>
				<th>累積銷售數量:</th>
				<th>克數:</th>
				<th>有效日期:</th>
				<th>有效天數:</th>
				<th>警示數量:</th>
				<th>產品介紹:</th>
					
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
