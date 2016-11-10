<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
	ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java (Concroller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>

<!-- <html> -->
<!-- <head> -->
<!-- <title>�t�Ӹ�ƭק� - update_product_input.jsp</title> -->
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
				<td><h3>���~��ƭק� - update_product_input.jsp</h3> <a
					href="Product_DataTables.html">�^���� </a></td>
			</tr>
		</table>

		<!-- <h3>��ƭק�:</h3> -->
		<%-- ���~��C --%>
		<c:if test="${not empty errorMsgs}">
			<font color='red'>�Эץ��H�U���~:
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
					<td>���~�s��:<font color=red><b>*</b></font></td>
					<td><%=productVO.getProduct_no()%></td>
				</tr>
				<tr>
					<td>���~����:<font color=red><b>*</b></font></td>
					<td><%=productVO.getClass_no()%></td>
				</tr>
				<tr>
					<td>���~�ӳ�����:<font color=red><b>*</b></font></td>
					<td><%=productVO.getClassdetail_no()%></td>
				</tr>
				<tr>
					<td>���~�W��:</td>
					<td><input type="TEXT" name="product_name" size="45"
						value="<%=productVO.getProduct_name()%>" /></td>
				</tr>
				<tr>
					<td>����:</td>
					<td><input type="TEXT" name="product_price" size="45"
						value="<%=productVO.getProduct_price()%>" /></td>
				</tr>
				<tr>
					<td>���:</td>
					<td><input type="TEXT" name="unit" size="45"
						value="<%=productVO.getUnit()%>" /></td>
				</tr>
				<tr>
					<td>�t�ӦW��:</td>
					<td><input type="TEXT" name="supplier_name" size="45"
						value="<%=productVO.getSupplier_name()%>" /></td>
				</tr>
				<tr>
					<td>�ƶq:</td>
					<td><input type="TEXT" name="product_quantity" size="45"
						value="<%=productVO.getProduct_quantity()%>" /></td>
				</tr>
				<tr>
					<td>�ֿn�P��ƶq:</td>
					<td><input type="TEXT" name="saleaccount_quantity" size="45"
						value="<%=productVO.getSaleaccount_quantity()%>" /></td>
				</tr>
				<tr>
					<td>�J��:</td>
					<td><input type="TEXT" name="weight" size="45"
						value="<%=productVO.getWeight()%>" /></td>
				</tr>
				<tr>
				<td>���Ĥ��:</td>
					<td bgcolor="#CCCCFF">
				    <input class="cal-TextBox"
							onFocus="this.blur()" size="9" readonly type="text" name="deadline" value="<%=productVO.getDeadline()%>">
					<a class="so-BtnLink"
						href="javascript:calClick();return false;"
						onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
						onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
						onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','deadline','BTN_date');return false;">
		 		   <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="�}�l���"></a>
					</td>
				</tr>
				<tr>
					<td>���ĤѼ�:</td>
					<td><input type="TEXT" name="deadlineday" size="45"
						value="<%=productVO.getDeadlineday()%>" /></td>
				</tr>
				<tr>
					<td>ĵ�ܼƶq:</td>
					<td><input type="TEXT" name="product_alertquantity" size="45"
						value="<%=productVO.getProduct_alertquantity()%>" /></td>
				</tr>
				<tr>
					<td>���~����:</td>
					<td><input type="TEXT" name="product_description" size="45"
						value="<%=productVO.getProduct_description()%>" /></td>
				</tr>
				
				<jsp:useBean id="productSvc" scope="page"
					class="com.product.model.ProductService" />
				<!-- 	<tr> -->
				<!-- 		<td>����:<font color=red><b>*</b></font></td> -->
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
			<input type="submit" value="�e�X�ק�">
		</FORM>
	</div>
</body>
<!-- </html> -->
