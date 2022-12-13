package com.flyaway;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		//Taking user inputs
		
		  String ufname=request.getParameter("ufname");
          String ulname=request.getParameter("ulname");
          int age = Integer.parseInt(request.getParameter("age"));
          int phone = Integer.parseInt(request.getParameter("ph"));
          String email=request.getParameter("eid");
		  String username=request.getParameter("username");
		  String pswd=request.getParameter("userpass");

         //Storing inputs(data) to database
          
          try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_system","root", "root");
        PreparedStatement pstmt = con.prepareStatement("insert into user_reg values(?,?,?,?,?,?,?)");
        
        pstmt.setString(1, ufname);
        pstmt.setString(2, ulname);
        pstmt.setInt(3, age);
        pstmt.setInt(4, phone);
        pstmt.setString(5, email);
        pstmt.setString(6, username);
        pstmt.setString(7, pswd);

        
        pstmt.execute();
        pstmt.close();
        System.out.println("Data Inserted Successfully");
        
        RequestDispatcher rd = request.getRequestDispatcher("/Booking.html");
        rd.forward(request, response);

          }catch(Exception e){
        	  System.out.println(e);
        	  
          }
          
          
          
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
