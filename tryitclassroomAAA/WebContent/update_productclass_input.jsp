<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productclass.model.*"%>

<%
	ProductClassVO productclassVO = (ProductClassVO) request.getAttribute("productclassVO"); //EmpServlet.java (Concroller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>

<!-- <html> -->
<!-- <head> -->
<!-- <title>�t�Ӥ�����ƭק� - update_productclass_input.jsp</title> -->
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
				<td><h3>���~������ƭק� - update_productclass_input.jsp</h3> <a
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

		<FORM METHOD="post" ACTION="productclass.do" name="form1">
			<table border="0" align="center">
				<tr>
					<td>���~�����s��:<font color=red><b>*</b></font></td>
					<td><%=productclassVO.getClass_no()%></td>
				</tr>
				<tr>
					<td>���~�W��:</td>
					<td><input type="TEXT" name="class_name" size="45"
						value="<%=productclassVO.getClass_name()%>" /></td>
				</tr>
				
				<jsp:useBean id="productclassSvc" scope="page"
					class="com.productclass.model.ProductClassService" />
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
			<input type="hidden" name="class_no" value="<%=productclassVO.getClass_no()%>"> 
			<input type="hidden" name="class_name" value="<%=productclassVO.getClass_name()%>"> 
			<input type="submit" value="�e�X�ק�">
		</FORM>
	</div>
</body>
<!-- </html> -->
