<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�_�i��~~�e! �ӫ~�C��</title>
<style>
 .col-xs-4 {
	border-style: solid;
    border-width: 1px;
	width: 200px;
	height: 200px ;
}
.photo {
	width: 130px;
	height: 130px
}
.photo:hover {
	opacity: 0.5
}
.search {
	border-width: 1px;
	border-color: red;
	border-style: solid;
	display: inline-block
}
.fb-root .fb-share-button {display:inline-block}
</style>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta property="og:url"           content="https://www.google.com.tw/" />
	<meta property="og:type"          content="website" />
	<meta property="og:title"         content="�_�i��~~�e!" />
	<meta property="og:description"   content="�_�i��~~�e! ���x�̤j�ʪ�����" />
	<!-- <meta property="og:image"         content="http://www.your-domain.com/path/image.jpg" /> -->
</head>
<body>
	<form>
		<div class="search">
			<input id="searchbar" type="text"><span id="search"
				class="glyphicon glyphicon-bullhorn"></span>
	 <a href="javascript: void(window.open('http://www.facebook.com/share.php?u='.concat(encodeURIComponent(location.href)) ));">�������ɩ��y��</a>	 
		
		
		<!-- <div id="fb-root"></div> -->
	<!-- <script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
	
	 -->

	<!-- Your share button code -->
<!-- 	<div class="fb-share-button" 
		data-href="https://www.google.com.tw/" 
		data-layout="button">
	</div>	 -->
	
		
		</div>
		
		
		
		
		
	</form>
	<jsp:useBean id="productdao" class="com.product.model.ProductDAO" scope="page" />
	<div class="container">
		<div class="row">
			<c:forEach var="productitem" items="${productdao.allProduct}">
			

				<div class="col-xs-4">

					<div class="photo">123</div>
					�~�W:${productitem.product_name}<br>
					���:${productitem.product_price}<br>

				</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	var EleSpan = document.getElementById("search");
	var EleText = document.getElementById("searchbar");
	EleSpan.addEventListener("click", function() {
		if (!('webkitSpeechRecognition' in window)) {
			alert("do not support")
		} else {
			var recognition = new webkitSpeechRecognition();
			recognition.continuous = false;//�۰ʰ������
			recognition.interimResults = false;//�O�_�ߨ貣�Ϳ��Ѧr��
			recognition.lang = "cmn-Hant-TW";//���ѻy��
			recognition.start();//�}�l����
			recognition.onresult = function(event) {
				var i = event.resultIndex;
				var j = event.results[i].length - 1;
				var speechtext = event.results[i][j].transcript;
				if (speechtext.match("�ڭn�hYahoo")) {
					window.location.replace("http://www.yahoo.com.tw");
				} else {
					EleText.value = speechtext;
				}
			};

		}
	})
</script>