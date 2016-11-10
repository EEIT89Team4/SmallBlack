<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productclass.model.*"%>

<%
ProductClassVO productclassVO = (ProductClassVO) request.getAttribute("productclassVO");
%>
<style>
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
.box2{
	background-image: -moz-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%),-moz-linear-gradient(-90deg,rgba(0,0,0,0) 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%),-moz-linear-gradient(20deg,rgba(0,94,153,1) 45%, rgba(0,94,153,0) 45%),-moz-linear-gradient(-20deg,rgba(0,94,153,0) 55%, rgba(0,94,153,1) 55%),-moz-linear-gradient(-90deg,rgba(244,46,37,1) 5%, rgba(244,46,37,0) 5%,rgba(244,46,37,0) 29%,rgba(244,46,37,1) 29%),-moz-linear-gradient(0deg,rgba(244,46,37,1) 40%,rgba(255,255,0,1) 40%,rgba(255,255,0,1) 44%,rgba(244,46,37,1) 44%,rgba(244,46,37,1) 48%,rgba(255,255,0,1) 48%,rgba(255,255,0,1) 52%,rgba(244,46,37,1) 52%,rgba(244,46,37,1) 56%,rgba(255,255,0,1) 56%,rgba(255,255,0,1) 60%,rgba(244,46,37,1) 60% );
	background-image: -webkit-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%),-webkit-linear-gradient(-90deg,rgba(0,0,0,0) 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%),-webkit-linear-gradient(20deg,rgba(0,94,153,1) 45%, rgba(0,94,153,0) 45%),
					  -webkit-linear-gradient(-20deg,rgba(0,94,153,0) 55%, rgba(0,94,153,1) 55%),-webkit-linear-gradient(-90deg,rgba(244,46,37,1) 5%, rgba(244,46,37,0) 5%,rgba(244,46,37,0) 29%,rgba(244,46,37,1) 29%),-webkit-linear-gradient(0deg,rgba(244,46,37,1) 40%,rgba(255,255,0,1) 40%,rgba(255,255,0,1) 44%,rgba(244,46,37,1) 44%,rgba(244,46,37,1) 48%,rgba(255,255,0,1) 48%,rgba(255,255,0,1) 52%,rgba(244,46,37,1) 52%,rgba(244,46,37,1) 56%,rgba(255,255,0,1) 56%,rgba(255,255,0,1) 60%,rgba(244,46,37,1) 60% );
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
	$('#addProductClassBtn').click(function() {
		$.post('productclass.do',$("#form1").serialize(),function(data){
			if(data=="Error"){
				$('#addProductClassDiv').load('Error.jsp');
			}else{
			$('#addProductClassDiv').load('SuccessAddProductClass.jsp?' + data);
			}
		})
	});
});

</script>
<body bgcolor='white'>
	<div style="text-align: center;" id="addProductClassDiv">
	<div class="box box2" align="left"></div>


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
<div class="addSupplierForm">	
<h2>產品分類新增</h2> <a href="Supplier_DataTables.html">回首頁 </a>
		<FORM METHOD="post" name="form1" id="form1">
			<table border="0" align="center">

				<tr align='center' valign='middle'>
					<td>產品分類名稱:</td>
					<td><input type="TEXT" name="class_name" size="45"
						value="<%= (productclassVO==null)? "" : productclassVO.getClass_name()%>" /></td>
				</tr>
				<jsp:useBean id="productclassSvc" scope="page"
					class="com.productclass.model.ProductClassService" />

			</table>
			<br> <input type="hidden" name="action" value="insert">
			<input type="button" value="送出新增" id="addProductClassBtn">
		</FORM>
		</div>
	</div>
</body>

<!-- </html> -->
