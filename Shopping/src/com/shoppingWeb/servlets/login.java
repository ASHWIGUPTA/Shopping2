package com.shoppingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mysql.jdbc.PreparedStatement;
import com.shoppingWeb.connectDB.ConnectDb;



public class login extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session=request.getSession(false);
			PrintWriter out= response.getWriter();
			int userId=Integer.parseInt(request.getParameter("userID"));	
String pass=request.getParameter("password");
Connection connection=null;
	ConnectDb con=new ConnectDb();
	PreparedStatement  pstmt=null;
	ResultSet rs=null;
	String tempPassword;
	int tempUserId;

  try {
	connection=con.getconnection();
	pstmt=(PreparedStatement) connection.prepareStatement("select customer_id, customer_pass from customer where customer_id=? and customer_pass=? ");
	pstmt.setInt(1,userId );
	pstmt.setString(2, pass);
	rs=pstmt.executeQuery();
	if(rs.next()==true){
		System.out.println("user is login........");
  session.setAttribute("UserId", userId);
  response.sendRedirect("index2.jsp");
	}
	else{
		System.out.println("wrong userId AND password");
		response.sendRedirect("SignUp.jsp");
	}
	
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}

			
	}

}
