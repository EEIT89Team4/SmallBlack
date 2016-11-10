<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO");
%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="content-type" content="text/html; charset=utf-8" /> -->
<!-- <title>產品資料新增 - addProduct.jsp</title> -->
<!-- </head> -->
<!-- <script src="js/jquery-1.12.3.min.js"></script> -->
<!-- <script src="js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="https://cdn.datatables.net/u/bs/jq-2.2.3,dt-1.10.12/datatables.min.css" /> -->
	<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<script>
$(function() {
	var myOption=$('#select1');
	myOption.empty();
	$.ajax({
		"type":"get",
		"url":"XMLServlet",
		"dataType":"xml",
		"data":{},
		"success":function(datas){
			$(datas).find("Category").each(function(){
				id=$(this).children("class_no").text();
				name=$(this).children("class_name").text();
				var opt = $('<option></option>').val(id).text(name)
				myOption.append(opt);
			})
		}	
	})
	
	$('#select1').change(function(){
		
				var myOption2=$('#select2');
				myOption2.empty();

				$.getJSON('ProductsD',{class_no:$(this).val()},function(datas){
					//ProductsD對應到ForProductClassDetails.java
					$.each(datas,function(idx,productclassdetail){
							//did=$(this).val(productclassdetail.classdetail_no).text();
					 		var opt2 = $('<option></option>').val(id).text(productclassdetail.classdetail_name).attr("value",productclassdetail.classdetail_no)
							myOption2.append(opt2); 		
					})	
				})
			})
// 	$('#select2').change(function(){
// 		$.getJSON('ProductsD',{class_no:$(this).val()},function(datas){
// 			//ProductsD對應到ForProductClassDetails.java
// 			$.each(datas,function(idx,productclassdetail){
// 					did=$(this).val(productclassdetail.classdetail_no).text();
// 			 		var opt2 = $('<option></option>').val(id).text(productclassdetail.classdetail_name)
// 					myOption2.append(opt2); 		
// 			})
// 	})
	
});



</script>
<!-- <link rel="stylesheet" type="text/css" href="js/calendar.css"> -->
<!-- <script language="JavaScript" src="js/calendarcode.js"></script> -->
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>
	<div style="text-align: center;">
		<table border='1'
			class="table table-bordered table-striped table-hover">
			<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
				<td><h3>產品資料新增 - addProduct.jsp</h3> <a
					href="Product_DataTables.html">回首頁 </a></td>
			</tr>
		</table>

		<!-- <h3>資料員工:</h3> -->
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

<%-- 				<jsp:useBean id="supplierSvc" scope="page" class="com.supplier.model.SupplierService" /> --%>
<!-- 				<tr> -->
<!-- 					<td>廠商名稱:<font color=red><b>*</b></font></td> -->
<!-- 					<td><select size="1" name="supplier_name"> -->
<%-- 						<c:forEach var="supplierVO" items="${supplierSvc.all}"> --%>
<%-- 						<option value="${supplierVO.supplier_name}" ${(productVO.supplier_name==supplierVO.supplier_name)? 'selected':'' } > --%>
<%-- 					</c:forEach> --%>
<!-- 					</select></td> -->
<!-- 				</tr> -->
				<jsp:useBean id="productclassSvc" scope="page" class="com.productclass.model.ProductClassService" />
				<jsp:useBean id="productclassdetailsSvc" scope="page" class="com.productclassdetails.model.ProductClassdetailsService" />
				<jsp:useBean id="supplierSvc" scope="page" class="com.supplier.model.SupplierService" />
<!-- 				<tr> -->
<!-- 					<td>產品分類名稱:<font color=red><b>*</b></font></td> -->
<!-- 					<td><select size="1" name="class_no"> -->
<%-- 						<c:forEach var="productclassVO" items="${productclassSvc.all}"> --%>
<%-- 						<option value="${productclassVO.class_no}" ${(productVO.class_no==productclassVO.class_no)? 'selected':'' } >${productclassVO.class_name} --%>
<%-- 					</c:forEach> --%>
<!-- 					</select></td> -->
<!-- 				</tr> -->
<!-- 					<tr> -->
<!-- 					<td>產品細部分類名稱:<font color=red><b>*</b></font></td> -->
<!-- 					<td><select size="1" name="classdetail_no"> -->
<%-- 						<c:forEach var="productclassdetailsVO" items="${productclassdetailsSvc.all}"> --%>
<%-- 						<option value="${productclassdetailsVO.classdetail_no}" ${(productVO.classdetail_no==productclassdetailsVO.classdetail_no)? 'selected':'' } >${productclassdetailsVO.classdetail_name} --%>
<%-- 					</c:forEach> --%>
<!-- 					</select></td> -->
<!-- 					</tr> -->
				<tr>
					<td>產品分類名稱:<font color=red><b>*</b></font></td>
					<td><select size="1" name="class_no" id="select1">
					</select></td>
				</tr>
				<tr>
					<td>產品細部分類名稱:<font color=red><b>*</b></font></td>
					<td><select size="1" name="classdetail_no" id="select2">
					</select></td>
				</tr>
				<tr>
					<td>廠商名稱:<font color=red><b>*</b></font></td>
					<td><select size="1" name="supplier_name">
						<c:forEach var="supplierVO" items="${supplierSvc.all}">
						<option value="${supplierVO.supplier_name}" ${(productVO.supplier_name==supplierVO.supplier_name)? 'selected':'' } >${supplierVO.supplier_name}
					</c:forEach>
					</select></td>
				</tr>
				<tr align='center' valign='middle'>
					<td>產品名稱:</td>
					<td><input type="TEXT" name="product_name" size="45"
						value="<%= (productVO==null)? "" : productVO.getProduct_name()%>" /></td>
				</tr>
				<tr align='center' valign='middle'>
					<td>單位:</td>
					<td><input type="TEXT" name="unit" size="45"
						value="<%= (productVO==null)? "" : productVO.getUnit()%>" /></td>
				</tr>
				<tr align='center' valign='middle'>
					<td>產品數量:</td>
					<td><input type="TEXT" name="product_quantity" size="45"
						value="<%= (productVO==null)? "" : productVO.getProduct_quantity()%>" /></td>
				</tr>
				<tr align='center' valign='middle'>
					<td>克數:</td>
					<td><input type="TEXT" name="weight" size="45"
						value="<%= (productVO==null)? "" : productVO.getWeight()%>" /></td>
				</tr>
				<tr>
					<td>價格:</td>
					<td><input type="TEXT" name="product_price" size="45"
						value="<%= (productVO==null)? "" : productVO.getProduct_price()%>" /></td>
				</tr>
					<tr>
				<td>有效日期:</td>
					<td bgcolor="#CCCCFF">
				    <input class="cal-TextBox"
							onFocus="this.blur()" size="9" readonly type="text" name="deadline" value="<%= (productVO==null)? "" : productVO.getDeadline()%>">
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
						value="<%=(productVO==null)? "" : productVO.getDeadlineday()%>" /></td>
				</tr>
				<tr>
					<td>警示數量:</td>
					<td><input type="TEXT" name="product_alertquantity" size="45"
						value="<%=(productVO==null)? "" : productVO.getProduct_alertquantity()%>" /></td>
				</tr>
				<tr>
					<td>產品介紹:</td>
					<td><input type="TEXT" name="product_description" size="45"
						value="<%= (productVO==null)? "" : productVO.getProduct_description()%>" /></td>
				</tr>

				<jsp:useBean id="productSvc" scope="page"
					class="com.product.model.ProductService" />


			</table>
			<br> <input type="hidden" name="action" value="insert">
			<input type="submit" value="送出新增">
		</FORM>
	</div>
</body>

<!-- </html> -->
