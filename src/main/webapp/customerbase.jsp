<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.util.*,accountdeclare.*,logic.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="welcomeadmin.jsp"></jsp:include>

<title>customerbase</title>
<h2>Customer Base</h2>

<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>



<div class="split right">

<div class="floatright">
<button style="float:right"onclick="window.location.href='login.jsp';">log out</button>
</div>
<div class="floatright">
<button style="float:right"onclick="window.location.href='addcustomer.jsp';">add</button>
</div>

<table>
      <tr><th>CustomerID</th>
          <th>Name</th>
          <th>Address</th>
          <th>Mobile</th>
          <th>Status</th>
      </tr>
 
 <%
 Map<Integer,Customer> map = (Map<Integer,Customer>) request.getAttribute("CustomerMap");
 for(Object key:map.keySet()){
	 Customer customer = map.get(key);
	 %>
	 
	 <tr><td><% out.print(customer.getCustomerId()); %></td>
	     <td><% out.print(customer.getCustomerName()); %></td>
	     <td><% out.print(customer.getAddress()); %></td>
	     <td><% out.print(customer.getMobile()); %></td>
	     <td><button>Deactivate</button></td>
	 </tr>
	 <% 
	 }
 %>

</table>
</div>

</body>
</html>