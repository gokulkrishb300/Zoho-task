<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
     <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>
<title>Add Customer</title>
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

int customerID=Integer.parseInt(request.getParameter("customerID"));
if(customerID==0){   %>
<h2>Add Customer</h2>
<div class="split right bg-img">

<form action="addcustomer?customerID=0" method="post"  class="container">

    <label for="name">Name</label>
    <input type="text" name="name" placeholder="customer name .." required><br>

    <label for="address">Address</label>
    <input type="text" name="address" placeholder="address .." required><br>

    <label for="mobile">Mobile</label>
    <input type="tel" id="pwd" name="mobile" placeholder="number .." required><br>

    <button class="btn">Register</button>
     <button type="reset" class="btn">Reset</button>
  </form>
</div>
<%}


 else{%>
 <h2>Update Customer</h2>
<div class="split right bg-img">
<form action="addcustomer?customerID=<%=customerID%>" method="post" class="container">

    <label for="name">Name</label>
    <input type="text" name="name" value="<%out.print(request.getParameter("name")); %>" required><br>

    <label for="address">Address</label>
    <input type="text" name="address" value="<%out.print(request.getParameter("address")); %>" required><br>

    <label for="mobile">Mobile</label>
    <input type="tel" id="pwd" name="mobile" value="<%out.print(request.getParameter("mobile")); %>" required><br>

    <button class="btn">Update</button>
   <button type="reset" class="btn">Reset</button>
  </form>
</div>
<%} %>
</body>
</html>