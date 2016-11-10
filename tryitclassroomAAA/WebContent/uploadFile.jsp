<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Uplaod File Sample</title>
</head>
<body>
    <form action="upLoadFile.do" method="post" enctype="multipart/form-data">
              選擇要上傳的EXCEL檔 :<input type="file" name="filename" value="upload" ><br>
      <input type="submit" value="Upload" name="upload" >
      <input type="hidden" name="action" value="upload">
    </form>
</body>
</html>