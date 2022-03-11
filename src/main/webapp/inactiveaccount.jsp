<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inactive Account's</title>
<jsp:include page="welcomeadmin.jsp"/>
</head>
<body>
<div class="split right">


<table>
<tr> <th>AccountID</th>
     <th>CustomerID</th>
     <th>Branch</th>
     <th>Balance</th>
     <th>Status</th>
</tr>
 
 <%
 
 if(session.getAttribute("customerId")==null)
 {
 	RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
 	
 	dispatch.forward(request, response);
 }

	List<Account> list = (List<Account>) request.getAttribute("AccountInactive");
    Iterator iter = list.iterator();
    while(iter.hasNext()){
	 Account account = (Account) iter.next();
	
%>

<tr>
<td> <%out.print(account.getAccountID()); %></td>
<td> <% out.print(account.getCustomerID()); %> </td>
<td> <% out.print(account.getBranchName()); %></td>
<td> <% out.print(account.getBankBalance()); %> </td>
<td> <button onclick="window.location.href='activateaccount.jsp?customerID=<%=account.getCustomerID()%>&accountID=<%=account.getAccountID()%>';"><% account.isStatus();%>Activate </button></td>
</tr>
<%
}
 %>


</table>
</div>
</body>
</html>