<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login page</title>
<link rel="stylesheet" type="text/css" href=externalstyle.css> 
</head>
<body>

<h2>Login Page</h2>

<div class="container">
<form action="checker" method="post" >

    <label for="fname">Name</label>
    <input type="text" id="fname" name="name" placeholder="Your name..">

    <label for="pwd">Password</label>
    <input type="password" id="pwd" name="password" placeholder="Your password..">

    <button value="Submit">Submit</button>
  </form>
</div>

</body>
</html>
