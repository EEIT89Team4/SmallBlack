<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
	ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java (Concroller), 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<!-- <html> -->
<!-- <head> -->
<!-- <title>廠商資料修改 - update_product_input.jsp</title> -->
<!-- </head> -->
<!-- <script src="js/jquery-1.12.3.min.js"></script> -->
<!-- <script src="js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="https://cdn.datatables.net/u/bs/jq-2.2.3,dt-1.10.12/datatables.min.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="js/calendar.css"> -->
<!-- <script language="JavaScript" src="js/calendarcode.js"></script> -->
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>


<body bgcolor='white'>
	<div style="text-align: center;">
		<table border='1'
			class="table table-bordered table-striped table-hover">
			<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
				<td><h3>產品資料修改 - update_product_input.jsp</h3> <a
					href="Product_DataTables.html">回首頁 </a></td>
			</tr>
		</table>

		<!-- <h3>資料修改:</h3> -->
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

		<FORM METHOD="post" ACTION="product.do" name="form1">
			<table border="0" align="center">
				<tr>
					<td>產品編號:<font color=red><b>*</b></font></td>
					<td><%=productVO.getProduct_no()%></td>
				</tr>
				<tr>
					<td>產品分類:<font color=red><b>*</b></font></td>
					<td><%=productVO.getClass_no()%></td>
				</tr>
				<tr>
					<td>產品細部分類:<font color=red><b>*</b></font></td>
					<td><%=productVO.getClassdetail_no()%></td>
				</tr>
				<tr>
					<td>產品名稱:</td>
					<td><input type="TEXT" name="product_name" size="45"
						value="<%=productVO.getProduct_name()%>" /></td>
				</tr>
				<tr>
					<td>價格:</td>
					<td><input type="TEXT" name="product_price" size="45"
						value="<%=productVO.getProduct_price()%>" /></td>
				</tr>
				<tr>
					<td>單位:</td>
					<td><input type="TEXT" name="unit" size="45"
						value="<%=productVO.getUnit()%>" /></td>
				</tr>
				<tr>
					<td>廠商名稱:</td>
					<td><input type="TEXT" name="supplier_name" size="45"
						value="<%=productVO.getSupplier_name()%>" /></td>
				</tr>
				<tr>
					<td>數量:</td>
					<td><input type="TEXT" name="product_quantity" size="45"
						value="<%=productVO.getProduct_quantity()%>" /></td>
				</tr>
				<tr>
					<td>累積銷售數量:</td>
					<td><input type="TEXT" name="saleaccount_quantity" size="45"
						value="<%=productVO.getSaleaccount_quantity()%>" /></td>
				</tr>
				<tr>
					<td>克數:</td>
					<td><input type="TEXT" name="weight" size="45"
						value="<%=productVO.getWeight()%>" /></td>
				</tr>
				<tr>
				<td>有效日期:</td>
					<td bgcolor="#CCCCFF">
				    <input class="cal-TextBox"
							onFocus="this.blur()" size="9" readonly type="text" name="deadline" value="<%=productVO.getDeadline()%>">
					<a class="so-BtnLink"
						href="javascript:calClick();return false;"
						onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
						onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
						onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','deadline','BTN_date');return false;">
		 		   <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="開始日期"></a>
					</td>
				</tr>
				<tr>
					<td>有效天數:</td>
					<td><input type="TEXT" name="deadlineday" size="45"
						value="<%=productVO.getDeadlineday()%>" /></td>
				</tr>
				<tr>
					<td>警示數量:</td>
					<td><input type="TEXT" name="product_alertquantity" size="45"
						value="<%=productVO.getProduct_alertquantity()%>" /></td>
				</tr>
				<tr>
					<td>產品介紹:</td>
					<td><input type="TEXT" name="product_description" size="45"
						value="<%=productVO.getProduct_description()%>" /></td>
				</tr>
				
				<jsp:useBean id="productSvc" scope="page"
					class="com.product.model.ProductService" />
				<!-- 	<tr> -->
				<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
				<!-- 		<td><select size="1" name="deptno"> -->
				<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
				<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname} --%>
				<%-- 			</c:forEach> --%>
				<!-- 		</select></td> -->
				<!-- 	</tr> -->

			</table>
			<br> <input type="hidden" name="action" value="update">
			<input type="hidden" name="product_no" value="<%=productVO.getProduct_no()%>"> 
			<input type="hidden" name="class_no" value="<%=productVO.getClass_no()%>"> 
			<input type="hidden" name="classdetail_no" value="<%=productVO.getClassdetail_no()%>"> 
			<input type="submit" value="送出修改">
		</FORM>
	</div>
</body>
<!-- </html> -->
