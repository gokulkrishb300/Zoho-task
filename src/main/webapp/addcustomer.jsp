<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>

<div class="split left">
<button onclick="window.location.href='customerbase.jsp';" >Customer Base</button><br>
<button onclick="window.location.href='accountbase.jsp';">Account Base</button><br>
<button onclick="window.location.href='admintransfer.jsp';">Transfer</button>
</div>
<%
 BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
 request.setAttribute("AccountList", bus.getInfo()); 
 List<Account> list = (List<Account>) request.getAttribute("AccountList");
 %>
 <%

int customerID=Integer.parseInt(request.getParameter("customerID"));
if(customerID==0){   %>
<h2>Add Customer</h2>
<div class="split right container">
<div class="floatright">
<button onclick="window.location.href='login.jsp';">log out</button>
</div>
<form action="addcustomer?customerID=0" method="post">

    <label for="name">Name</label>
    <input type="text" name="name" placeholder="customer name .."><br>

    <label for="address">Address</label>
    <input type="text" name="address" placeholder="address .."><br>

    <label for="mobile">Mobile</label>
    <input type="tel" id="pwd" name="mobile" placeholder="number .."><br>

    <button >Register</button>
   
  </form>
</div>
<%}


 else{%>
 <h2>Update Customer</h2>
<div class="split right container">
<div class="floatright">
<button onclick="window.location.href='login.jsp';">log out</button>
</div>
<form name="customerID" action="addcustomer?customerID=<%=customerID%>" method="post">

    <label for="name">Name</label>
    <input type="text" name="name" value="<%out.print(request.getParameter("name")); %>"><br>

    <label for="address">Address</label>
    <input type="text" name="address" value="<%out.print(request.getParameter("address")); %>"><br>

    <label for="mobile">Mobile</label>
    <input type="tel" id="pwd" name="mobile" value="<%out.print(request.getParameter("mobile")); %>"><br>

    <button >Update</button>
   
  </form>
</div>
<%} %>
</body>
</html>