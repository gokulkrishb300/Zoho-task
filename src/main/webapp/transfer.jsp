<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page errorPage ="error.jsp"%>
    <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href=externalstyle.css> 

<%if(request.getParameter("refsan")==null) {%>
<jsp:include page="welcomeadmin.jsp"/>
<title>Transfer</title>

</head>
<body>
<% if(session.getAttribute("session")==null)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
		dispatch.forward(request, response);
	}
	%>

 <%
 BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
 request.setAttribute("AccountList", bus.getInfo()); 
 List<Account> list = (List<Account>) request.getAttribute("AccountList");
 %>




<h2>Admin Transfer</h2>

	 
<div class="split right bg-img">

<form action="transfer?value=1" method="post">


  <label for="from">From</label>
    <select name="from" id="from">
      <option>Sender-ID</option>
      <% Iterator iter = list.iterator();
    		while(iter.hasNext()){
	  Account account = (Account) iter.next();%>
      <option><% out.print(account.getAccountID()); }%></option>	
    </select><br>
    

    <label for="to">To</label>
    <select name="to" id="to">
      <option>Receiver-ID</option>
      <% Iterator iter1 = list.iterator();
    		  while(iter1.hasNext()){
	          Account account = (Account) iter1.next();	%>
       <option><% out.print(account.getAccountID());} %></option>	
          
    </select><br>
    
     <label for="amount">Amount   </label>
    <input type="number" id="amount" name="amount" min="1" placeholder="amount here.."><br>

    <button >Transfer</button>
    
  </form>
</div>
<%} else{
%>
<div class="split left">
<button name="Transfer" onclick="window.location.href='transfer.jsp?transfer=1';">Transfer</button>
</div>

<%
 BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
 request.setAttribute("AccountList", bus.getInfo()); 
 List<Account> list = (List<Account>) request.getAttribute("AccountList");
 %>



<h2>Customer Transfer</h2>

	 
<div class="split right">
<div class="floatright">
<button onclick="window.location.href='login.jsp';">log out</button>
</div>
<form action="transfer?value=0" method="post">


  <label for="from">From</label>
    <select name="from" id="from">
      <option>Sender-ID</option>
      <% Iterator iter = list.iterator();
    		while(iter.hasNext()){
	  Account account = (Account) iter.next();%>
      <option><% out.print(account.getAccountID()); }%></option>	
    </select><br>
    

    <label for="to">To</label>
    <select name="to" id="to">
      <option>Receiver-ID</option>
      <% Iterator iter1 = list.iterator();
    		  while(iter1.hasNext()){
	          Account account = (Account) iter1.next();	%>
       <option><% out.print(account.getAccountID());} %></option>	
          
    </select><br>
    
     <label for="amount">Amount   </label>
    <input type="number" id="amount" name="amount" min="1" placeholder="amount here.."><br>

    <button>Transfer</button>
   <button type="reset">Reset</button>
  </form>
</div>
<%} %>
 


</body>
</html>