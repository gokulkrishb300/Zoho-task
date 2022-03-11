<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login page</title>
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
</head>
<body>


<div class="bg-img" >

<form action="checker" method="post" class="container">
    <h2>Login Page</h2>
    <label for="id">UserID    </label>
    <input type="number" id="id" name="userid" min="1000" placeholder="id here.." required><br>

    <label for="pwd">Password</label>
    <input type="password" id="pwd" name="password" placeholder="password here.." required><br>

    <button type="submit" class="btn">Submit</button>
    <button type="reset" class="btn">Reset</button>
    


<% if(request.getAttribute("error")!=null)
		{%>
		
		<p><%out.print(request.getAttribute("error")); %></p>
		<%} %>

</form>
</div>

<h6 class="rights">© 2022, Gokul Corporation Pvt. Ltd. All Rights Reserved.</h6>

</body>

</html>
