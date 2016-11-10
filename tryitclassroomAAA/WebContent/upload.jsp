<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
 <h2>導入標准xml關系模式</h2>
  <form name="upform" action="UploadServlet" method="POST" enctype="multipart/form-data">  
     <input type ="file" name="file1" id="file1"/><br/> 
         <input type ="file" name="file2" id="file2"/><br/>   
           <input type ="file" name="file3" id="file3"/><br/>  
              <input type="submit" value="Submit" /><br/>    
               <input type="reset" /> 
      </form>
</body>
</html>