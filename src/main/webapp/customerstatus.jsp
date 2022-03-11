<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer status</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>
<%
if(session.getAttribute("customerId")==null)
{
	RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
	
	dispatch.forward(request, response);
}
%>
<h2>Customer Status </h2>
<div class="container">
<form  method="post">

    <label for="id">Id</label>
    <input type="text" name="id" placeholder="Customer Id ..">

    <button>Activate</button>
    <button>De-Activate</button>
    
    <label for="status"></label>
    </form>
    </div>
    
</body>
</html>