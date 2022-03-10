<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"/>

<title>customerbase</title>
<h2>Customer Base</h2>

<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>



<div class="split right">

<div class="floatright">
<button onclick="window.location.href='login.jsp';">log out</button>
</div>
<div class="floatright">
<button onclick="window.location.href='addcustomer.jsp?customerID=0';">add</button>
</div>

<table>
      <tr><th>CustomerID</th>
          <th>Name</th>
          <th>Address</th>
          <th>Mobile</th>
          <th>Status</th>
      </tr>
 
 <%
 List<Customer> list = (List<Customer>) request.getAttribute("CustomerMap");
Iterator iter = list.iterator();
while(iter.hasNext()){
	 Customer customer = (Customer) iter.next();
	 %>
	 
	 <tr><td><button  onclick="window.location.href='addcustomer.jsp?customerID=<%=customer.getCustomerId()%>&name=<%=customer.getCustomerName()%>&address=<%=customer.getAddress()%>&mobile=<%=customer.getMobile()%>';"><% out.print(customer.getCustomerId()); %></button></td>
	     <td><% out.print(customer.getCustomerName()); %></td>
	     <td><% out.print(customer.getAddress()); %></td>
	     <td><% out.print(customer.getMobile()); %></td>
	     <td><button onclick="window.location.href='deactivatecustomer.jsp?customerID=<%=customer.getCustomerId()%>';"><%customer.getStatus();%>Deactivate</button></td>
	 </tr>
	 <% 
	 }
 %>

</table>
</div>

</body>
</html>