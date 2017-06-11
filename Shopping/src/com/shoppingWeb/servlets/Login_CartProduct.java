package com.shoppingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.shoppingWeb.POJO.ProductDTO;
import com.shoppingWeb.connectDB.ConnectDb;

public class Login_CartProduct extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
		 	HttpSession session=request.getSession(false);
		 	if(session== null){
		 		response.sendRedirect("error.html");
		 	}

		int userID=(int) session.getAttribute("UserId");
		session.setAttribute("UserId", userID);
		ArrayList<ProductDTO> cartProduct=new ArrayList<ProductDTO>();
		ArrayList<Integer> pID=new ArrayList<Integer>();
		Connection connection=null;
		ConnectDb con=new ConnectDb();
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		int tempCart_Id=0;
		
		
		try {
			connection=con.getconnection();
			pstmt= (PreparedStatement) connection.prepareStatement("select cart_id  from cart where customer_id=?");
			pstmt.setInt(1, userID);
			rs=pstmt.executeQuery();
			System.out.println("query exicuted.......");
			if(rs.next()){
		     tempCart_Id=rs.getInt("cart_id");
			
		}
			
			pstmt=(PreparedStatement) connection.prepareStatement("select product_id from cart_products where cart_id=?");
			pstmt.setInt(1, tempCart_Id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				
				pID.add(rs.getInt("product_id"));
				
			}
			Iterator<Integer> it=pID.iterator();
			while(it.hasNext()){
				int ProID=it.next();
				pstmt=(PreparedStatement) connection.prepareStatement("select product_id, product_name,product_price,product_weight,product_dimensions,"
				  		+ " product_desc,product_quantity, img1 from product where product_id=?");		
				  pstmt.setInt(1,ProID );
				  rs = pstmt.executeQuery();
				  while(rs.next()){
					  ProductDTO pdto = new ProductDTO();
					  pdto.setName(rs.getString("product_name"));
					  pdto.setPrice(rs.getDouble("product_price"));
					  pdto.setWeight(rs.getString("product_weight"));
					  pdto.setDimensions("product_dimensions");
					  pdto.setDescr(rs.getString("product_desc"));
					  pdto.setQuantity(rs.getInt("product_quantity"));
					  pdto.setImg_path(rs.getString("img1"));
					  pdto.setId(rs.getInt("product_id"));
					  cartProduct.add(pdto);
					  System.out.println("COMPLETE");
				  }}
				
			session.setAttribute("List", cartProduct);
			  response.sendRedirect("Login_cart.jsp");
				
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}

		}
