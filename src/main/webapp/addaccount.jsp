<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>

<div class="split left">
<button onclick="window.location.href='customerbase.jsp';" >Customer Base</button><br>
<button onclick="window.location.href='accountbase.jsp';">Account Base</button><br>
<button onclick="window.location.href='admintransfer.jsp';">Transfer</button>
</div>
 <%
 
 if(session.getAttribute("customerId")==null)
 {
 	RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
 	
 	dispatch.forward(request, response);
 }
 
 BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
 request.setAttribute("AccountList", bus.getInfo()); 
 List<Account> list = (List<Account>) request.getAttribute("AccountList");
 %>
<%
int accountID=Integer.parseInt(request.getParameter("accountID"));

if(accountID==0){   %>
<h2>Add account </h2>
<div class="split right container">

<form >

</form>

<form action="adate?accountID=0" method="post" >

    
    
     <label for="customerID">CustomerID</label>
    <input type="text" name="customerID" id="customerID"  min= 1 required >
    <br>
    
    
    <label for="branch">Branch</label>
    <select name="branch" id="branch" required>
    <option>branch here..</option>
    <% Iterator iterBranch = list.iterator();
    		while(iterBranch.hasNext()){
	  Account account = (Account) iterBranch.next();%>
      <option><% out.print(account.getBranchName()); }%></option>
    </select><br>
    
     <label for="balance">Balance</label>
    <input type="number" name="balance" id="balance" min=1  required>
    <br>
    
  

    <button >Register</button>
   
  </form>
</div>















<%} 
else{ %>
<h2>Update account</h2>
<div class="split right container">

<form name="accountID" action="adate?accountID=<%=accountID%>" method="post" >

    
    
     <label for="customerID">CustomerID</label>
     
    <input type="text" name="customerID" id="customerID"  value="<%out.print(request.getParameter("customerID")); %>" >
    <br>
    
    
    <label for="branch">Branch</label>
    <select name="branch" id="branch">
    <option><%out.print(request.getParameter("branch")); %></option>
    <% Iterator iterBranch = list.iterator();
    		while(iterBranch.hasNext()){
	  Account account = (Account) iterBranch.next();%>
      <option><% out.print(account.getBranchName()); }%></option>
    </select><br>
    
    
    
     <label for="balance">Balance</label>
     
    
    <input type="number" name="balance" id="balance" value="<%out.print(request.getParameter("bal"));%>">
    <br>
    
  

    <button >Update</button>
   
  </form>
</div>



   <%} %>

</body>
</html>