<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account base</title>

<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>
<div class="floatright">
<button style="float:right"onclick="window.location.href='login.jsp';">log out</button>
</div>
<div class="floatright">
<button style="float:right"onclick="window.location.href='addaccount.jsp';">add</button>
</div>
<h2>Account Base</h2>


<div class="split left">
<button onclick="window.location.href='customerbase.jsp';" >Customer Base</button><br>
<button onclick="window.location.href='accountbase.jsp';">Account Base</button><br>
<button onclick="window.location.href='admintransfer.jsp';">Transfer</button>
</div>


<div class="split right">
<table>
<tr> <th>ACCOUNT ID</th> 
     <th>CUSTOMER ID</th> 
     <th>ACCNUM</th>  
     <th>ACCTYPE</th>  
     <th>BRANCH</th>  
     <th>BALANCE</th>
     <th> DELETE </th>
</tr>
<tr> <td><a href="addaccount.jsp">2001</a></td>
     <td><a href="addcustomer.jsp">1001</a></td>
     <td>123</td>
     <td>Savings</td>
     <td>Karaikudi</td>
     <td>50000</td>  
     <td><button>delete</button> </td>
</tr>
</table>
</div>
</body>
</html>