<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="java.util.*,accountdeclare.*" %>


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

<form method= "post">
<table>
<tr><th>AccountNum</th>
    <th>Branch</th>
    <th>Balance</th>
</tr>

<%
Map<Integer, Account> map = (Map<Integer,Account>)request.getAttribute("AccountMap");

for(Map.Entry<Integer,Account> entry: map.entrySet()){
	Account account = entry.getValue();
	%>
	<tr><td><% out.print(account.getAccountID());%></td>
	    <td><% out.print(account.getBranchName()); %> </td>
	    <td><% out.print(account.getBankBalance());%> </td>
	</tr>
<% 
}
%> 
</table>
</form>


</body>
</html>