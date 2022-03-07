<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account</title>
<link rel="stylesheet" type="text/css" href="externalstyle.css">
</head>
<body>
<h2>Add Account </h2>
<div class="split left">
<button onclick="window.location.href='customerbase.jsp';" >Customer Base</button><br>
<button onclick="window.location.href='accountbase.jsp';">Account Base</button><br>
<button onclick="window.location.href='admintransfer.jsp';">Transfer</button>
</div>


<div class="split right container">

<form action="accountbase.jsp" method="post">

    <label for="name">CustomerID</label>
    <input type="text" name="name" placeholder="customerID here .."><br>

    <label for="accountNum">AccountNum</label>
    <input type="number" name="accountNum" placeholder="accountNum here .."><br>
    
    <label for="branch">Branch</label>
    <input type="text"  name="branch" placeholder="branch here .."><br>

    <label for="bal">Balance</label>
    <input type="number" id="bal" name="bal" placeholder="balance here .."><br>

    <button  value="Submit">Submit</button>
   
  </form>
</div>
</body>
</html>