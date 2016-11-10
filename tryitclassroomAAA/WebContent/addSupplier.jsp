<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.supplier.model.*"%>

<%
SupplierVO supplierVO = (SupplierVO) request.getAttribute("supplierVO");
%>
<style>
.addSupplierTitle{
/* 	display: block;   */
    width: 1050px;    
/* 	height: 60px;   */
 	border: 1px solid #CCC; 
 	background:-webkit-linear-gradient(top left,#00DDDD,#FFFFFF); 
 	line-height:60px; 
 	text-align:center;
 	border-radius:20px;
 	float:left;
}
.addSupplierForm{
/* 	display: block;   */
/*   	width: 260px;   */
 	height: 250px;   
 	border: 1px solid #CCC; 
 	background:-webkit-linear-gradient(top left,#00DDDD,#FFFFFF); 
 	line-height:20px; 
 	text-align:center;
 	border-radius:20px;
}
.box{
	float:left;
	width: 200px;
	height: 200px;
	display:inline-block;
	margin:20px;
	position: relative;
	border: 6px solid #ccc;
	border-radius: 50%;
	background-image: -moz-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%), -moz-linear-gradient(-90deg, #f33 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%);
	background-image: -webkit-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%),-webkit-linear-gradient(-90deg, #f33 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%);
}
.box1{
	background-image: -moz-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%),-moz-linear-gradient(-90deg,rgba(0,0,0,0) 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%),-moz-linear-gradient(0deg,#F79905 45%, #333 45%, #3f3f3f 50%, #333 55%, #F79905 55%);
	background-image: -webkit-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%),-webkit-linear-gradient(-90deg,rgba(0,0,0,0) 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%),-webkit-linear-gradient(0deg,#F79905 45%, #333 45%, #3f3f3f 50%, #333 55%, #F79905 55%);
}
.box:before{
	content: "";
	display: block;
	position: absolute;
	z-index: 6;
	width: 20%;	
	height: 20%;
	background-color: #FFF;
	border-radius: 50%;
	box-shadow: 0 0 0 1px #AAA, 0 0 0 10px #fff, 0 0 0 16px #3f3f3f;
	margin: 40%;
}
.box:after{
	content: "";
	display: block;
	position: absolute;
	z-index: 1;
	width: 94%;
	height: 10%;
	background-color:rgba(0,0,0,0);
	margin: 45% 3%;
	box-shadow: 12px 0 0 #FFF, -12px 0 0 #FFF;
}



</style>
<script>
$(function() {
	$('#addSupplierBtn').click(function() {
		$.post('supplier.do',$("#form1").serialize(),function(data){
			if(data=="Error"){
				$('#addSupplierDiv').load('Error.jsp');
			}else{
			$('#addSupplierDiv').load('Success.jsp?' + data);
			}
		})
	});
});
</script>

<body bgcolor='white'>
	<div style="text-align: center" id="addSupplierDiv">
	<div class="box" align="left"></div>
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

<div class="addSupplierForm">
<h2>廠商資料新增</h2> <a href="Supplier_DataTables.html">回首頁 </a>
<!-- ACTION="supplier.do" 下面那行裡面的 -->
		<FORM METHOD="post" name="form1" id="form1">
			<table border="0" align="center">

				<tr align='center' valign='middle'>
					<td>廠商名:</td>
					<td><input type="TEXT" name="suppliername" size="45"
						value="<%= (supplierVO==null)? "" : supplierVO.getSupplier_name()%>" /></td>
				</tr>
				<tr align='center' valign='middle'>
					<td>負責人:</td>
					<td><input type="TEXT" name="chargepersonname" size="45"
						value="<%= (supplierVO==null)? "" : supplierVO.getChargeperson()%>" /></td>
				</tr>

				<jsp:useBean id="deptSvc" scope="page"
					class="com.supplier.model.SupplierService" />


			</table>
			<br> 
			<input type="hidden" name="action" value="insert">
			<input type="button" value="送出新增" id="addSupplierBtn">
		</FORM>
	</div>
	</div>
</body>

<!-- </html> -->
