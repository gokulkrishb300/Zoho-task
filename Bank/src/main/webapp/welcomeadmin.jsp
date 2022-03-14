<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
   <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Welcome admin!</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">

</head>



<body>		
<div class="split left">
<button onclick="window.location.href='customerbase.jsp';">Customer Base</button><br>
<button onclick="window.location.href='accountbase.jsp';">Account Base</button><br>
<button onclick="window.location.href='transfer.jsp?refsan=0';">Transfer</button><br>
<form action="logout" method="post">
<button>log out</button>
</form>

</div>  

 <%
 
 if(session.getAttribute("session")==null)
 {
 	RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
		
		dispatch.forward(request, response);
 }
   BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
   request.setAttribute("CustomerMap", bus.getCustomerInfo());
   request.setAttribute("AccountList", bus.getInfo());
   request.setAttribute("CustomerInactive",bus.getDeactivedCustomer());
   request.setAttribute("AccountInactive",bus.getDeactivatedAccount());
   
    
%>
   

</body>
</html>