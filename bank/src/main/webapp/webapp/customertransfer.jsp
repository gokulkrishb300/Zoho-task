<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer</title>
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
</head>
<body>
<div class="floatright">
<button style="float:right"onclick="window.location.href='login.jsp';">log out</button>
</div>
<h2>Transfer</h2>

<div class="split left">
<button onclick="window.location.href='customertransfer.jsp';">Transfer</button>
</div>


<div class="container split right">
<form action="welcomecustomer.jsp" method="post">

    <label for="from">From</label>
    <input type="text" name="from" placeholder="From..">

    <label for="to">To</label>
    <input type="text" name="to" placeholder="To..">

    <button value="Transfer">Transfer</button>
  </form>
</div>

</body>
</html>