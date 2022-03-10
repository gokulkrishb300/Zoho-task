<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>
<title>account base</title>



<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>

<h2>Account Base</h2>

<div class="split right">
<div class="floatright">
<button onclick="window.location.href='login.jsp';">log out</button>
</div>
<div class="floatright">

<button onclick="window.location.href='addaccount.jsp?accountID=0';">add</button>
</div>

<table>
<tr> <th>AccountID</th>
     <th>CustomerID</th>
     <th>Branch</th>
     <th>Balance</th>
     <th>Status</th>
</tr>
 
 <%
	List<Account> list = (List<Account>) request.getAttribute("AccountList");
    Iterator iter = list.iterator();
    while(iter.hasNext()){
	 Account account = (Account) iter.next();
	
%>

<tr>
<td> <button name="accountID" onclick="window.location.href='addaccount.jsp?accountID=<%=account.getAccountID()%>&customerID=<%=account.getCustomerID()%>&branch=<%=account.getBranchName()%>&bal=<%=account.getBankBalance()%>';"><%out.print(account.getAccountID()); %></button></td>
<td> <% out.print(account.getCustomerID()); %> </td>
<td> <% out.print(account.getBranchName()); %></td>
<td> <% out.print(account.getBankBalance()); %> </td>
<td> <button onclick="window.location.href='deactivateaccount.jsp?customerID=<%=account.getCustomerID()%>&accountID=<%=account.getAccountID()%>';"><% account.isStatus();%>Deactivate </button></td>
</tr>
<%
}
 %>


</table>
</div>

</body>
</html>