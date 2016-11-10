<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productclassdetails.model.*"%>

<%
	ProductClassdetailsVO productclassdetailsVO = (ProductClassdetailsVO) request.getAttribute("productclassdetailsVO"); //EmpServlet.java (Concroller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>

<!-- <html> -->
<!-- <head> -->
<!-- <title>���~�ӳ�������ƭק� - update_productclassdetails_input.jsp</title> -->
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
				<td><h3>���~�ӳ�������ƭק� - update_productclassdetails_input.jsp</h3> <a
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

		<FORM METHOD="post" ACTION="productclassdetails.do" name="form1">
			<table border="0" align="center">
				<tr>
					<td>���~����:<font color=red><b>*</b></font></td>
					<td><%=productclassdetailsVO.getProductClassVO().getClass_name()%></td>
				</tr>
				<tr>
					<td>�첣�~�ӳ������W��:<font color=red><b>*</b></font></td>
					<td><%=productclassdetailsVO.getClassdetail_name()%></td>
				</tr>
				<tr>
					<td>�s���~�ӳ������W��:</td>
					<td><input type="TEXT" name="classdetail_name" size="45"
						value="<%=productclassdetailsVO.getClassdetail_name()%>" /></td>
				</tr>
				
				<jsp:useBean id="productclassdetailsSvc" scope="page"
					class="com.productclassdetails.model.ProductClassdetailsService" />
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
			<input type="hidden" name="classdetail_no" value="<%=productclassdetailsVO.getClassdetail_no()%>">
			<input type="hidden" name="class_no" value="<%=productclassdetailsVO.getProductClassVO().getClass_no()%>"> 
			<input type="hidden" name="classdetail_name" value="<%=productclassdetailsVO.getClassdetail_name()%>"> 
			<input type="submit" value="�e�X�ק�">
		</FORM>
	</div>
</body>
<!-- </html> -->
