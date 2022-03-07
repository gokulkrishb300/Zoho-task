<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>
<title>Transfer</title>
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
</head>



<body>

<h2>Transfer</h2>
 <%
 BussinessLayer bus1 = (BussinessLayer) request.getServletContext().getAttribute("api");
 request.setAttribute("AccountList", bus1.getInfo()); 
 List<Account> list = (List<Account>) request.getAttribute("AccountList");
 %>
	 
<div class="split right">
<div class="floatright">
<button style="float:right"onclick="window.location.href='login.jsp';">log out</button>
</div>
<form action="transfer" method="post">


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

    <button type="submit">Transfer</button>
    
  </form>
</div>

 


</body>
</html>