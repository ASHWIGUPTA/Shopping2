package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingWeb.connectDB.ConnectDb;

public class AddCategory extends HttpServlet {
	int id ;
	@Override
	public void init() throws ServletException {
	 id = 3;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Category_name");
		try {
			id = id++;
			Connection con = ConnectDb.getconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into category values(?,?);");
			System.out.println(id);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			int result =0; 
			result = pstmt.executeUpdate();
			if(result > 0){
				response.sendRedirect("index.jsp");
			}
			else{
				response.sendRedirect("error.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}}
