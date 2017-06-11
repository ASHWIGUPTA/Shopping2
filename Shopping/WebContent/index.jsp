<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shoppingWeb.POJO.ProductDTO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping Website</title>
</head>
<%session=request.getSession(true);
%>
<body>
	<form action="searchController" method="get">
		<input type="text" name="textSearch">
		<input type="submit" value="search">
	</form>
	
	<a href="addproduct.jsp">Add Products</a>
	<a href="addcategory.jsp">Add Category</a>
	<a href="login.jsp">SignUp</a>
	<a href="SignUp.jsp">SignIn</a>
	<a href="CartProduct">Cart</a>
<form action="index1.jsp" method="post">
<table>
</br>
<tr><td>
<input type="submit" name="xx" value="1">
<input type="submit" name="xx" value="2"> 
<input type="submit" name="xx" value="3"> 
<input type="submit" name="xx" value="4"> 
</tr>
</table>	</form>
</body>

</html>