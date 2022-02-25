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
<button onclick="window.location.href='transfer.jsp';">Transfer</button>
</div>


<div class="split right container">

<form action="accountbase.jsp" method="post">

    <label for="name">Name</label>
    <input type="text" name="name" placeholder="customer name ..">

    <label for="address">Address</label>
    <input type="text" name="address" placeholder="address ..">
    
    <label for="gender">Gender</label>
    <input type="text"  name="gener" placeholder="gender ..">

    <label for="mobile">Mobile</label>
    <input type="tel" id="pwd" name="mobile" placeholder="number .."><br>

    <button  value="Submit">Submit</button>
   
  </form>
</div>
</body>
</html>