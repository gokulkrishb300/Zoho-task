<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
    <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>
<title>Add Account</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>


 <%
 if(session.getAttribute("session")==null)
 {
 	RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
		
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
 

<div class="split right bg-img">

  <% if(request.getAttribute("error")!=null)
		{%>
		
		<p><%out.print(request.getAttribute("error")); %></p>
		<%} %>

<form action="adate?accountID=0" method="post" class="container">

    
    
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
    
  

    <button class="btn">Register</button>
   <button type="reset" class="btn">Reset</button>
   
  </form>

</div>















<%} 
else { 

 if(session.getAttribute("session")==null)
	    {
	    	RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
			
			dispatch.forward(request, response);
	    } %>
<h2>Update account</h2>
<div class="split right bg-img">
<% if(request.getAttribute("error")!=null)
		{%>
		
		<p><%out.print(request.getAttribute("error")); %></p>
		<%} %>
<form  action="adate?accountID=<%=accountID%>" method="post" class="container">

    
    
     <label for="customerID">CustomerID</label>
     
    <input type="text" name="customerID" id="customerID"  value="<%out.print(request.getParameter("customerID")); %>" required>
    <br>
    
    
    <label for="branch">Branch</label>
    <select name="branch" id="branch" required>
    <option><%out.print(request.getParameter("branch")); %></option>
    <% Iterator iterBranch = list.iterator();
    		while(iterBranch.hasNext()){
	  Account account = (Account) iterBranch.next();%>
      <option><% out.print(account.getBranchName()); }%></option>
    </select><br>
    
    
    
     <label for="balance">Balance</label>
     
    
    <input type="number" name="balance" id="balance" value="<%out.print(request.getParameter("bal"));%>" required>
    <br>
    
  

    <button class="btn">Update</button>
   <button type="reset" class="btn">Reset</button>
  </form>
</div>



   <%} %>

</body>
</html>