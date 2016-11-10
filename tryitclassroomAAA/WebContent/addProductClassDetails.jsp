<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productclassdetails.model.*"%>

<%
ProductClassdetailsVO productclassdetailsVO = (ProductClassdetailsVO) request.getAttribute("productclassdetailsVO");
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
.box4{
	background-image:-moz-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%),-moz-linear-gradient(-90deg, rgba(0,0,0,0) 45%, #3F5779 45%, #3F5779 55%, rgba(0,0,0,0) 55%),-moz-radial-gradient(left center,circle,rgba(0,0,0,1) 40px,rgba(254,199,11,1) 40px,rgba(254,199,11,1) 60px,rgba(254,199,11,0) 60px),-moz-radial-gradient(right center,circle,rgba(0,0,0,1) 40px,rgba(254,199,11,1) 40px,rgba(254,199,11,1) 60px,rgba(254,199,11,0) 60px),-moz-linear-gradient(-90deg, rgba(0,0,0,1) 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%);
	background-image:-webkit-radial-gradient(40% 40%,circle,rgba(0,0,0,.1) 40%,rgba(0,0,0,1) 100%),-webkit-linear-gradient(-90deg, rgba(0,0,0,0) 45%, #3F5779 45%, #3F5779 55%, rgba(0,0,0,0) 55%),-webkit-radial-gradient(left center,circle,rgba(0,0,0,1) 40px,rgba(254,199,11,1) 40px,rgba(254,199,11,1) 60px,rgba(254,199,11,0) 60px),-webkit-radial-gradient(right center,circle,rgba(0,0,0,1) 40px,rgba(254,199,11,1) 40px,rgba(254,199,11,1) 60px,rgba(254,199,11,0) 60px),-webkit-linear-gradient(-90deg, rgba(0,0,0,1) 45%, #333 45%, #3f3f3f 50%, #333 55%, #FFF 55%);
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
	$('#addProductClassDetailsBtn').click(function() {
		$.post('productclassdetails.do',$("#form1").serialize(),function(data){
			if(data=="Error"){
				$('#addProductClassDetailsDiv').load('Error.jsp');
			}else{
			$('#addProductClassDetailsDiv').load('SuccessAddProductDeatils.jsp?' + data);
			}
		})
	});
});
</script>

<body bgcolor='white'>
	<div style="text-align: center;" id="addProductClassDetailsDiv">
	<div class="box box4" align="left"></div>

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
<h3>產品細部分類新增</h3> <a href="Supplier_DataTables.html">回首頁 </a>
		<FORM METHOD="post" name="form1" id="form1">
			<table border="0" align="center">

				<jsp:useBean id="productclassSvc" scope="page" class="com.productclass.model.ProductClassService" />
				<tr>
					<td>產品分類名稱:<font color=red><b>*</b></font></td>
					<td><select size="1" name="class_no">
						<c:forEach var="productclassVO" items="${productclassSvc.all}">
							<option value="${productclassVO.class_no}" ${(productclassdetailsVO.productclassVO.class_no==productclassVO.class_no)? 'selected':'' } >${productclassVO.class_name}
						</c:forEach>
					</select></td>
				</tr>
				<tr align='center' valign='middle'>
					<td>產品細部分類名稱:</td>
					<td><input type="TEXT" name="classdetail_name" size="45"
						value="<%= (productclassdetailsVO==null)? "" : productclassdetailsVO.getClassdetail_name()%>" /></td>
				</tr>

				<jsp:useBean id="productclassdetailsSvc" scope="page"
					class="com.productclassdetails.model.ProductClassdetailsService" />


			</table>
			<br> <input type="hidden" name="action" value="insert">
			<input type="button" value="送出新增" id="addProductClassDetailsBtn">
		</FORM>
		</div>
	</div>
</body>

<!-- </html> -->
