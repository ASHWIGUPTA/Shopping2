package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingWeb.connectDB.ConnectDb;

public class searchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstmt = null;
	String TextSearch = request.getParameter("textSearch");
	try {
		Connection con = ConnectDb.getconnection();
		pstmt = con.prepareStatement("");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	}

	

}

