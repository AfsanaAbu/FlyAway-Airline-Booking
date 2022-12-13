<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url('img1.jpg');
  background-size: 1600px 750px;
}
</style>
<center>
<h1>Login Here!</h1>

<form action="Login" method="post">  
Username<input type="text" name="username"/><br/><br/>  
Password<input type="password" name="userpass"/><br/><br/>  
<input type="submit" value="SIGN IN"/>  
<a href="Register.html">REGISTER</a>
</form>

</center>
</body>
</html>