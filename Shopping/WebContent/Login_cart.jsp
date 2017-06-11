<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shoppingWeb.POJO.ProductDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shoppingWeb.POJO.ProductDTO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession(false);
int userID=(int) session.getAttribute("UserId");
session.setAttribute("UserId", userID);
ArrayList<ProductDTO> product= (ArrayList<ProductDTO>)session.getAttribute("List");
session.setAttribute("List", product);
String productHTML = "";
if(product!=null && product.size()>0){
	for(ProductDTO productList : product){
			%>
	<form action="Login_Delete" method="post">
	<table>
	<tr><td><input type="image" src="<%=productList.getImg_path()%>"></td>
	<td><b>Price</b><%=productList.getPrice() %>
	<input type="hidden" name="productID" value=<%=productList.getId() %>>
	<h3> <%=productList.getId() %></h3>
	<td><input type="submit" value="Delete"name=xx></td>
	<td><input type="submit" value="Buy" name=xx><b><b></td>
	</tr>
	
	</table>
	</form>
	<% }}
else{
out.println("Cart is Empty....");	
}
%>

</body>
</html>