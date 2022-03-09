<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>
<title>Insert title here</title>
</head>
<body>

 <%
     
 BussinessLayer bus = (BussinessLayer) request.getServletContext().getAttribute("api");
int customerID = Integer.parseInt(request.getParameter("customerID"));
    bus.setCustomerState(customerID, false);
   response.sendRedirect("customerbase.jsp");
%>

</body>
</html>