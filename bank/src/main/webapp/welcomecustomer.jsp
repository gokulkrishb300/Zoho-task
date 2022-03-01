<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="java.util.*,customerinfo.CustomerInfo" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome customer</title>
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
</head>
<body>
<div class="floatright">
<button style="float:right"onclick="window.location.href='login.jsp';">log out</button>
</div>
<h2>Welcome Customer!</h2>
<div class="split left">
<button onclick="window.location.href='customertransfer.jsp';">Transfer</button>
</div>


<%Map<Integer,CustomerInfo> map = (Map<Integer,CustomerInfo>)request.getAttribute("CustomerDetails");
out.println(map);%> 

<form action="CustomerServlet" method="post">
<input type="submit" name="submit" value="submit" style="float: right;">
</form>
</body>
</html>