<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
     <%@page errorPage ="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>
<title>Insert title here</title>
</head>
<body>

 <%
 
 if(session.getAttribute("session")==null)
 {
 	RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
		
		dispatch.forward(request, response);
 }

 BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
int customerID = Integer.parseInt(request.getParameter("customerID"));
    bus.setCustomerState(customerID, false);
   response.sendRedirect("customerbase.jsp");
%>

</body>
</html>