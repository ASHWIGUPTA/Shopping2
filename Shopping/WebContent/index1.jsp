<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.HashSet" %>
<%@ page import="com.shoppingWeb.POJO.ProductDTO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping Website</title>
</head>
<%! HashSet list=null;
public void jspInit(){
	System.out.print("****************");
	 list=new HashSet();

	}
	
	%>

<% 
ProductDTO pDto=new ProductDTO();
session=request.getSession(false);
System.out.print(session.toString()); 
if(session == null){
	//System.out.print("****************");
System.out.print("Session creted not....."); 
	response.sendRedirect("index.jsp");
	System.out.print("****************");

}
else
{

String pId=request.getParameter("xx");

list.add(Integer.parseInt(pId));
Iterator it=list.iterator();
while(it.hasNext()){
	System.out.println(it.next());
}
System.out.print("***");

session.setAttribute("ProductNo",list);
}%>
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
<form action="index1.jsp">
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