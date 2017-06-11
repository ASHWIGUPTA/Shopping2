<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<table>
<tr><td>UserId</td>
<td><input type="number" name="userID"></td> 
</tr>
<tr><td>Password</td>
<td><input type="password" name="password"></td> 
</tr>
<tr><td><input type="submit" name="Login"></td>
<td><a href="forget">Forget Password</a>
</tr>
</table>

</form>
</body>
</html>