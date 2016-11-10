<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>


<%-- 此頁採用 JSTL 與 EL 取值 --%>

<%
    ProductService productSvc = new ProductService();
    List<ProductVO> list = productSvc.getAllProduct();
    pageContext.setAttribute("list",list);
%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<!-- <html> -->
<!-- <head> -->
<!-- <title>所有產品資料 - listAllProduct.jsp</title> -->
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
			<td><h3>所有產品資料 - ListAllProduct.jsp</h3> <a
				href="Product_DataTables.html">回首頁</a></td>
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
			<th>產品編號</th>
			<th>產品名稱</th>
			<th>產品價格</th>
			<th>有效期限</th>
			<th>保存天數</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%-- 	<%@ include file="page1.file" %>  --%>
		<%-- 	<c:forEach var="supplierVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
		<c:forEach var="productVO" items="${list}">
			<tr align='center' valign='middle'>
				<td>${productVO.product_no}</td>
				<td>${productVO.product_name}</td>
				<td>${productVO.product_price}</td>
				<td>${productVO.deadline}</td>
				<td>${productVO.deadlineday}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/product.do">
						<input type="submit" value="修改"> <input type="hidden"
							name="product_no" value="${productVO.product_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/product.do">
						<input type="submit" value="刪除"> <input type="hidden"
							name="product_no" value="${productVO.product_no}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%-- <%@ include file="page2.file" %> --%>

</body>
<!-- </html> -->
