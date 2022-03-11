<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inactive Customer's</title>
<jsp:include page="welcomeadmin.jsp"/>
</head>
<body>
<div class="split right">
<div class="floatright">
<button onclick="window.location.href='login.jsp';">log out</button>
</div>
<%
if(session.getAttribute("customerId")==null)
{
	RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
	
	dispatch.forward(request, response);
}
%>

<table>
      <tr><th>CustomerID</th>
          <th>Name</th>
          <th>Address</th>
          <th>Mobile</th>
          <th>Status</th>
      </tr>
      
      <%
       List<Customer> list = (List<Customer>) request.getAttribute("CustomerInactive");
       Iterator iter = list.iterator();
while(iter.hasNext()){
	 Customer customer = (Customer) iter.next();
	 %>
	 
	 <tr><td><% out.print(customer.getCustomerId()); %></td>
	     <td><% out.print(customer.getCustomerName()); %></td>
	     <td><% out.print(customer.getAddress()); %></td>
	     <td><% out.print(customer.getMobile()); %></td>
	     <td><button onclick="window.location.href='activatecustomer.jsp?customerID=<%=customer.getCustomerId()%>';"><%customer.getStatus();%>Activate</button></td>
	 </tr>
	 <% 
	 }
 %>

</table>
</div>
</body>
</html>