<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Welcome admin!</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">

</head>
<h2>Welcome admin!</h2>

<%
if(session.getAttribute("customerId")==null)
{
	RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
	
	dispatch.forward(request, response);
}
%>
<body>		
<div class="split left">
<a href="customerbase.jsp"><button>Customer Base</button></a><br>
<a href="accountbase.jsp"><button>Account Base</button></a><br>
<a href="transfer.jsp?"><button>Transfer</button></a><br>
<button onclick="window.location.href='login.jsp';">log out</button>
</div>  

 <%
   BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
   request.setAttribute("CustomerMap", bus.getCustomerInfo());
   request.setAttribute("AccountList", bus.getInfo());
   request.setAttribute("CustomerInactive",bus.getDeactivedCustomer());
   request.setAttribute("AccountInactive",bus.getDeactivatedAccount());
   
    
%>
   

</body>
</html>