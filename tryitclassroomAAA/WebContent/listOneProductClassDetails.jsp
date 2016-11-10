<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.productclassdetails.model.*"%>
<%-- 此頁為script取值 ，應練習改用採用 EL 的寫法取值 --%>

<%
ProductClassdetailsVO productclassdetailsVO = (ProductClassdetailsVO) request.getAttribute("productclassdetailsVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>產品細部分類資料 - listOneProductClassDetails.jsp</title>
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
				<td><h3>產品細部分類資料 - listOneProductClassDetails.jsp</h3> <a
					href="Product_DataTables.html">回首頁</a></td>
			</tr>
		</table>

		<table border='1' bordercolor='#CCCCFF' width='600' align="center">
			<tr align='center' valign='middle'>
				<th>產品分類名稱:</th>
<!-- 				<th>產品細部分類編號:</th> -->
				<th>產品細部分類名稱:</th>
					
			</tr>
			<tr align='center' valign='middle'>
				<td>${productclassdetailsVO.productClassVO.class_name}</td>
<%-- 				<td><%=productclassdetailsVO.getClassdetail_no()%></td> --%>
				<td><%=productclassdetailsVO.getClassdetail_name()%></td>
			</tr>
		</table>
	</div>
</body>
</html>
