<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Accordion - Default functionality</title>
  
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!--   <link rel="stylesheet" href="/resources/demos/style.css">  -->
<!--上面這行好像沒有用-->


  <!--上面是新的，下面是原本的   -->
  
<!--  	<link rel="stylesheet" href="css/bootstrap.min.css" /> -->
<!--  	<link rel="stylesheet" type="text/css" href="css/datatables.min.css" /> -->
<!-- 	<script src="js/jquery-1.12.3.min.js"></script> -->
<!-- 	<script src="js/bootstrap.min.js"></script> -->
<!-- 	<script src="js/datatables.min.js"></script> -->
  
  
  
  
  <script>

  $(function() {
	    $( "#accordion1" ).accordion({
	      collapsible: true
	    });
	  } );
  
  $(function () {
      $('#table1').DataTable({
         "ajax": "ProductAll",
         "columns": [
             { "data": "product_no" },
             { "data": "product_name" },
             { "data": "product_quantity" }
         ]
      });
  });
  
  
  
  </script>
 	
		

		
  <style>
.jianli_apply{
	display: block; 
	width: 260px;
	height: 50px;
	border: 1px solid #CCC;
	background: #9c9d9e;
/*  margin-top: 20px;  */
	line-height:50px;
	text-align:center
}
.jianli_apply a{ 
	font-size: 20px;
 	color:white;
 	} 
 .pokehead{
	display: block; 
	height: 80px;
	border: 1px solid #CCC;
	/* 	background: #00FFFF; */
	background:-webkit-linear-gradient(top left,#0000AA,#CCCCFF);
	color:white;
	/* margin-top: 20px; */
}
 
 
 
 
 
 
 
  </style>
  
  
</head>
<body>
<div class="pokehead">	
		<h1><font face="Arial Black">PokeSong後台系統</font></h1>
	</div>
<div class="col-md-2">
<div id="accordion1" style="width:300px">
  <h3>廠商相關</h3>
  <div>
	    <div class="jianli_apply"><a href="Supplier_DataTables.html">查詢廠商</a></div>
		<div class="jianli_apply"><a href="addSupplier.jsp">新增廠商</a></div>
		<div class="jianli_apply"><a href="listAllSupplier.jsp">修改刪除廠商資料</a></div>
  </div>
  <h3>產品相關</h3>
  <div>
   		<div class="jianli_apply"><a href="Product_DataTables.html">查詢產品剩餘數量</a></div>
		<div class="jianli_apply"><a href="UploadFile.html">產品進貨(From Excel)</a></div>
		<div class="jianli_apply"><a href="listAllProduct.jsp">修改產品資料</a></div>
		<div class="jianli_apply"><a href="addProduct.jsp">新增產品</a></div>
  </div>
  <h3>分類相關</h3>
  <div>
  		<div class="jianli_apply"><a href="addProductClass.jsp">新增產品分類</a></div>
  		<div class="jianli_apply"> <a href="listAllProductClass.jsp">修改產品分類</a></div>
		<div class="jianli_apply"><a href="addProductClassDetails.jsp">新增產品細部分類</a></div>
		<div class="jianli_apply"><a href="listAllProductClassDetails.jsp">修改產品細部分類</a></div>
  </div>
  <h3>會員相關</h3>
  <p>待更新啦幹</p>
</div>
</div>
 
<div class="col-md-10">
<jsp:include page="Product_DataTables2.html" />

</div>

</body>
</html>