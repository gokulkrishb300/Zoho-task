<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page errorPage ="error.jsp"%>
    
<%@ page import="java.util.*,accountdeclare.*,logic.*" %>
<%@page errorPage ="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome customer</title>
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
</head>
<body>



<div class="split left">
<button onclick="window.location.href='transfer.jsp?refsan=1';">Transfer</button>
<form action="logout" method="post">
<button>log out</button>
</form>
</div>

<form action="" method="post">
<h2>Welcome Customer!</h2>
<table>
<tr><th>AccountID</th>
    <th>Branch</th>
    <th>Balance</th>
</tr>

<%

if(session.getAttribute("session")==null)
{
	RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
	
	dispatch.forward(request, response);
}


Map <Integer,Account> map=(Map<Integer,Account>)request.getAttribute("AccountMap");
System.out.print("mapping: "+map);
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