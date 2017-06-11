package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.shoppingWeb.connectDB.ConnectDb;


public class Login_Delete extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(false);
		int userID=(int) session.getAttribute("UserId");
		int id=Integer.parseInt(request.getParameter("productID"));
		session.setAttribute("UserId", userID);
		Connection connection=null;
		ConnectDb con=new ConnectDb();
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		int tempTotalProduct = 0;
		int tempAddedProduct = 0;
		int tempCart_Id=0;
		
		try {
			connection=con.getconnection();
			pstmt= (PreparedStatement) connection.prepareStatement("select cart_id, total_products,added_products from cart where customer_id=?");
			pstmt.setInt(1, userID);
			rs=pstmt.executeQuery();
			System.out.println("query exicuted.......");
			if(rs.next()){
				tempCart_Id=rs.getInt("cart_id");
		     tempTotalProduct=rs.getInt("total_products");
			 tempAddedProduct=rs.getInt("added_products");
			System.out.println("cart Id is "+tempCart_Id);
			
			pstmt=(PreparedStatement) connection.prepareStatement("delete from cart_products where product_id=? and cart_id=?");
			pstmt.setInt(1, id);
			pstmt.setInt(2, tempCart_Id);
			int temp=pstmt.executeUpdate();
			if(temp==1){
				
				
				tempTotalProduct--;
				tempAddedProduct--;
				System.out.println(" Totel product "+tempAddedProduct);
				 pstmt= (PreparedStatement) connection.prepareStatement("update cart set total_products=?, added_products=? where cart_id=? ");// update totel product 
				   pstmt.setInt(1, tempTotalProduct);
				   pstmt.setInt(2, tempAddedProduct);
				   pstmt.setInt(3,tempCart_Id );
				   int temp2=pstmt.executeUpdate();
				   System.out.println(" temp value "+temp2);
				   if(temp2==1){
			System.out.println("Sucessfull Delete Item EveryWhere");
				   }	   } }}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			response.sendRedirect("Login_CartProduct");
		}
        
	}

}
