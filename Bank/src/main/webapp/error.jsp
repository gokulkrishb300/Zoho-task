<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@page isErrorPage="true"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
<title>Soon fix it! Something fallen</title>
</head>
<body>
<p>Something went wrong!</p>
<% 
	if(exception!=null)
	{
		%>
	<p><%exception.printStackTrace();%></p>
	
	<% }%>
	
</body>

</html>