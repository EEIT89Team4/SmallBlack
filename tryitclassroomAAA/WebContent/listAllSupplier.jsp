<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.supplier.model.*"%>


<%-- 此頁採用 JSTL 與 EL 取值 --%>

<%
    SupplierService supplierSvc = new SupplierService();
    List<SupplierVO> list = supplierSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<!-- <html> -->
<!-- <head> -->
<!-- <title>所有員工資料 - listAllEmp.jsp</title> -->
<!-- <script src="js/jquery-1.12.3.min.js"></script> -->
<!-- <script src="js/bootstrap.min.js"></script> -->
<!-- <script type="text/javascript" -->
<!-- 	src="https://cdn.datatables.net/u/bs/jq-2.2.3,dt-1.10.12/datatables.min.js"></script> -->
<!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="https://cdn.datatables.net/u/bs/jq-2.2.3,dt-1.10.12/datatables.min.css" /> -->
<!-- </head> -->
<body bgcolor='white'>
	<!-- <b><font color=red>此頁練習採用 EL 的寫法取值:</font></b> -->
	<table class="table table-bordered table-striped table-hover">
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>所有廠商資料 - ListAllSupplier.jsp</h3> <a
				href="Supplier_DataTables.html">回首頁</a></td>
		</tr>
	</table>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>請修正以下錯誤:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<table id='table1' border='1'
		class="table table-bordered table-striped table-hover">
		<tr>
			<th style="text-align:center">廠商編號</th>
			<th style="text-align:center">廠商名稱</th>
			<th style="text-align:center">負責人</th>
			<th style="text-align:center">修改</th>
			<th style="text-align:center">刪除</th>
		</tr>
		<%-- 	<%@ include file="page1.file" %>  --%>
		<%-- 	<c:forEach var="supplierVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
		<c:forEach var="supplierVO" items="${list}">
			<tr align='center' valign='middle'>
				<td>${supplierVO.supplier_id}</td>
				<td>${supplierVO.supplier_name}</td>
				<td>${supplierVO.chargeperson}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/supplier.do">
						<input type="submit" value="修改"> <input type="hidden"
							name="supplier_id" value="${supplierVO.supplier_id}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/supplier.do">
						<input type="submit" value="刪除"> <input type="hidden"
							name="supplier_id" value="${supplierVO.supplier_id}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%-- <%@ include file="page2.file" %> --%>

</body>
<!-- </html> -->
