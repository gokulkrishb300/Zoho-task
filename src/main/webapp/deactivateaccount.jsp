<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>
<title>deactivaion</title>
</head>
<body>
<form action="" method = "post">

 <%
 
 if(session.getAttribute("customerId")==null)
 {
 	RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
 	
 	dispatch.forward(request, response);
 }

 BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
int customerID = Integer.parseInt(request.getParameter("customerID"));
int accountID = Integer.parseInt(request.getParameter("accountID"));
    bus.setAccountState(customerID, accountID, false);
   response.sendRedirect("accountbase.jsp");
%>
</form>
</body>
</html>