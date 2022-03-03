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
<form action="checker" method="post" >
<div class="container">


    <label for="id">YoUserID    </label>
    <input type="number" id="id" name="userid" placeholder="here id.."><br>

    <label for="pwd">Password</label>
    <input type="password" id="pwd" name="password" placeholder="here password.."><br>

    <button type="submit">Submit</button>
  
</div>
</form>
</body>
</html>
