<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome customer</title>
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
</head>
<body>
<h2>Welcome Customer!</h2>
<div class="split left">
<button onclick="window.location.href='customertransfer.jsp';">Transfer</button>
</div>

<div class="split right">
<table>
<tr> <th>ACCOUNT ID</th> 
     <th>CUSTOMER ID</th> 
     <th>ACCNUM</th>  
     <th>ACCTYPE</th>  
     <th>BRANCH</th>  
     <th>BALANCE</th>
    
</tr>
<tr> <td><a href="addaccount.jsp">2001</a></td>
     <td><a href="addcustomer.jsp">1001</a></td>
     <td>123</td>
     <td>Savings</td>
     <td>Karaikudi</td>
     <td>50000</td>  
    
</tr>
</table>
</div>

<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>