<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerbase</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>
<div class="floatright">
<button style="float:right"onclick="window.location.href='login.jsp';">log out</button>
</div>
<div class="floatright">
<button style="float:right"onclick="window.location.href='addcustomer.jsp';">add</button>
</div>
<h2>Customer Base</h2>
<div class="split left">
<button onclick="window.location.href='customerbase.jsp';" >Customer Base</button><br>
<button onclick="window.location.href='accountbase.jsp';">Account Base</button><br>
<button onclick="window.location.href='transfer.jsp';">Transfer</button>
</div>


<div class="split right">

<table>
<tr> <th>CUSTOMERID</th>
     <th> Name  </th>
     <th>AGE</th>
     <th>GENDER</th> 
     <th>ADDRESS</th> 
     <th>MOBILE </th> 
     <th> DELETE </th>
</tr>
<tr> <td><a href="addcustomer.jsp">1001</a></td>
     <td> Gokul </td> 
     <td> 21 </td>
     <td> male </td> 
    <td>Salem  </td> 
    <td>7010911394</td>
    <td><button>delete</button> </td>
</tr>
</table>
</div>
</body>
</html>